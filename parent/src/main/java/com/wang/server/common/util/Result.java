package com.wang.server.common.util;

import com.google.gson.GsonBuilder;

public class Result<T> {
	
	private int resultCode;
	
	private String resultMessage;
	
	private T resultJson;

	public Result(int code, String message, T resultJson) {
		this.resultCode = code;
		this.resultMessage = message;
		this.resultJson = resultJson;
	}

	public int getResultCode() {
		return this.resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return this.resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public T getResultJson() {
		return this.resultJson;
	}

	public void setResultJson(T resultJson) {
		this.resultJson = resultJson;
	}

	public String toString() {
		return  new GsonBuilder()
				.setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create().toJson(this);
	}
	
}
