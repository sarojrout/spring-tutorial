/**
 * 
 */
package com.saroj.tutorial.model;

/**
 * @author sarojkumarrout
 *
 */
public class MyResponse {
	
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
	private int status;
	private String message;
	@Override
	public String toString() {
		return "MyResponse [status=" + status + ", message=" + message + "]";
	}

}
