package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.example.demo.Entity.BlobFile;

@Service
public class BlobStorageService {

	public final String connectionString = "DefaultEndpointsProtocol=https;AccountName=simulationdevicedata;AccountKey=Bd7hAg/1GZ5B824iPKpdWtDxkVlELJ71I90kkYZcckYR3zRilKf8Jk9dCGmpx/SZhEJbbCS1bWop1ThPDtwqFg==;EndpointSuffix=core.windows.net";
	
	BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
	
	public String getConnection() {
		return connectionString;
	}
	
	public void createContainer(String containerName) {
		blobServiceClient.createBlobContainer(containerName);
	}
	
	public void deleteContainer(String containerName) {
		System.out.println("blobServiceClient is :"+blobServiceClient);
		blobServiceClient.deleteBlobContainer(containerName);
	}
	
	public void uploadBlobFile(BlobFile blobFile) {
		BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(blobFile.getContainerName());
		BlobClient blobClient = blobContainerClient.getBlobClient(blobFile.getFileName());
		blobClient.uploadFromFile(blobFile.getFilePath() + blobFile.getFileName());
	}
	
	public void downloadBlobFile(BlobFile blobFile) {
		BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(blobFile.getContainerName());
		BlobClient blobClient = blobContainerClient.getBlobClient(blobFile.getFileName());
		blobClient.downloadToFile(blobFile.getFilePath() + blobFile.getFileName());
	}
	
	public void deleteBlobFile(BlobFile blobFile) {
		BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(blobFile.getContainerName());
		BlobClient blobClient = blobContainerClient.getBlobClient(blobFile.getFileName());
		blobClient.delete();
	}
}
