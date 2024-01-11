package com.vodafone.springexceptionhandling.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vodafone.springexceptionhandling.domain.Role;
import com.vodafone.springexceptionhandling.domain.User;
import com.vodafone.springexceptionhandling.dto.RoleDto;
import com.vodafone.springexceptionhandling.dto.UserDto;
import com.vodafone.springexceptionhandling.service.UserService;

@Component
public class UserMapperImpl implements UserMapperI {
	
	@Autowired
	private UserService service;
	
	@Override
	public User getConvertFromDtoUserToEntityUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserCompany(userDto.getUserCompany());
        user.setUserCode(userDto.getUserCode());
        user.setUserDepartment(userDto.getUserDepartment());
        user.setUserEmail(userDto.getUserEmail());
        Role role = service.findByRoleId(userDto.getRole().getId());
        role.setRoleName(userDto.getRole().getRoleName());
        user.setRole(role);
		return user;
	}

	
	@Override
	public UserDto getConvertFromDtoUserToEntityUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUserCompany(user.getUserCompany());
		userDto.setUserCode(user.getUserCode());
		userDto.setUserDepartment(user.getUserDepartment());
		userDto.setUserEmail(user.getUserEmail());
        RoleDto roleDto = new RoleDto();
        roleDto.setId(user.getRole().getId());
        roleDto.setRoleName(user.getRole().getRoleName());
		userDto.setRole(roleDto);
		return userDto;
	}

}
