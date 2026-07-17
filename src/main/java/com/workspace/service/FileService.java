package com.workspace.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService 
{
    public String uploadFile(MultipartFile file)
    {
        System.out.println("Original Name : " + file.getOriginalFilename());
        System.out.println("Size          : " + file.getSize());
        System.out.println("Content Type  : " + file.getContentType());
        System.out.println("Is Empty      : " + file.isEmpty());

        return file.getOriginalFilename();
    }

}
