package com.example.demo.Entity;

public class Queue {

	private String queueName;
	private String testMessage;
	
	public Queue(String queueName, String testMessage) {
		super();
		this.queueName = queueName;
		this.testMessage = testMessage;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getTestMessage() {
		return testMessage;
	}

	public void setTestMessage(String testMessage) {
		this.testMessage = testMessage;
	}
	
	
}
