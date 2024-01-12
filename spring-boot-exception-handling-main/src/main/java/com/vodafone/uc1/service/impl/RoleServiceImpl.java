package com.vodafone.uc1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.uc1.domain.Role;
import com.vodafone.uc1.dto.RoleDto;
import com.vodafone.uc1.exceptions.EntityNotFoundException;
import com.vodafone.uc1.exceptions.RoleListEmptyException;
import com.vodafone.uc1.repository.RoleRepository;
import com.vodafone.uc1.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
    @Autowired
    private RoleRepository roleRepository;
	
    @Override
    public Role findByRoleId(int roleId) {
    	Role role =  roleRepository.findById(roleId)
               .orElseThrow(() -> new EntityNotFoundException("Role Not Found with id : " + roleId));
        return role;
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
	
	@Override
	public Role updateRole(RoleDto roleDto) {
		Role role = findByRoleId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());

        return roleRepository.save(role);
	}
}
