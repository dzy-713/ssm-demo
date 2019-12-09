package com.rl.mes.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.rl.mes.dao.BurnMapper;
import com.rl.mes.pojo.Burn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 烧录service
 *
 */
@Service
public class BurnService {

    @Autowired
    private BurnMapper burnMapper;


    /**
     * 获取列表
     *
     * @return
     */
    public List<Burn> getAll() {
        return burnMapper.search(new HashMap());
    }

    /**
     * 通过条码获取列表
     *
     * @return
     */
    public List<Burn> getListByBarcode(String barcode) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("barcode", barcode);
        return burnMapper.search(map);
    }

    /**
     * 查询条码数据是否测试通过
     *
     * @return
     */
    public void validPassByBarcode(String barcode) throws Exception {
        List<Burn> list = getListByBarcode( barcode);
        if(list==null||list.size()==0){
            throw new Exception("条码["+barcode+"]前工序测试数据不存在");
        }
        Burn burn = list.get(0);
        if(!"pass".equals(burn.getPass())){
            throw new Exception("条码["+barcode+"]前工序测试数据不是通过状态！");
        }
    }



    /**
     * 获取列表（分页）
     *
     * @param pageBegin 页码
     * @param pageSize  页大小
     * @return
     */
    public List<Burn> getListByPage(Integer pageBegin, Integer pageSize) {
        Integer page = (pageBegin == null || pageBegin < 1) ? 0 : pageBegin - 1;
        Integer size = (pageSize == null) ? 10 : pageSize;

        PageHelper.startPage(page, size);
        List<Burn> list = burnMapper.search(new HashMap());
        PageInfo<Burn> pageInfo = new PageInfo<>(list);

        return list;
    }

    /**
     * 保存or更新
     *
     * @param burn
     */
    public Burn doSave(Burn burn) throws Exception {
        if (StringUtils.isEmpty(burn.getBarcode())) {
            throw new Exception("条码字段不能为空");
        } else {
            //查询旧数据
            List<Burn> oldList = getListByBarcode(burn.getBarcode());
            if(oldList!=null&&oldList.size()>0){
                Burn old = oldList.get(0);
                burn.setId(old.getId());
                burnMapper.update(burn);
            }else{
                burnMapper.insert(burn);
            }
            return burn;
        }
    }


    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        burnMapper.delete(id);
    }


}
