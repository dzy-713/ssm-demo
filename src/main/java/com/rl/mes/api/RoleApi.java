package com.rl.mes.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mes.pojo.ApiResVo;
import com.rl.mes.pojo.Role;
import com.rl.mes.pojo.RoleDto;
import com.rl.mes.service.RoleService;
import com.rl.mes.util.LayerTableDto;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 角色接口
 */
@RestController
@RequestMapping("/api/role")
public class RoleApi {

    @Autowired
    private RoleService roleService;


    /**
     * 获取角色列表
     * @param page 页码
     * @param limit 分页大小
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public LayerTableDto getRoleList(@RequestParam(value = "page")int page,
                                     @RequestParam(value = "limit")int limit) {
        LayerTableDto<Role> dto = new LayerTableDto();
        PageHelper.startPage(page,limit);
        List<Role> list = roleService.getAllRole();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        dto.setCount(pageInfo.getTotal());
        dto.setData(list);
        return dto;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping({"/delete"})
    public String delete(@RequestParam("id") String id) {
        roleService.doDelete(id);
        return "success";
    }

    /**
     * 保存
     * @param roleDto
     * @return
     */
    @RequestMapping({"/save"})
    public ApiResVo save(@RequestBody RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        try{
            //保存和校验
            role =  roleService.doSave(role);
            //id赋值
            roleDto.setId(role.getId());
            //更新权限
            roleService.updatePermission(roleDto);
        }catch (Exception e){
            return ApiResVo.error(e.getMessage());
        }
        return ApiResVo.success();
    }

}
