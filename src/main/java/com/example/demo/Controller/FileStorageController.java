package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.FileStorage;
import com.example.demo.Service.FileStorageService;

@RestController
public class FileStorageController {
	
	@Autowired
	FileStorageService fileStorage;
	
	@PostMapping("/createFileStorage/{shareName}")
	public String createFileStorage(@RequestBody FileStorage fileDetails, @PathVariable String shareName)
	{
		fileStorage.createFileStorage(shareName, fileDetails);
		return "File Storage Created";
	}
	
	@DeleteMapping("/deleteFileStorage/{shareName}")
	public String deleteFileStorage(@RequestBody FileStorage fileDetails, @PathVariable String shareName)
	{
		fileStorage.deleteFileStorage(shareName, fileDetails);
		return "File Storage Deleted";
	}
	
	@PutMapping("/uploadFile/{shareName}")
	public String uploadFile(@RequestBody FileStorage fileDetails, @PathVariable String shareName)
	{
		fileStorage.uploadFile(shareName, fileDetails);
		return "File Uploaded";
	}
	
	@PutMapping("/downloadFile/{shareName}")
	public String downloadFile(@RequestBody FileStorage fileDetails, @PathVariable String shareName)
	{
		fileStorage.downloadFile(shareName, fileDetails);
		return "File Downloaded";
	}

	@DeleteMapping("/deleteFile/{shareName}")
	public String deleteFile(@RequestBody FileStorage fileDetails, @PathVariable String shareName)
	{
		fileStorage.deleteFile(shareName, fileDetails);
		return "File Deleted";
	}
}
