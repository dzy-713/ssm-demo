package com.rl.mes.service;

import com.rl.mes.dao.PressureMapper;
import com.rl.mes.pojo.Fun;
import com.rl.mes.pojo.Pressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 压力测试service
 *
 */
@Service
public class PressureService {

    @Autowired
    private PressureMapper pressureMapper;
    @Autowired
    private FunService funService;


    /**
     * 获取列表
     *
     * @return
     */
    public List<Pressure> getAll() {
        return pressureMapper.search(new HashMap());
    }

    /**
     * 通过条码获取列表
     *
     * @return
     */
    public List<Pressure> getListByBarcode(String barcode) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("barcode", barcode);
        return pressureMapper.search(map);
    }


    /**
     * 保存or更新
     *
     * @param pressure
     */
    public Pressure doSave(Pressure pressure) throws Exception {
        //查询fun数据是否存在，不存在不允许上传
        if(StringUtils.isEmpty(pressure.getBarcode())){
            throw new Exception("条码字段不能为空");
        }
        List<Fun> list = funService.getListByBarcode(pressure.getBarcode());
        if(list==null||list.size()==0){
            throw new Exception("条码["+pressure.getBarcode()+"]的功能测试数据尚未上传！");
        }

        //查询旧数据
        List<Pressure> oldList = getListByBarcode(pressure.getBarcode());
        if (oldList != null && oldList.size() > 0) {
            Pressure old = oldList.get(0);
            pressure.setId(old.getId());
            pressureMapper.update(pressure);
        } else {
            pressureMapper.insert(pressure);
        }
        return pressure;
    }


    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        pressureMapper.delete(id);
    }


    /**
     * 查询条码数据是否测试通过
     *
     * @return
     */
    public void validPassByBarcode(String barcode) throws Exception {
        List<Pressure> list = getListByBarcode( barcode);
        if(list==null||list.size()==0){
            throw new Exception("条码["+barcode+"]前工序测试数据不存在");
        }
        Pressure pressure = list.get(0);
        if(!"pass".equals(pressure.getPass())){
            throw new Exception("条码["+barcode+"]前工序测试数据不是通过状态！");
        }
    }


}
