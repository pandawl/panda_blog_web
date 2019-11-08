package com.wang.server.common.util;

import java.io.*;

/**
 * @Auther: wl
 * @Date: 2019/8/28 18:16
 * @Description:
 */
public class DatabaseUtil {
    //本实例支持Linux环境和Windows环境
    public static void main(String[] args) throws Exception {
        //测试备份
       String command1 = "mysqldump  -h188.131.223.181 -uroot -ppanda  panda_blog";//参数依次是IP、账号、密码、数据库名
        String savePath = "d:/usr";
        File saveFile = new File(savePath);

        if (!saveFile.exists()) {// 如果目录不存在

            saveFile.mkdirs();// 创建文件夹

        }
        savePath += "/panda_blog.sql";

        boolean b1 = new DatabaseUtil().backup(command1, savePath);
        if(b1){
            System.out.println("备份成功");
        }else {
            System.out.println("备份失败");
        }

        /*//测试还原
        String command2 = "mysql -hlocalhost -ualex -p123 --default-character-set=utf8 demo";
        String savePath2 = "D:/demo.sql";
        boolean b2 = new DatabaseUtil().recover(command2, savePath2);
        if(b2){
            System.out.println("还原成功");
        }else {
            System.out.println("还原失败");
        }*/


    }


    /**
     * mysql的备份方法
     *
     * @param command  命令行
     * @param savePath 备份路径
     * @return
     */
    public boolean backup(String command, String savePath) {
        boolean flag;
        // 获得与当前应用程序关联的Runtime对象
        Runtime r = Runtime.getRuntime();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 在单独的进程中执行指定的字符串命令
            Process p = r.exec(command);
            // 获得连接到进程正常输出的输入流，该输入流从该Process对象表示的进程的标准输出中获取数据
            InputStream is = p.getInputStream();
            // InputStreamReader是从字节流到字符流的桥梁：它读取字节，并使用指定的charset将其解码为字符
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            //BufferedReader从字符输入流读取文本，缓冲字符，提供字符，数组和行的高效读取
            br = new BufferedReader(isr);
            String s;
            StringBuffer sb = new StringBuffer("");
            // 组装字符串
            while ((s = br.readLine()) != null) {
                sb.append(s + System.lineSeparator());
            }
            s = sb.toString();
            // 创建文件输出流
            FileOutputStream fos = new FileOutputStream(savePath);
            // OutputStreamWriter是从字符流到字节流的桥梁，它使用指定的charset将写入的字符编码为字节
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
            // BufferedWriter将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入
            bw = new BufferedWriter(osw);
            bw.write(s);
            bw.flush();
            flag = true;
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            //由于输入输出流使用的是装饰器模式，所以在关闭流时只需要调用外层装饰类的close()方法即可，
            //它会自动调用内层流的close()方法
            try {
                if (null != bw) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean shell(String command){
        boolean flag;
        Runtime r = Runtime.getRuntime();
        try {

            Process p = r.exec(new String[]{"sh",
                    "/home/panda/panda_blog.sh"});
            flag = true;
        } catch (IOException ex) {
            flag = false;
        }
        return flag;

    }

    /**
     * mysql的还原方法
     *
     * @param command  命令行
     * @param savePath 还原路径
     * @return
     */
    public boolean recover(String command, String savePath) {
        boolean flag;
        Runtime r = Runtime.getRuntime();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            Process p = r.exec(command);
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream(savePath);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);
            String s;
            StringBuffer sb = new StringBuffer("");
            while ((s = br.readLine()) != null) {
                sb.append(s + System.lineSeparator());
            }
            s = sb.toString();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            bw = new BufferedWriter(osw);
            bw.write(s);
            bw.flush();
            flag = true;
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            try {
                if (null != bw) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}