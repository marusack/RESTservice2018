package com.sockethttp.ws.rest.vo;

public class Message {
	

	public Message(String text) {
		super();
		Text = text;
	}

	private String Text;

	
	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
}
