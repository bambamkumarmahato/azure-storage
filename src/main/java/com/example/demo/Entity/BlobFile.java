package com.example.demo.Entity;

public class BlobFile {

	private String containerName;
	private String fileName;
	private String filePath;
	
	public BlobFile(String containerName, String fileName, String filePath) {
		super();
		this.containerName = containerName;
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
