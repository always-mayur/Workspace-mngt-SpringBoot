package com.workspace.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.workspace.dao.FileDAO;
import com.workspace.dto.FileMetadataDTO;

@Service
public class FileService 
{
	private final FileDAO fileDAO ;
	
	public FileService(FileDAO fileDAO)
	{
		this.fileDAO = fileDAO ;
	}
	
	@Transactional
	public String uploadFile(MultipartFile file)
	{
	    if (file.isEmpty())
	    {
	        throw new RuntimeException("File is empty");
	    }
	    
	    try
	    {
	    	Path uploadPath = Paths.get("uploads").toAbsolutePath().normalize(); //Create a Java object that represents the path named uploads.
	        //Destination = uploads/
	        
	       // System.out.println(uploadPath.toAbsolutePath());

	        if (!Files.exists(uploadPath))
	        {
	            Files.createDirectories(uploadPath);
	        }

	        String uniqueId = UUID.randomUUID().toString();
	        
	        String originalFileName =
	                file.getOriginalFilename();

	        if (originalFileName == null ||
	            originalFileName.isBlank())
	        {
	            throw new RuntimeException(
	                    "Invalid file name");
	        }
	        
		    String extension =
		            originalFileName.substring(
		                    originalFileName.lastIndexOf('.') + 1)
		                    .toLowerCase(); //extract extension 
		    
		    List<String> allowedExtensions =
		            List.of("pdf", "png", "jpg", "jpeg");

		    if (!allowedExtensions.contains(extension))
		    {
		        throw new RuntimeException(
		                "Invalid file extension");
		    }
		    
		    String contentType = file.getContentType();

		    List<String> allowedContentTypes = List.of(
		            "application/pdf",
		            "image/png",
		            "image/jpeg"
		    );

		    if (!allowedContentTypes.contains(contentType))
		    {
		        throw new RuntimeException("Invalid content type");
		    }

	        String fileName =
	                uniqueId + "-" + originalFileName;

	        Path filePath = uploadPath.resolve(fileName);

//	        System.out.println(filePath);
//	        System.out.println(filePath.toAbsolutePath());
	        
	        Files.copy(file.getInputStream(), filePath);
	       // file.transferTo(filePath.toFile()); //filePath.tofile() --> "Convert this Path object into a File object."

	        // Create DTO
	        FileMetadataDTO fileMetadataDTO = new FileMetadataDTO();

	        fileMetadataDTO.setOriginalFileName(originalFileName);
	        fileMetadataDTO.setStoredFileName(fileName);
	        fileMetadataDTO.setFilePath(filePath.toString());
	        fileMetadataDTO.setContentType(file.getContentType());
	        fileMetadataDTO.setFileSize(file.getSize());

	        // Save metadata
	        fileDAO.saveFileMetadata(fileMetadataDTO);
	        
	        return fileName;
	    }
	    catch (IOException e)
	    {
	    	System.out.println(e.getMessage());

	       // Files.deleteIfExists(filePath);
	    	
	        throw new RuntimeException(
	                "Unable to upload file", e);
	    }
	}

}
