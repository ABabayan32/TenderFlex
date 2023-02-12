package com.example.tenderflex.controller;

import com.example.tenderflex.service.FileUploadService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

@RestController
public class FileUploadController {
    private final FileUploadService fileUploadService;
     public FileUploadController(FileUploadService fileUploadService) {
         this.fileUploadService=fileUploadService;
     }
    @PostMapping("/uploadFile")
    public String uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {
         return fileUploadService.storeFile(multipartFile);
    }

    @GetMapping(path = "/download/{key}")
    public ResponseEntity<Resource> download(@PathVariable(value = "key") String key) throws IOException {
        Resource file = fileUploadService.getFileByKey(key);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.contentLength())
                .contentType(APPLICATION_OCTET_STREAM)
                .body(file);

    }
}


