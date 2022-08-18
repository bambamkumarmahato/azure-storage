package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.BlobFile;
import com.example.demo.Service.BlobStorageService;

@RestController
public class BlobStorageController {

	@Autowired
	BlobStorageService blobStorageService;
	
	@PostMapping("/createContainer/{containerName}")
	public String createConatainer(@PathVariable String containerName) {
		blobStorageService.createContainer(containerName);
		return "Container created successfully";
	}
	
	@DeleteMapping("/deleteContainer/{containerName}")
	public String deleteConatainer(@PathVariable String containerName) {
		blobStorageService.deleteContainer(containerName);
		return "Container deleted successfully";
	}
	
	@PutMapping("/uploadBlobFile")
	public String uploadBlobFile(@RequestBody BlobFile blobFile) {
		blobStorageService.uploadBlobFile(blobFile);
		return "File Uploadted successfully";
	}
	
	@PutMapping("/downloadBlobFile")
	public String downloadBlobFile(@RequestBody BlobFile blobFile) {
		blobStorageService.downloadBlobFile(blobFile);
		return "File Downloaded successfully";
	}
	
	@DeleteMapping("/deleteBlobFile")
	public String deleteBlobFile(@RequestBody BlobFile blobFile) {
		blobStorageService.deleteBlobFile(blobFile);
		return "File Deleted successfully";
	}
}
