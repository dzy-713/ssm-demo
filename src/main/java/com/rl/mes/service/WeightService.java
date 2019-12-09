package com.rl.mes.service;

import com.rl.mes.dao.WeightMapper;
import com.rl.mes.pojo.Exterior;
import com.rl.mes.pojo.Pressure;
import com.rl.mes.pojo.Weight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 称重检查service
 *
 */
@Service
public class WeightService {

    @Autowired
    private WeightMapper weightMapper;
    @Autowired
    private ExteriorService exteriorService;


    /**
     * 获取列表
     *
     * @return
     */
    public List<Weight> getAll() {
        return weightMapper.search(new HashMap());
    }

    /**
     * 通过条码获取列表
     *
     * @return
     */
    public List<Weight> getListByBarcode(String barcode) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("barcode", barcode);
        return weightMapper.search(map);
    }


    /**
     * 保存or更新
     *
     * @param weight
     */
    public Weight doSave(Weight weight) throws Exception {
        //查询pressure数据是否存在，不存在不允许上传
        if(StringUtils.isEmpty(weight.getBarcode())){
            throw new Exception("条码字段不能为空");
        }
        List<Exterior> list = exteriorService.getListByBarcode(weight.getBarcode());
        if(list==null||list.size()==0){
            throw new Exception("条码["+weight.getBarcode()+"]的外观检测数据尚未上传！");
        }

        //查询旧数据
        List<Weight> oldList = getListByBarcode(weight.getBarcode());
        if (oldList != null && oldList.size() > 0) {
            Weight old = oldList.get(0);
            weight.setId(old.getId());
            weightMapper.update(weight);
        } else {
            weightMapper.insert(weight);
        }
        return weight;
    }


    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        weightMapper.delete(id);
    }


    /**
     * 查询条码数据是否测试通过
     *
     * @return
     */
    public void validPassByBarcode(String barcode) throws Exception {
        List<Weight> list = getListByBarcode( barcode);
        if(list==null||list.size()==0){
            throw new Exception("条码["+barcode+"]前工序测试数据不存在");
        }
        Weight weight = list.get(0);
        if(!"pass".equals(weight.getPass())){
            throw new Exception("条码["+barcode+"]前工序测试数据不是通过状态！");
        }
    }


}
