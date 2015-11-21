package com.projects.testMax.view.helper;

public class ResponseWrapper<T> {

	private final T response;
	private final boolean success;
	private final String message;
	private long size;

	public T getResponse() {
		return response;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public ResponseWrapper(T objectTobeWrapped, boolean success, String message) {
		this.response = objectTobeWrapped;
		this.success = success;
		this.message = message;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
