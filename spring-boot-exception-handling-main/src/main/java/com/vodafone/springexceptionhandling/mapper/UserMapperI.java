package com.vodafone.springexceptionhandling.mapper;

import com.vodafone.springexceptionhandling.domain.User;
import com.vodafone.springexceptionhandling.dto.UserDto;

public interface UserMapperI {
	public User getConvertFromDtoUserToEntityUser(UserDto userDto);
	public UserDto getConvertFromDtoUserToEntityUser(User user);
}
