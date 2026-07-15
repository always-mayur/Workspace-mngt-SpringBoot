package com.workspace.dao;

import org.springframework.stereotype.Repository;

import com.workspace.dto.UserDTO;
import com.workspace.mapper.UserMapper;

@Repository
public class UserDAO 
{
	private final UserMapper userMapper;
	
	public UserDAO(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}
	
	public UserDTO getUserByName(String username)
	{
		return userMapper.getUserByUsername(username);
	}

}
