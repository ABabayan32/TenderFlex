package com.example.tenderflex.service.impl;

import com.example.tenderflex.service.FileUploadService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.example.tenderflex.util.Constants.FILES_REPOSITORY_HOME;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    private final Path fileStorageLocation;

    public FileUploadServiceImpl() {
        this.fileStorageLocation = Paths.get(FILES_REPOSITORY_HOME)
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException(
                    "Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        String[] fileNameParts = fileName.split("\\.");

        return fileNameParts[fileNameParts.length - 1];
    }

    @Override
    public String storeFile(MultipartFile file) throws IOException {
        String fileExtension = getFileExtension(file.getOriginalFilename());
        if(fileExtension != null && !fileExtension.equalsIgnoreCase("pdf")){
            throw new IOException("File format is not supported");
        }
        // Normalize file name
        String fileKey = RandomStringUtils.random(80, true, true);
        String fileName =
                fileKey+"-file.pdf";

        try {
            // Check if the filename contains invalid characters
            if (fileName.contains("..")) {
                throw new RuntimeException(
                        "Sorry! Filename contains invalid path sequence " + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileKey;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public Resource getFileByKey(String key) throws IOException {
        Path path = this.fileStorageLocation.resolve(key+"-file.pdf");
        return new ByteArrayResource(Files.readAllBytes(path));
    }
}