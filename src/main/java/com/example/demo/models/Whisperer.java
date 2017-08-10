package com.example.demo.models;

public class Whisperer {
	
	String lowercaseMessage = "";
	
	public Whisperer (String message) {
		lowercaseMessage = message.toLowerCase();
	}
	
	public String makeItLowerCase () {
		return lowercaseMessage;
	}

}