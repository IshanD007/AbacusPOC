package com.vodafone.uc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.uc1.domain.Role;
import com.vodafone.uc1.dto.RoleDto;
import com.vodafone.uc1.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
    @GetMapping("/{roleId}")
    public ResponseEntity<Role> findUserById(@PathVariable("roleId") int roleId) {
        Role role = roleService.findByRoleId(roleId);

        return new ResponseEntity<>(role,HttpStatus.OK);
    }

	@PostMapping("/addRole")
    public ResponseEntity<Role> addRole(@RequestBody RoleDto roleDto) {
        Role role = roleService.addRole(roleDto);

        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }
    
    @GetMapping("/findRoles")
    public ResponseEntity<List<Role>> findRoleList() {
    	List<Role> roleList = roleService.findAllRole();

        return new ResponseEntity<>(roleList,HttpStatus.OK);
    }
    
    @PutMapping("/updateRole")
    public ResponseEntity<Role> updateRole(@RequestBody RoleDto roleDto) {
    	Role role = roleService.updateRole(roleDto);

        return new ResponseEntity<>(role, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/deleteRole/{roleId}")
    public ResponseEntity<String> deleteRoleById(@PathVariable("roleId") int roleId) {
    	roleService.deleteRole(roleId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
