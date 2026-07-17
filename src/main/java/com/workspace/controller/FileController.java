package com.workspace.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.workspace.common.CommonResponse;
import com.workspace.constants.URIConstants;
import com.workspace.service.FileService;

@RestController
public class FileController 
{

	private final FileService fileService ;
	
	public FileController(FileService fileService)
	{
		this.fileService = fileService ;
	}
	
	@PostMapping(
		    value = URIConstants.FILE_UPLOAD,
		    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public CommonResponse uploadFile(@RequestParam("file") MultipartFile file)
	{
		return CommonResponse.success(fileService.uploadFile(file));
		
	}
}
