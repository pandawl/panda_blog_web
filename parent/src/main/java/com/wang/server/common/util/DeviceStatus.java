package com.wang.server.common.util;

public enum DeviceStatus {
	
	HAS_TAKE(11,"已取"), //仪器已取

	NO_TAKE(12,"未取"),//仪器未取
	
	HAS_STROGE(21,"已入库"),//仪器已入库
	
	NO_STROGE(22,"未入库");//仪器未入库
	
	private int code;
	
	private String message;

	private DeviceStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	
	
	

}
