package com.vodafone.uc1.mapper;

import com.vodafone.uc1.domain.User;
import com.vodafone.uc1.dto.UserDto;

public interface UserMapperI {
	public User getConvertFromDtoUserToEntityUser(UserDto userDto);
	public UserDto getConvertFromEntityUserToDtoUser(User user);
}
