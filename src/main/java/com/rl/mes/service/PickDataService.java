package com.rl.mes.service;

import com.rl.mes.dao.PickDataMapper;
import com.rl.mes.pojo.PickData;
import com.rl.mes.util.StringUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据采集service
 *
 */
@Service
public class PickDataService {

    @Autowired
    private PickDataMapper mapper;
    @Autowired
    private BurnService burnService;
    @Autowired
    private ExteriorService exteriorService;
    @Autowired
    private FunService funService;
    @Autowired
    private PressureService pressureService;


    /**
     * 通过条码获取列表
     *
     * @return
     */
    public List<PickData> getListByBarcode(String barcode) {
        if (StringUtils.isEmpty(barcode)) {
            return new ArrayList<>();
        }
        return mapper.getListByBarcode(barcode);
    }

    /**
     * 查询条码数据是否前工序测试通过
     * @param barcode 条码
     * @param station 当前工站
     * @return
     * @throws Exception
     */
    public Boolean getPreTestPass(String barcode,String station) throws Exception{
        if(StringUtils.isEmpty(barcode)){
            throw new Exception("条码字段不能为空");
        }
        if(StringUtils.isEmpty(station)){
            throw new Exception("当前工站不能为空");
        }
        switch (station){
            case "烧录":return true;
            case "功能":burnService.validPassByBarcode(barcode);break;
            case "压力":funService.validPassByBarcode(barcode);break;
            case "外观":pressureService.validPassByBarcode(barcode);break;
            case "称重":exteriorService.validPassByBarcode(barcode);break;
            default:throw new Exception("上传[工站]参数不在(烧录、功能、压力、外观、称重)列表内");
        }
        return true;
    }

}
