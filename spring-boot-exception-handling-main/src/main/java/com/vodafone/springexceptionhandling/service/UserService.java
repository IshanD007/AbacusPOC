package com.vodafone.springexceptionhandling.service;

import java.util.List;

import com.vodafone.springexceptionhandling.domain.Role;
import com.vodafone.springexceptionhandling.domain.User;
import com.vodafone.springexceptionhandling.dto.RoleDto;
import com.vodafone.springexceptionhandling.dto.UserDto;

public interface UserService {

    User findById(int employeeId);

    User add(UserDto userDto);

    List<User> findAll();
    
    void deleteUser(Integer userId);
    
    User update(UserDto userDto);
    
    Role addRole(RoleDto roleDto);
    
    List<Role> findAllRole();
    
    Role findByRoleId(int roleId);
    
    void deleteRole(Integer roleId);

}
