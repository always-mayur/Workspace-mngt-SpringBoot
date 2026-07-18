package com.workspace.dao;

import org.springframework.stereotype.Repository;

import com.workspace.dto.FileMetadataDTO;
import com.workspace.mapper.FileMapper;

@Repository
public class FileDAO 
{
	private final FileMapper fileMapper;
	
	public FileDAO(FileMapper fileMapper)
	{
		this.fileMapper = fileMapper;
	}

	public void saveFileMetadata(FileMetadataDTO fileMetadataDTO)
	{		
		fileMapper.saveFileMetadata(fileMetadataDTO);
	}
}
