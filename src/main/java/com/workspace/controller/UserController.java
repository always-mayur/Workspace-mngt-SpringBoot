package com.workspace.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workspace.common.CommonResponse;
import com.workspace.service.UserService;
import com.workspace.constants.URIConstants;
import com.workspace.dto.LoginRequestDTO;

@RestController
public class UserController 
{

	private final UserService userService ;
	
	public UserController(UserService userService)
	{
		this.userService = userService ;
	}
	
	@PostMapping(URIConstants.LOGIN)
	public CommonResponse login(@RequestBody LoginRequestDTO request)
	{
		return CommonResponse.success(userService.login(request));
	}
}
