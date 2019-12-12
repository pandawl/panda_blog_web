/*
package com.panda.admin.controller;


import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.panda.pojo.blog.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

public class AdminUserEndecrypUtils {
    */
/**
 * 对密码进行md5加密,并返回密文和salt，包含在User对象中
 *
 * @param password 密码
 * @return 密文和salt
 * <p>
 * 通过username,password,salt,校验密文是否匹配
 * @param password      原密码
 * @param salt          盐
 * @param md5cipherText 密文
 * @return 正确返回true, 否则false
 *//*

    public static User CreateUserWithMD5Password(String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "password不能为空");
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes().toHex();
        //组合username,两次迭代，对密码进行加密
        String password_cipherText = new Md5Hash(password, salt, 30).toHex();
        User user = new User();
        user.setPassword(password_cipherText);
        user.setSalt(salt);
        user.setStatus(false);
        return user;
    }

    public static User CreateUserWithUsernameAndMD5Password(String username, String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "password不能为空");
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes().toHex();
        //组合username,两次迭代，对密码进行加密
        String password_cipherText = new Md5Hash(password, salt, 30).toHex();
        User user = new User();
        user.setPassword(password_cipherText);
        user.setUserName(username);
        user.setSalt(salt);
        user.setStatus(false);
        return user;
    }

    */
/**
 * 通过username,password,salt,校验密文是否匹配
 *
 * @param password      原密码
 * @param salt          盐
 * @param md5cipherText 密文
 * @return 正确返回true, 否则false
 *//*

    public static boolean CheckUserMD5Password(String password, String salt, String md5cipherText) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "password不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(md5cipherText), "md5cipherText不能为空");
        //组合username,两次迭代，对密码进行加密
        String password_cipherText = new Md5Hash(password, salt, 30).toHex();
        return md5cipherText.equals(password_cipherText);
    }

    public static void main(String[] args) {

        User tsUser = AdminUserEndecrypUtils.CreateUserWithMD5Password("12356wang");
        System.out.println(tsUser);
    }

}
*/
