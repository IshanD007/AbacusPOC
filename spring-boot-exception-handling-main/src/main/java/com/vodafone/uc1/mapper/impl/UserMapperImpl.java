package com.vodafone.uc1.mapper.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.domain.Role;
import com.vodafone.uc1.domain.User;
import com.vodafone.uc1.dto.CountryDto;
import com.vodafone.uc1.dto.OperatorDto;
import com.vodafone.uc1.dto.RegionDto;
import com.vodafone.uc1.dto.RegionTypeDto;
import com.vodafone.uc1.dto.RoleDto;
import com.vodafone.uc1.dto.UserDto;
import com.vodafone.uc1.mapper.UserMapperI;
import com.vodafone.uc1.service.OperatorService;
import com.vodafone.uc1.service.RoleService;
import com.vodafone.uc1.service.UserService;

@Component
public class UserMapperImpl implements UserMapperI {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private OperatorService operatorService;
	
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
        Set<Role> roles = new HashSet<>();
        for(RoleDto roleDto: userDto.getRoles()) {
        	Role role = roleService.findByRoleId(roleDto.getId());
        	//role.setRoleName(userDto.getRole().getRoleName());
        	roles.add(role);
        }
        user.setRoles(roles);
        
        Set<Operator> operators = new HashSet<>();
        for(OperatorDto operatorDto: userDto.getOperatorDtos()) {
        	Operator operator = operatorService.findByOperatorId(operatorDto.getId());
        	operators.add(operator);
        }
        user.setOperators(operators);
		return user;
	}

	
	@Override
	public UserDto getConvertFromEntityUserToDtoUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUserCompany(user.getUserCompany());
		userDto.setUserCode(user.getUserCode());
		userDto.setUserDepartment(user.getUserDepartment());
		userDto.setUserEmail(user.getUserEmail());
		Set<RoleDto> roleDtos = new HashSet<>();
		for(Role role : user.getRoles()) {
			RoleDto roleDto = new RoleDto();
			roleDto.setId(role.getId());
			roleDto.setRoleName(role.getRoleName());
			roleDtos.add(roleDto);
		}
		userDto.setRoles(roleDtos);
		
		
		Set<OperatorDto> operatorDtos = new HashSet<>();
		for(Operator operator : user.getOperators()) {
			
		OperatorDto operatorDto = new OperatorDto();
		operatorDto.setId(operator.getId());
		operatorDto.setOperatorName(operator.getOpertorName());
		
		CountryDto countryDto = new CountryDto();
		countryDto.setId(operator.getCountry().getId());
		countryDto.setCountryName(operator.getCountry().getCountryName());
		
		RegionDto regionDto = new RegionDto();
		regionDto.setId(operator.getCountry().getRegion().getId());
		regionDto.setRegionName(operator.getCountry().getRegion().getRegionName());
		
		RegionTypeDto regionTypeDto = new RegionTypeDto();
		regionTypeDto.setId(operator.getCountry().getRegion().getRegionType().getId());
		regionTypeDto.setRegionTypeName(operator.getCountry().getRegion().getRegionType().getRegionTypeName());
		
		regionDto.setRegionTypeDto(regionTypeDto);
		countryDto.setRegionDto(regionDto);
		
		operatorDto.setCountryDto(countryDto);
		
		operatorDtos.add(operatorDto);
		}
		
		userDto.setOperatorDtos(operatorDtos);
		return userDto;
	}

}
