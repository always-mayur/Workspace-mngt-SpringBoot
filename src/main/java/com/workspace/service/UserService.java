package com.workspace.service;

import org.springframework.stereotype.Service;

import com.workspace.common.CommonResponse;
import com.workspace.dao.UserDAO;
import com.workspace.dto.LoginRequestDTO;
import com.workspace.dto.LoginResponseDTO;
import com.workspace.dto.UserDTO;
import com.workspace.exception.ResourceNotFoundException;
import com.workspace.security.JwtUtil;

@Service
public class UserService 
{
	private final UserDAO userDAO ; 
	private final JwtUtil jwtUtil;
	
	public UserService(UserDAO userDAO,JwtUtil jwtUtil)
	{
		this.userDAO = userDAO;
		this.jwtUtil = jwtUtil;
	}
	
	public LoginResponseDTO login(LoginRequestDTO request)
	{
		UserDTO user = userDAO.getUserByName(request.getUsername());
		if(user == null)
		{
		    throw new ResourceNotFoundException(
		        "User not found");
		}
		
		if(!request.getPassword()
		        .equals(user.getPassword()))
		{
		    throw new RuntimeException(
		        "Invalid Password");
		}
		
		LoginResponseDTO response =
				new LoginResponseDTO();

				response.setToken(jwtUtil.generateToken(user));

				return response;
	}
	
	

}
