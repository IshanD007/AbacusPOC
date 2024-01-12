package com.vodafone.uc1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.domain.Role;
import com.vodafone.uc1.domain.User;
import com.vodafone.uc1.dto.OperatorDto;
import com.vodafone.uc1.dto.RoleDto;
import com.vodafone.uc1.dto.UserDto;
import com.vodafone.uc1.exceptions.EntityNotFoundException;
import com.vodafone.uc1.exceptions.UserListEmptyException;
import com.vodafone.uc1.mapper.UserMapperI;
import com.vodafone.uc1.repository.UserRepository;
import com.vodafone.uc1.service.OperatorService;
import com.vodafone.uc1.service.RoleService;
import com.vodafone.uc1.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserMapperI mapper; 
    
    @Autowired
    private OperatorService operatorService;
    
    @Override
    public User findById(int userId) {
    	User user =  userRepository.findById(userId)
               .orElseThrow(() -> new EntityNotFoundException("User Not Found with id : " + userId));
        return user;
    }
    
    @Override
    public User add(UserDto createUserDto) {
    	User user = mapper.getConvertFromDtoUserToEntityUser(createUserDto);
        return userRepository.save(user);
    }

	@Override
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		
		if (userList == null || userList.isEmpty()) {
			new UserListEmptyException("User List Not Found.");
		}
		
		return userList;
	}
	
	@Override
	public void deleteUser(Integer userId) {
		User user =  findById(userId);
		if (user == null) {
			new EntityNotFoundException("User Not Found with id : " + userId);
		} else {
			userRepository.deleteById(userId);
		}
	}
	
	@Override
    public User update(UserDto userDto) {
    	User user = findById(userDto.getId());
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

        return userRepository.save(user);
    }


}
