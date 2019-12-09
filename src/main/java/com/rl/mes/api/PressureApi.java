package com.rl.mes.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mes.pojo.ApiResVo;
import com.rl.mes.pojo.Fun;
import com.rl.mes.pojo.Pressure;
import com.rl.mes.pojo.PressureDto;
import com.rl.mes.service.PressureService;
import com.rl.mes.util.DateUtil;
import com.rl.mes.util.LayerTableDto;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 压力测试接口
 *
 */
@Api(description = "压力测试接口", value = "压力测试接口")
@RestController
@RequestMapping("/api/pressure")
public class PressureApi {

    @Autowired
    private PressureService pressureService;


    /**
     * 获取列表
     *
     * @param page  页码
     * @param limit 分页大小
     * @return
     */
    @ApiOperation(value = "查看列表", notes = "查看列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public LayerTableDto getUserList(@RequestParam(value = "page") int page,
                                     @RequestParam(value = "limit") int limit,
                                     @RequestParam(value = "barcode",required = false) String barcode) {
        LayerTableDto<Pressure> dto = new LayerTableDto();
        PageHelper.startPage(page, limit);
        List<Pressure> list = pressureService.getListByBarcode(StringUtils.isEmpty(barcode)?null:barcode);
        PageInfo<Pressure> pageInfo = new PageInfo<>(list);
        dto.setCount(pageInfo.getTotal());
        dto.setData(list);
        return dto;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping({"/delete"})
    public String delete(@RequestParam("id") String id) {
        pressureService.doDelete(id);
        return "success";
    }

    /**
     * 保存
     *
     * @param pressureDto
     * @return
     */
    @ApiOperation(value = "保存", notes = "保存")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ApiResVo save(@RequestBody PressureDto pressureDto) {
        Pressure pressure = new Pressure();
        BeanUtils.copyProperties(pressureDto, pressure);
        pressure.setTestTime(DateUtil.formatDate(pressureDto.getTestTime(),"yyyy-MM-dd HH:mm:ss"));
        try {
            //保存和校验
            pressureService.doSave(pressure);
        } catch (Exception e) {
            return ApiResVo.error(e.getMessage());
        }
        return ApiResVo.success();
    }

    /**
     * 查看条码数据是否存在
     *
     * @return
     */
    @ApiOperation(value = "查看条码数据是否存在", notes = "查看条码数据是否存在")
    @RequestMapping(value = "/isExist", method = RequestMethod.GET)
    @ResponseBody
    public ApiResVo barcodeIsExist(@RequestParam(value = "barcode") String barcode) {
        if(StringUtils.isEmpty(barcode)){
            return ApiResVo.error("条码不能为空");
        }
        List<Pressure> list = pressureService.getListByBarcode(barcode);
        if(list!=null&&list.size()>0){
            return ApiResVo.success(true);
        }else{
            return ApiResVo.success(false);
        }
    }
}
