package com.main;

public enum PhoneTypes {
	PHONE("PHONE"),
	KEYPAD_PHONE("KEYPAD_PHONE"),
	SMARTPHONE("SMARTPHONE"),
	GAMING_SMARTPHONE("GAMING_SMARTPHONE"),
	RUGGED_KEYPAD_PHONE("RUGGED_KEYPAD_PHONE");

	private String stringValue;
	
	PhoneTypes(String string) {
		this.stringValue = string;
	}
	
	public String getString() {
		return stringValue;
	}
}
