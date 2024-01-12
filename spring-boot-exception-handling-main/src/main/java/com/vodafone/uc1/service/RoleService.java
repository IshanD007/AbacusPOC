package com.vodafone.uc1.service;

import java.util.List;

import com.vodafone.uc1.domain.Role;
import com.vodafone.uc1.dto.RoleDto;

public interface RoleService {

	Role addRole(RoleDto roleDto);
    
    List<Role> findAllRole();
    
    Role findByRoleId(int roleId);
    
    void deleteRole(Integer roleId);
    
    Role updateRole(RoleDto roleDto);
}
