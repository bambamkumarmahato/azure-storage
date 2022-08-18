package com.example.demo.Entity;

public class TableDetails {

	private String tableName;
	private String property;
	private String value;
	
	public TableDetails(String tableName, String property, String value) {
		super();
		this.tableName = tableName;
		this.property = property;
		this.value = value;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
