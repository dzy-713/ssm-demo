package com.rl.mes.service;

import com.rl.mes.dao.FunMapper;
import com.rl.mes.pojo.Burn;
import com.rl.mes.pojo.Exterior;
import com.rl.mes.pojo.Fun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能测试service
 *
 */
@Service
public class FunService {

    @Autowired
    private FunMapper funMapper;
    @Autowired
    private BurnService burnService;


    /**
     * 获取列表
     *
     * @return
     */
    public List<Fun> getAll() {
        return funMapper.search(new HashMap());
    }

    /**
     * 通过条码获取列表
     *
     * @return
     */
    public List<Fun> getListByBarcode(String barcode) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("barcode", barcode);
        return funMapper.search(map);
    }


    /**
     * 保存or更新
     *
     * @param fun
     */
    public Fun doSave(Fun fun) throws Exception {
        //查询exterior数据是否存在，不存在不允许上传
        if (StringUtils.isEmpty(fun.getBarcode())) {
            throw new Exception("条码字段不能为空");
        }
        List<Burn> list = burnService.getListByBarcode(fun.getBarcode());
        if (list == null || list.size() == 0) {
            throw new Exception("条码[" + fun.getBarcode() + "]的烧录校验数据尚未上传！");
        }

        //查询旧数据
        List<Fun> oldList = getListByBarcode(fun.getBarcode());
        if (oldList != null && oldList.size() > 0) {
            Fun old = oldList.get(0);
            fun.setId(old.getId());
            funMapper.update(fun);
        } else {
            funMapper.insert(fun);
        }
        return fun;
    }


    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        funMapper.delete(id);
    }



    /**
     * 查询条码数据是否测试通过
     *
     * @return
     */
    public void validPassByBarcode(String barcode) throws Exception {
        List<Fun> list = getListByBarcode( barcode);
        if(list==null||list.size()==0){
            throw new Exception("条码["+barcode+"]前工序测试数据不存在");
        }
        Fun fun = list.get(0);
        if(!"pass".equals(fun.getPass())){
            throw new Exception("条码["+barcode+"]前工序测试数据不是通过状态！");
        }
    }

}
