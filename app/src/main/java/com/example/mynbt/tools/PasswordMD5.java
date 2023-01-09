package com.example.mynbt.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordMD5 {
    private String password;
    private String passwordMD5;

    public PasswordMD5(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMD5() {
        return passwordMD5;
    }

    public void setPasswordMD5(String passwordMD5) {
        this.passwordMD5 = passwordMD5;
    }

    public void passwordMD5() {
        String str = getPassword();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
            md.update(str.getBytes());// 计算md5函数
            String hashedPwd = new BigInteger(1, md.digest()).toString(16);// 16是表示转换为16进制数
            setPasswordMD5(hashedPwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
