package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.models.TableEntity;
import com.example.demo.Entity.TableDetails;

@Service
public class TableStorageService {

	public String getTableConn()
	{
		String connString = "DefaultEndpointsProtocol=https;AccountName=simulationdevicedata;AccountKey=Bd7hAg/1GZ5B824iPKpdWtDxkVlELJ71I90kkYZcckYR3zRilKf8Jk9dCGmpx/SZhEJbbCS1bWop1ThPDtwqFg==;EndpointSuffix=core.windows.net";
		return connString;
	}
	
	public void createTable(String tableName)
	{
		TableClient tableClient = new TableClientBuilder().connectionString(getTableConn()).tableName(tableName).buildClient();
		tableClient.createTable();
	}
	
	public void deleteTable(String tableName)
	{
		TableClient tableClient = new TableClientBuilder().connectionString(getTableConn()).tableName(tableName).buildClient();
		tableClient.deleteTable();
	}
	
	public void createEntity(TableDetails tableDeatils)
	{
		TableClient tableClient = new TableClientBuilder().connectionString(getTableConn()).tableName(tableDeatils.getTableName()).buildClient();
		
		String partitionkey = "3";
		String rowkey = "3";
		
		TableEntity tableEntity = new TableEntity(partitionkey, rowkey).addProperty(tableDeatils.getProperty(),tableDeatils.getValue());
		tableClient.upsertEntity(tableEntity);
	}
	
	public void deleteEntity(TableDetails tableDeatils)
	{
		TableClient tableClient = new TableClientBuilder().connectionString(getTableConn()).tableName(tableDeatils.getTableName()).buildClient();
		
		String partitionkey = "1";
		String rowkey = "1";
		
		TableEntity tableEntity = new TableEntity(partitionkey, rowkey);
		tableClient.deleteEntity(tableEntity);
//		tableClient.deleteEntity(partitionkey, rowkey);
	}
}
