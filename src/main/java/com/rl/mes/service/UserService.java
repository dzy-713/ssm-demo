package com.rl.mes.service;

import com.rl.mes.dao.UserMapper;
import com.rl.mes.pojo.User;
import com.rl.mes.pojo.UserDto;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户service
 *
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 获取用户列表
     *
     * @return
     */
    public List<User> getAllUser() {
        return userMapper.search(new HashMap());
    }

    /**
     *
     * @return
     */
    /**
     * 获取用户列表（分页）
     *
     * @param pageBegin 页码
     * @param pageSize  页大小
     * @return
     */
    public List<User> getUserByPage(Integer pageBegin, Integer pageSize) {
        Integer page = (pageBegin == null || pageBegin < 1) ? 0 : pageBegin - 1;
        Integer size = (pageSize == null) ? 20 : pageSize;
        return userMapper.searchByLimit(new HashMap<>(), page * size, size);
    }

    /**
     * 通过id获取用户详情
     *
     * @param id
     * @return
     */
    public User getUserById(String id) {
        return userMapper.findById(id);
    }

    /**
     * 通过账号获取用户详情
     *
     * @param account
     * @return
     */
    public User getUserByAccount(String account) {
        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        List<User> userList = userMapper.search(map);
        if (userList==null||userList.size()==0){
            return new User();
        }
        return userList.get(0);
    }

    /**
     * 保存or更新
     *
     * @param user
     */
    public User doSave(User user) throws Exception {
        User old = userMapper.findByAccount(user.getAccount(),user.getId()==null?null:user.getId().toString());
        if(old!=null){
            throw new Exception("账号["+old.getAccount()+"]已存在");
        }
        if (StringUtils.isEmpty(user.getId())) {
            userMapper.insert(user);
            user = userMapper.findByAccount(user.getAccount(),null);
            return user;
        } else {
            userMapper.update(user);
            return user;
        }
    }

    /**
     * 更新用户角色关联关系
     * @param userDto
     */
    public void updateUserRole(UserDto userDto){
        //删除关联
        userMapper.deleteUserRole(userDto.getId().toString());
        //更新关联
        if(userDto.getRoleList()!=null&&userDto.getRoleList().size()>0){
            userMapper.saveUserRole(userDto.getId().toString(), userDto.getRoleList());
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        userMapper.delete(id);
    }

    /**
     * 通过用户账号获取关联权限
     * @param userAccount
     * @return
     */
    public List<String> getUserPermission(String userAccount){
        if(userAccount==null) return new ArrayList<>();
        return userMapper.getUserPermission(userAccount);
    }

    /**
     * 验证用户是否存在
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    public User valid(String account, String password) throws AuthenticationException{
        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        map.put("password", password);
        List<User> userList = userMapper.search(map);
        if (userList == null || userList.size() == 0) {
            throw  new AuthenticationException("账号密码不正确,请检查后重试");
        } else {
            User user = userList.get(0);
            if(user.getAllowLogin()==null||user.getAllowLogin()==false){
                throw new AuthenticationException("登录账号已关闭，请联系管理员修改");
            }
            return user;
        }
    }
}
