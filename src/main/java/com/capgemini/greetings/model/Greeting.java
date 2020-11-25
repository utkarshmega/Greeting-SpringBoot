package com.capgemini.greetings.model;

public class Greeting {
	private long id;
	private String message;

	public Greeting(long l,String message) {
		this.id=l;
		this.message=message;
	}
	public long getId() {
		return this.id;
	}
	public String getMessage() {
		return this.message;
	}
	public void setId(long l) {
		this.id=l;
	}
	public void setMessage(String message) {
		this.message=message;
	}
}
