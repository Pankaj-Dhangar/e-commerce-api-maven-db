package org.dnyanyog.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {
	
	private String responseCode;  // 0000 -> success , 911 -> fail
	private String responseMessage;  // 0000 -> success , 912 -> fail
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
