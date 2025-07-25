package com.bms.models;

import java.util.UUID;

public class User {
	private final String id;
	private String name;
	private final String phoneNumber;
	private String email;

	public User(String name, String phoneNumber, String email){
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
			return "User details for " + this.name + " \n" + 
							"id: " + this.id +"\n" + 
							"email: " + this.email +"\n"+
							"phoneNumber: " + this.phoneNumber +"\n";
	}
}
