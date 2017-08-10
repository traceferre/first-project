package com.example.demo.models;

public class Yeller {
	
	String uppercaseMessage = "";
	
	public Yeller (String message) {
		uppercaseMessage = message.toUpperCase();
	}
	
	public String makeItUpperCase () {
		return uppercaseMessage;
	}

}
