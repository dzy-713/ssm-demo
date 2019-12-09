package com.rl.mes.service;

import com.rl.mes.dao.ExteriorMapper;
import com.rl.mes.pojo.Exterior;
import com.rl.mes.pojo.Pressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 外观检查service
 *
 */
@Service
public class ExteriorService {

    @Autowired
    private ExteriorMapper exteriorMapper;
    @Autowired
    private PressureService pressureService;


    /**
     * 获取列表
     *
     * @return
     */
    public List<Exterior> getAll() {
        return exteriorMapper.search(new HashMap());
    }

    /**
     * 通过条码获取列表
     *
     * @return
     */
    public List<Exterior> getListByBarcode(String barcode) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("barcode", barcode);
        return exteriorMapper.search(map);
    }


    /**
     * 保存or更新
     *
     * @param exterior
     */
    public Exterior doSave(Exterior exterior) throws Exception {
        //查询burn数据是否存在，不存在不允许上传
        if (StringUtils.isEmpty(exterior.getBarcode())) {
            throw new Exception("条码字段不能为空");
        }
        List<Pressure> list = pressureService.getListByBarcode(exterior.getBarcode());
        if (list == null || list.size() == 0) {
            throw new Exception("条码[" + exterior.getBarcode() + "]的压力测试数据尚未上传！");
        }

        //查询旧数据
        List<Exterior> oldList = getListByBarcode(exterior.getBarcode());
        if (oldList != null && oldList.size() > 0) {
            Exterior old = oldList.get(0);
            exterior.setId(old.getId());
            exteriorMapper.update(exterior);
        } else {
            exteriorMapper.insert(exterior);
        }
        return exterior;

    }


    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        exteriorMapper.delete(id);
    }


    /**
     * 查询条码数据是否测试通过
     *
     * @return
     */
    public void validPassByBarcode(String barcode) throws Exception {
        List<Exterior> list = getListByBarcode(barcode);
        if (list == null || list.size() == 0) {
            throw new Exception("条码[" + barcode + "]前工序测试数据不存在");
        }
        Exterior exterior = list.get(0);
        if (!"pass".equals(exterior.getPass())) {
            throw new Exception("条码[" + barcode + "]前工序测试数据不是通过状态！");
        }
    }


}
