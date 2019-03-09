package com.wang.server.common.util;

public enum ResultCode {
	
	SUCCESS(200), 

	PARAM_ERROR(400), 

	ILLEAGAL_REQUEST(401), 

	NOT_FOUND(404), 
     
	SESSION_TIME_OUT(600), 

	DATA_ERROR(500), 

	MULTI_REQUEST(900);

	private int code;

	private ResultCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static ResultCode getByType(int code) {
		for (ResultCode resultCode : values()) {
			if (resultCode.getCode() == code) {
				return resultCode;
			}
		}
		return null;
  }

}
