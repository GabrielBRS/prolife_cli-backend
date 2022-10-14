package com.gabrielsousa.prolife.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gabrielsousa.prolife.config.FileStorageConfig;
import com.gabrielsousa.prolife.exception.FileStorageException;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageConfig fileStorageLocation) {
		Path path = Paths.get(fileStorageLocation.getUploadDir())
				.toAbsolutePath().normalize();
		
		this.fileStorageLocation = path;
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		}catch(Exception e) {
			throw new FileStorageException("Could not create the directory where the upload files will be stored!", e);
		}
	}
	
	public String storeFile(MultipartFile file) {
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		}catch(Exception e) {
			throw new FileStorageException("Could not store file" + fileName + ". Please try again!",e);
		}
	}

}
