package com.example.demo.Controller;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;
import com.example.demo.Entity.Queue;
import com.example.demo.Service.QueueStorageService;
import com.microsoft.azure.storage.StorageException;

@RestController
public class QueueStorageController {

	@Autowired
	QueueStorageService queueService;
	
	@PostMapping("/createQueue")
	public String createQueue(@RequestBody Queue queue) throws InvalidKeyException, URISyntaxException, StorageException
	{
		queueService.createQueue(queue);
		return "Queue Created";
	}
	
	@PostMapping("/addMsg/{queueName}/{msg}")
	public String addMsg(@PathVariable String queueName, @PathVariable String msg)
	{
		queueService.addMessage(queueName, msg);
		return "Message Added";
	}
	
	@DeleteMapping("/deleteQueue")
	public String deleteQueue(@RequestBody Queue queue) throws InvalidKeyException, URISyntaxException, StorageException
	{
		queueService.deleteQueue(queue);
		return "Queue Deleted";
	}
	
	@DeleteMapping("/deleteQueue/{queueName}")
	public String deleteMessages(@PathVariable String queueName) throws InvalidKeyException, URISyntaxException, StorageException
	{
		queueService.deleteMessages(queueName);
		return "Message Deleted";
	}
}
