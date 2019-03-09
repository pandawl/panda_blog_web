package com.wang.server.common;

import com.wang.server.common.util.DESUtil;

/**
 * @author tanxh
 * @description 常量类
 * @since 2018/9/11
 */


public class Constants {
	
	/**
	 * 用户登录信息在Request中存储的key
	 */
	public final static String USER_LOGIN_INFO = "USER_LOGIN_INFO";

	/**
	 * 模块路径信息在Request中存储的key
	 */
	public final static String MODEL_URL = "MODEL_URL";

    /**
     * 项目中密码的加密盐
     */
    public final static String PASSWORD_SALT = "nim*Password%salt";
    /**
     * 内部人员user token
     */
    public  final  static String  USERINFOTOKEN="USERINFOTOKEN";
    /**
     * customer token
     */
    public  final  static String  CUSTOMERTOKEN="CUSTOMERTOKEN"; 
    /**
     * customer  redis过期时间
     */
    public  final  static long  CUSTOMER_EXPIRE_TIME=60*60*24;
    
    /**
     * redis过期时间
     */
    public  final  static long  EXPIRE_TIME=60*60*24;
    
    /**
     * 用户拥有的功能信息缓存前缀
     */
     public final   static String USERFUNACTIONSPREFIX="USERFUNACTIONS";
   
     /**
      * 用户菜单缓存前缀
      */
     public final   static String USERMUNE="USERMUNE";
     
     /**
     * 加密
     * @param password
     * @return
     */
    public static String decryptPassword(String password){
        return DESUtil.decrypt(password, Constants.PASSWORD_SALT);
    }

    /**
     * 解密
     * @param password
     * @return
     */
    public static  String encryptPassword(String password){
        return DESUtil.encrypt(password, Constants.PASSWORD_SALT);
    }

    public static void main(String[] args){
        System.out.println(Constants.encryptPassword("12345678901234567890"));
        System.out.println(Constants.decryptPassword("63f240566f8e19b6988d0d3396ea6e88ff2c103d0e780c21"));
    }

}
