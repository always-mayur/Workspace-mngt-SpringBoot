package com.workspace.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.workspace.dto.UserDTO;

@Mapper
public interface UserMapper 
{
	UserDTO getUserByUsername(@Param("username") String username);

}
