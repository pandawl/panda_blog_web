package com.wang.server.common.util;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;

public class ResultUtils {

	public static <T> Result<T> generateResult(ResultCode code, String message, T resultJson) {
		message = StringUtils.isNotBlank(message) ? message : "";
		Result<T> result = new Result<T>(code.getCode(), message, resultJson);
		return result;
	}

	public static <T> String generateResultStr(ResultCode code, String message, T resultJson) {
		return generateResult(code, message, resultJson).toString();
	}

	public static <T> String resultFail(ResultCode code, String message) {
		return generateResult(code, message,null).toString();
	}

	public static boolean isResultSuccess(String resultStr) {
		if (resultStr == null) {
			return false;
		}
		JsonObject json= (JsonObject) new JsonParser().parse(resultStr);

		return ResultCode.SUCCESS.getCode() == 	json.get("resultCode").getAsInt();
	}

	public static String generateKindEditorResultStr(String err, String message, String url) {
		JsonObject json=new JsonObject();
		json.addProperty("err", err);
		json.addProperty("msg", message);
		json.addProperty("url", url);
		return json.toString();
	}

	public static void main(String[] args) {
		Result<String> result = generateResult(ResultCode.DATA_ERROR, "hehe", "123");
		System.out.println(result);
	}

}
