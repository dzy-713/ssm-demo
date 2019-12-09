package com.rl.mes.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mes.pojo.ApiResVo;
import com.rl.mes.pojo.Burn;
import com.rl.mes.pojo.BurnDto;
import com.rl.mes.service.BurnService;
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
 * 烧录接口
 *
 */
@Api(description = "烧录接口", value = "烧录接口")
@RestController
@RequestMapping("/api/burn")
public class BurnApi {

    @Autowired
    private BurnService burnService;


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
        LayerTableDto<Burn> dto = new LayerTableDto();
        PageHelper.startPage(page, limit);
        List<Burn> list = burnService.getListByBarcode(StringUtils.isEmpty(barcode)?null:barcode);
        PageInfo<Burn> pageInfo = new PageInfo<>(list);
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
        burnService.doDelete(id);
        return "success";
    }

    /**
     * 保存
     *
     * @param burnDto
     * @return
     */
    @ApiOperation(value = "保存", notes = "保存")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ApiResVo save(@RequestBody BurnDto burnDto) {
        Burn burn = new Burn();
        BeanUtils.copyProperties(burnDto, burn);
        burn.setTestTime(DateUtil.formatDate(burnDto.getTestTime(),"yyyy-MM-dd HH:mm:ss"));
        try {
            //保存和校验
            burnService.doSave(burn);
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
        List<Burn> list = burnService.getListByBarcode(barcode);
        if(list!=null&&list.size()>0){
            return ApiResVo.success(true);
        }else{
            return ApiResVo.success(false);
        }
    }
}
