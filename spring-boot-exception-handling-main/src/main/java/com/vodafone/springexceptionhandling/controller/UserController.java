package com.vodafone.springexceptionhandling.controller;

import com.vodafone.springexceptionhandling.domain.Role;
import com.vodafone.springexceptionhandling.domain.User;
import com.vodafone.springexceptionhandling.dto.RoleDto;
import com.vodafone.springexceptionhandling.dto.UserDto;
import com.vodafone.springexceptionhandling.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") int userId) {
        User user = userService.findById(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        User user = userService.add(userDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @GetMapping("/findUsers")
    public ResponseEntity<List<User>> findUserList() {
    	List<User> userList = userService.findAll();

        return new ResponseEntity<>(userList,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteById(@PathVariable("userId") int userId) {
    	userService.deleteUser(userId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
    	User user = userService.update(userDto);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/addRole")
    public ResponseEntity<Role> addRole(@RequestBody RoleDto roleDto) {
        Role role = userService.addRole(roleDto);

        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }
    
    @GetMapping("/findRoles")
    public ResponseEntity<List<Role>> findRoleList() {
    	List<Role> roleList = userService.findAllRole();

        return new ResponseEntity<>(roleList,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteRole/{roleId}")
    public ResponseEntity<String> deleteRoleById(@PathVariable("roleId") int roleId) {
    	userService.deleteRole(roleId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
