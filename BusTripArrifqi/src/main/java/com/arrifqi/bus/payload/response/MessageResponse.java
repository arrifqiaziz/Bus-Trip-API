package com.arrifqi.bus.payload.response;

import java.util.List;

public class MessageResponse<T> {
	private String message;
	private Boolean success;
	private List<T> data;
	private T object;

	public MessageResponse(String message) {
		this.message = message;
	}

	public MessageResponse(Boolean success, String message, List<T> data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public MessageResponse(Boolean success, String message, T object) {
		this.success = success;
		this.message = message;
		this.object = object;
	}

	public MessageResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
		this.data = null;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
}
