package com.example.zhujiaxiang.forwork.tools;

import android.app.Activity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhujiaxiang on 18/3/7.
 */

/**
 * Md5加密函数库
 * 对用户名以及密码进行Md5加密，并通过网络框架POST传输进数据库
 * @anuthor [Johnny]
 * @see [ecode]
 */
public class Md5Activity extends Activity {

    public static String encode(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 得到加密后的字符组数
            byte[] result = messageDigest.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : result) {
                // 这里的是为了将原本是byte型的数向上提升为int型，从而使得原本的负数转为了正数
                int num = b & 0xff;
                //这里将int型的数直接转换成16进制表示
                String hex = Integer.toHexString(num);
                //16进制可能是为1的长度，这种情况下，需要在前面补0，
                if (hex.length() == 1) {
                    sb.append(0);
                }
                sb.append(hex);
            }
            return sb.toString();


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
