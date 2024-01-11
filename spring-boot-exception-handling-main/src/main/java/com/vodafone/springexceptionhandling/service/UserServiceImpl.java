package com.vodafone.springexceptionhandling.service;

import com.vodafone.springexceptionhandling.domain.Role;
import com.vodafone.springexceptionhandling.domain.User;
import com.vodafone.springexceptionhandling.dto.RoleDto;
import com.vodafone.springexceptionhandling.dto.UserDto;
import com.vodafone.springexceptionhandling.exceptions.EntityNotFoundException;
import com.vodafone.springexceptionhandling.exceptions.RoleListEmptyException;
import com.vodafone.springexceptionhandling.exceptions.UserListEmptyException;
import com.vodafone.springexceptionhandling.mapper.UserMapperI;
import com.vodafone.springexceptionhandling.repository.RoleRepository;
import com.vodafone.springexceptionhandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserMapperI mapper; 
    
    @Override
    public User findById(int userId) {
    	User user =  userRepository.findById(userId)
               .orElseThrow(() -> new EntityNotFoundException("User Not Found with id : " + userId));
        return user;
    }
    
    @Override
    public Role findByRoleId(int roleId) {
    	Role role =  roleRepository.findById(roleId)
               .orElseThrow(() -> new EntityNotFoundException("Role Not Found with id : " + roleId));
        return role;
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
        Role role = findByRoleId(userDto.getRole().getId());
        role.setRoleName(userDto.getRole().getRoleName());
        user.setRole(role);

        return userRepository.save(user);
    }

	@Override
	public Role addRole(RoleDto roleDto) {
		Role role = new Role();
		role.setRoleName(roleDto.getRoleName());
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAllRole() {
		List<Role> roleList = roleRepository.findAll();
		
		if (roleList == null || roleList.isEmpty()) {
			new RoleListEmptyException("Role List Not Found.");
		}
		
		return roleList;
	}

	@Override
	public void deleteRole(Integer roleId) {
		Role role =  findByRoleId(roleId);
		if (role == null) {
			new EntityNotFoundException("Role Not Found with id : " + roleId);
		} else {
			roleRepository.deleteById(roleId);
		}
	}
}
