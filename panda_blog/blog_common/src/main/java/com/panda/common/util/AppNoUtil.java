package com.panda.common.util;

import javax.annotation.Resource;
import java.util.Calendar;

public class AppNoUtil {
    @Resource


    private static Integer Num = 123;

    public static void main(String[] args) {
     /*   Calendar now = Calendar.getInstance();
        System.out.println("年: " + now.get(Calendar.YEAR));*/

        AppNoUtil util = new AppNoUtil();
        for (int i = 0; i < 5; i++) {
            System.out.println(util.setMaxAPPNo(1001, 1111));
        }

    }

    /**
     * 生成委托单号
     *
     * @return
     */
    public String setMaxAPPNo(int suo, int shi) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String yearstr = String.valueOf(year);
        String suostr = String.valueOf(suo);
        String shistr = String.valueOf(shi);
        Num++;
        return yearstr + suostr + shistr + Num;

    }

}
