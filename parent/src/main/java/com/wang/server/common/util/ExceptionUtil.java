package com.wang.server.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * exception工具类
 * @author C
 */
public class ExceptionUtil {//NOPMD

    /**
     * 获取异常信息
     *
     * @param exception 异常Exception类实例
     * @return
     */
    public static String getStackTrace(Throwable exception) {
        StringWriter stringWriter;
        stringWriter = new StringWriter();
        PrintWriter printWriter;
        printWriter = new PrintWriter(stringWriter);
        try {
            exception.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }
}
