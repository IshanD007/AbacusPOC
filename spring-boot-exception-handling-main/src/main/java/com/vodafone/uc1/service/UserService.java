package com.vodafone.uc1.service;

import java.util.List;

import com.vodafone.uc1.domain.User;
import com.vodafone.uc1.dto.UserDto;

public interface UserService {

    User findById(int userId);

    User add(UserDto userDto);

    List<User> findAll();
    
    void deleteUser(Integer userId);
    
    User update(UserDto userDto);

}
