package com.workspace.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.workspace.dto.FileMetadataDTO;

@Mapper
public interface FileMapper 
{
	void saveFileMetadata(FileMetadataDTO fileMetadataDTO);

}
