package com.rl.mes.api;

import com.github.pagehelper.PageInfo;
import com.rl.mes.pojo.ApiResVo;
import com.rl.mes.pojo.PickData;
import com.rl.mes.service.PickDataService;
import com.rl.mes.util.LayerTableDto;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rl.mes.pojo.ApiResVo.error;


/**
 * 采集数据接口
 *
 */
@Api(description = "采集数据接口", value = "采集数据接口")
@RestController
@RequestMapping("/api/pickData")
public class PickDataApi {

    @Autowired
    private PickDataService pickDataService;


    /**
     * 获取列表
     *
     * @return
     */
    @ApiOperation(value = "查看列表", notes = "查看列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public LayerTableDto getUserList(@RequestParam(value = "barcode", required = false) String barcode) {
        LayerTableDto<PickData> dto = new LayerTableDto();
        List<PickData> list = pickDataService.getListByBarcode(StringUtils.isEmpty(barcode) ? null : barcode);
        PageInfo<PickData> pageInfo = new PageInfo<>(list);
        dto.setCount(pageInfo.getTotal());
        dto.setData(list);
        return dto;
    }

    /**
     * 获取列表
     *
     * @return
     */
    @ApiOperation(value = "查询条码前工序数据是否合法", notes = "查询条码前工序数据是否合法")
    @RequestMapping(value = "/isPreTestPass", method = RequestMethod.GET)
    @ResponseBody
    public ApiResVo getPreTestPass(@ApiParam("条码")@RequestParam(value = "barcode") String barcode,
                                   @ApiParam("当前工站(烧录、功能、压力、外观、称重)") @RequestParam(value = "station")String station) {
        try {
            Boolean result = pickDataService.getPreTestPass(barcode,station);
            return ApiResVo.success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }


}
