package com.rl.mes.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mes.dao.UserMapper;
import com.rl.mes.pojo.ApiResVo;
import com.rl.mes.pojo.User;
import com.rl.mes.pojo.UserDto;
import com.rl.mes.pojo.UserPwdDto;
import com.rl.mes.service.UserService;
import com.rl.mes.util.LayerTableDto;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rl.mes.pojo.ApiResVo.error;


/**
 * 用户接口
 *
 */
@Api(description = "用户接口", value = "用户接口")
@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    /**
     * 获取用户列表
     *
     * @param page  页码
     * @param limit 分页大小
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public LayerTableDto getUserList(@RequestParam(value = "page") int page,
                                     @RequestParam(value = "limit") int limit) {
        LayerTableDto<User> dto = new LayerTableDto();
        PageHelper.startPage(page, limit);
        List<User> list = userService.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(list);
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
        userService.doDelete(id);
        return "success";
    }

    /**
     * 保存
     *
     * @param userDto
     * @return
     */
    @RequestMapping({"/save"})
    public ApiResVo save(@RequestBody UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setAllowLogin(Boolean.parseBoolean(userDto.getAllowLogin()));
        try {
            //保存和校验
            user = userService.doSave(user);
            //id赋值
            userDto.setId(user.getId());
            //更新权限
            userService.updateUserRole(userDto);
        } catch (Exception e) {
            return error(e.getMessage());
        }
        return ApiResVo.success();
    }

    /**
     * 修改密码
     *
     * @param userPwdDto
     * @return
     */
    @RequestMapping({"/updatePwd"})
    public ApiResVo updatePwd(@RequestBody UserPwdDto userPwdDto) {
        try{
            userService.valid(userPwdDto.getAccount(),userPwdDto.getOldPwd());
        }catch (AuthenticationException e){
            return error(e.getMessage());
        }
        User user = userService.getUserByAccount(userPwdDto.getAccount());
        user.setPassword(userPwdDto.getPassword());
        userMapper.update(user);
        return ApiResVo.success();
    }


    /**
     * 用户验证
     *
     * @return
     */
    @ApiOperation(value = "用户验证", notes = "用户验证")
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public ApiResVo validUser(@RequestParam(value = "account") String account, @RequestParam(value = "pwd") String pwd) {
        try {
            User user = userService.valid(account, pwd);
            return ApiResVo.success(user);
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}
