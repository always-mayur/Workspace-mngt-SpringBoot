package com.workspace.exception;

import java.util.Arrays;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}