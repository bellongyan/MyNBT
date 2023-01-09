package com.example.mynbt.tools;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BaiduEncode {
    String appid;
    String word;
    String salt;
    String pwd;
    String MD5;

    public BaiduEncode(String appid, String word, String pwd) {
        this.appid = appid;
        this.word = word;
        this.pwd = pwd;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public void encodeMD5() {
        StringBuilder x = new StringBuilder();
        for (int n = 0; n < 10; n++) {
            x.append((int) (10 * (Math.random())));
        }
        setSalt(x.toString());

        String appid = getAppid();
        String word = getWord();
        String salt = getSalt();
        String pwd = getPwd();

        String str = appid + word + salt + pwd;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
            md.update(str.getBytes());// 计算md5函数
            String hashedPwd = new BigInteger(1, md.digest()).toString(16);// 16是表示转换为16进制数
            setMD5(hashedPwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void encodeURL() throws UnsupportedEncodingException {
        String urlString = URLEncoder.encode(getWord(), String.valueOf(UTF_8));
        setWord(urlString);
    }
}
