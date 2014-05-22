package com.example;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;
	

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public String getMessage() {
		return messageDao.getMessage();
	}



}
