package com.example;


public class MessageDaoImpl implements MessageDao {

	private String message;

	
	public void setMessage(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
	
	public void upCase(){
		this.message = this.message.toUpperCase();
	}

	
	

	

}
