package com.main.Model;

public class Message {

	private int id;
	private String body;
	private int postId;

	public Message() {
		super();
	}

	public Message(int id, String body, int postId) {
		super();
		this.id = id;
		this.body = body;
		this.postId = postId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
