package com.rl.mes.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mes.pojo.ApiResVo;
import com.rl.mes.pojo.Exterior;
import com.rl.mes.pojo.ExteriorDto;
import com.rl.mes.service.ExteriorService;
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
 * 外观检查接口
 *
 */
@Api(description = "外观检查接口", value = "外观检查接口")
@RestController
@RequestMapping("/api/exterior")
public class ExteriorApi {

    @Autowired
    private ExteriorService exteriorService;


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
        LayerTableDto<Exterior> dto = new LayerTableDto();
        PageHelper.startPage(page, limit);
        List<Exterior> list = exteriorService.getListByBarcode(StringUtils.isEmpty(barcode)?null:barcode);
        PageInfo<Exterior> pageInfo = new PageInfo<>(list);
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
        exteriorService.doDelete(id);
        return "success";
    }

    /**
     * 保存
     *
     * @param exteriorDto
     * @return
     */
    @ApiOperation(value = "保存", notes = "保存")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ApiResVo save(@RequestBody ExteriorDto exteriorDto) {
        Exterior exterior = new Exterior();
        BeanUtils.copyProperties(exteriorDto, exterior);
        exterior.setTestTime(DateUtil.formatDate(exteriorDto.getTestTime(),"yyyy-MM-dd HH:mm:ss"));
        try {
            //保存和校验
            exteriorService.doSave(exterior);
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
        List<Exterior> list = exteriorService.getListByBarcode(barcode);
        if(list!=null&&list.size()>0){
            return ApiResVo.success(true);
        }else{
            return ApiResVo.success(false);
        }
    }
}
