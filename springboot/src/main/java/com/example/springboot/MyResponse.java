package com.example.springboot;

public class MyResponse {
	
	@Override
	public String toString() {
		return "MyResponse [status=" + status + ", message=" + message + "]";
	}
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
