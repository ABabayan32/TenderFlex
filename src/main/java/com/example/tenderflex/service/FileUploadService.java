package com.example.tenderflex.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    String storeFile(MultipartFile multipartFile) throws IOException;

    Resource getFileByKey(String key) throws IOException;
}