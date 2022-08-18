package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.TableDetails;
import com.example.demo.Service.TableStorageService;

@RestController
public class TableStorageController {

	@Autowired
	TableStorageService tableService;
	
	@PostMapping("/createTable/{tableName}")
	public String createTable(@PathVariable String tableName)
	{
		tableService.createTable(tableName);
		return "Table Created";
	}

	@DeleteMapping("/deleteTable/{tableName}")
	public String deleteTable(@PathVariable String tableName)
	{
		tableService.deleteTable(tableName);
		return "Table Deleted";
	}
	
	@PostMapping("/createEntity")
	public String createEntity(@RequestBody TableDetails tableDeatils)
	{
		tableService.createEntity(tableDeatils);
		return "Entity Created";
	}
	
	@DeleteMapping("/deleteEntity")
	public String deleteEntity(@RequestBody TableDetails tableDeatils)
	{
		tableService.deleteEntity(tableDeatils);
		return "Entity Deleted";
	}
}
