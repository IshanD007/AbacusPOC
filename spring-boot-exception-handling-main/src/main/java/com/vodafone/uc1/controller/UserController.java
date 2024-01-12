package com.vodafone.uc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vodafone.uc1.domain.User;
import com.vodafone.uc1.dto.UserDto;
import com.vodafone.uc1.service.UserService;

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
    
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
    	User user = userService.update(userDto);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
