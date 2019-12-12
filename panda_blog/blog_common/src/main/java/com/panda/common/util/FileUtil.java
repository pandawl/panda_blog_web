package com.panda.common.util;

/**
 * @Auther: wl
 * @Date: 2019/7/3 17:57
 * @Description:
 */
public class FileUtil {

    // 图片允许的后缀扩展名
    public static String[] IMAGE_FILE_EXTD = new String[]{"png", "bmp", "jpg", "jpeg", "pdf"};

    public static boolean isFileAllowed(String fileName) {
        for (String ext : IMAGE_FILE_EXTD) {
            if (ext.equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
