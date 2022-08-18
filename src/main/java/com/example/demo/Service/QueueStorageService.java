package com.example.demo.Service;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.springframework.stereotype.Service;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;
import com.example.demo.Entity.Queue;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;

@Service
public class QueueStorageService {

	public String getQueueConn()
	{
		String connString = "DefaultEndpointsProtocol=https;AccountName=simulationdevicedata;AccountKey=Bd7hAg/1GZ5B824iPKpdWtDxkVlELJ71I90kkYZcckYR3zRilKf8Jk9dCGmpx/SZhEJbbCS1bWop1ThPDtwqFg==;EndpointSuffix=core.windows.net";
		return connString;
	}
	
	public CloudQueueClient getQueueClient() throws InvalidKeyException, URISyntaxException
	{
		CloudStorageAccount cloudStorageAccount = CloudStorageAccount.parse(getQueueConn());
		CloudQueueClient cloudQueueClient = cloudStorageAccount.createCloudQueueClient();
		return cloudQueueClient;
	}
	
	public void createQueue(Queue queue) throws InvalidKeyException, URISyntaxException, StorageException
	{
		CloudQueueClient cloudQueueClient = getQueueClient();
		CloudQueue cloudQueue = cloudQueueClient.getQueueReference(queue.getQueueName());
		cloudQueue.createIfNotExists();
	}
	
	public void addMessage(String queueName,String msg)
	{
		QueueClient queueClient = new QueueClientBuilder().connectionString(getQueueConn()).queueName(queueName).buildClient();
		queueClient.sendMessage(msg);
	}
	
	public void deleteQueue(Queue queue) throws InvalidKeyException, URISyntaxException, StorageException
	{
		CloudQueueClient cloudQueueClient = getQueueClient();
		CloudQueue cloudQueue = cloudQueueClient.getQueueReference(queue.getQueueName());
		cloudQueue.delete();
	}
	
	public void deleteMessages(String queueName)
	{
		QueueClient queueClient = new QueueClientBuilder().connectionString(getQueueConn()).queueName(queueName).buildClient();
		queueClient.clearMessages();;
	}
}
