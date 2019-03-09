package com.wang.server.common.util;

public enum StorageStatus {

	OUT_STORAGE("已出库"), WAIT_STORAGE("正在出库"),NO_STORAGE("未出库");

	private String OutMessage;

	private StorageStatus(String outMessage) {
		this.OutMessage = outMessage;

	}

	public String getOutMessage() {
		return OutMessage;
	}

}
