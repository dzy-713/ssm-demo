package com.rl.mes.service;

import com.rl.mes.dao.RoleMapper;
import com.rl.mes.pojo.Role;
import com.rl.mes.pojo.RoleDto;
import com.rl.mes.pojo.ZTreeDto;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色service
 *
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;


    /**
     * 获取角色列表
     *
     * @return
     */
    public List<Role> getAllRole() {
        return roleMapper.search(new HashMap());
    }


    /**
     * 通过id获取角色详情
     *
     * @param id
     * @return
     */
    public Role getRoleById(String id) {
        return roleMapper.findById(id);
    }

    /**
     * 通过账号获取角色详情
     *
     * @param account
     * @return
     */
    public Role getRoleByAccount(String account) {
        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        List<Role> roleList = roleMapper.search(map);
        if (roleList == null || roleList.size() == 0) {
            return new Role();
        }
        return roleList.get(0);
    }

    /**
     * 保存or更新
     *
     * @param role
     */
    public Role doSave(Role role) throws Exception {
        Role old = roleMapper.findByCode(role.getCode(),role.getId()==null?null:role.getId().toString());
        if(old!=null){
            throw new Exception("角色["+old.getCode()+"]已存在");
        }
        if (StringUtils.isEmpty(role.getId())) {
            roleMapper.insert(role);
            role = roleMapper.findByCode(role.getCode(),null);
            return role;
        } else {
            roleMapper.update(role);
            return role;
        }
    }

    /**
     * 更新权限
     *
     * @param roleDto
     */
    public void updatePermission(RoleDto roleDto) {
        //删除关联
        roleMapper.deleteRolePermission(roleDto.getId().toString());
        //更新关联
        if(roleDto.getPermissionList()!=null&&roleDto.getPermissionList().size()>0){
            roleMapper.saveRolePermission(roleDto.getId().toString(), roleDto.getPermissionList());
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    public void doDelete(String id) {
        roleMapper.delete(id);
        //删除关联
        roleMapper.deleteRolePermission(id);
    }

    /**
     * 获取用户角色树
     * @param user
     * @return
     */
    public List<ZTreeDto> getRoleTree(String user){
        return roleMapper.getRoleTree(user==null?"":user);
    }
}
