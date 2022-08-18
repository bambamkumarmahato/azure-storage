package com.example.demo.Entity;

public class FileStorage {

	private String fileName;
	private String directory;
	
	public FileStorage(String fileName, String directory) {
		super();
		this.fileName = fileName;
		this.directory = directory;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	
}
