package com.example.demo.Service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.azure.storage.file.share.ShareClient;
import com.azure.storage.file.share.ShareClientBuilder;
import com.azure.storage.file.share.ShareDirectoryClient;
import com.azure.storage.file.share.ShareFileClient;
import com.azure.storage.file.share.ShareFileClientBuilder;
import com.example.demo.Entity.FileStorage;

@Service
public class FileStorageService {
	
	public String getFileConn()
	{
		String connString = "DefaultEndpointsProtocol=https;AccountName=simulationdevicedata;AccountKey=Bd7hAg/1GZ5B824iPKpdWtDxkVlELJ71I90kkYZcckYR3zRilKf8Jk9dCGmpx/SZhEJbbCS1bWop1ThPDtwqFg==;EndpointSuffix=core.windows.net";
		return connString;
	}
	
	public void createFileStorage(String shareName , FileStorage fileDetails)
	{
		ShareClient shareClient = new ShareClientBuilder().connectionString(getFileConn()).shareName(shareName).buildClient();
		shareClient.create();
		ShareDirectoryClient shareDirectoryClient = shareClient.createDirectory(fileDetails.getDirectory());
//		shareDirectoryClient.createSubdirectory("Sample").createFile(fileDetails.getFileName(), 1024);
		shareDirectoryClient.createFile(fileDetails.getFileName(), 1024);
//		shareClient.createFile(fileDetails.getFileName(), 1024);
	}
	
	public void deleteFileStorage(String shareName , FileStorage fileDetails)
	{
		ShareClient shareClient = new ShareClientBuilder().connectionString(getFileConn()).shareName(shareName).buildClient();
		shareClient.deleteFile(fileDetails.getFileName());;
//		shareClient.getDirectoryClient(fileDetails.getDirectory()).getSubdirectoryClient("Sample").deleteFile(fileDetails.getFileName());
//		shareClient.getDirectoryClient(fileDetails.getDirectory()).deleteSubdirectory("Sample");
		shareClient.deleteDirectory(fileDetails.getDirectory());
		shareClient.delete();
	}
	
	public void uploadFile(String shareName , FileStorage fileDetails)
	{
		ShareDirectoryClient shareDirectoryClient = new ShareFileClientBuilder().connectionString(getFileConn()).shareName(shareName).resourcePath(fileDetails.getDirectory()).buildDirectoryClient();
		ShareFileClient fileClient = shareDirectoryClient.getFileClient(fileDetails.getFileName());
//		fileClient.uploadFromFile(fileDetails.getFileName());
		File file = new File("C:/Users/M1081106/Desktop/test2.txt");
		fileClient.create(file.length());
		fileClient.uploadFromFile("C:/Users/M1081106/Desktop/test2.txt");
	}
	
	public void downloadFile(String shareName , FileStorage fileDetails)
	{
		ShareDirectoryClient shareDirectoryClient = new ShareFileClientBuilder().connectionString(getFileConn()).shareName(shareName).resourcePath(fileDetails.getDirectory()).buildDirectoryClient();
		ShareFileClient fileClient = shareDirectoryClient.getFileClient(fileDetails.getFileName());
//		fileClient.uploadFromFile(fileDetails.getFileName());
		fileClient.downloadToFile("C:/Users/M1081106/Desktop/test.txt");
	}
	
	public void deleteFile(String shareName , FileStorage fileDetails)
	{
		ShareDirectoryClient shareDirectoryClient = new ShareFileClientBuilder().connectionString(getFileConn()).shareName(shareName).resourcePath(fileDetails.getDirectory()).buildDirectoryClient();
		ShareFileClient fileClient = shareDirectoryClient.getFileClient(fileDetails.getFileName());
		fileClient.delete();
	}
}
