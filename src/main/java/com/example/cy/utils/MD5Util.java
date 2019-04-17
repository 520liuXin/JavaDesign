package com.example.cy.utils;
import java.security.MessageDigest;
/**
 * MD5加密工具
 *
 */
public class MD5Util {

    private static final String SALT = "tamboo";

    public static String encode(String password) {
        password = password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.encode("admin"));


    }


    //    @Override
    //        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //            auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){
    //
    //                @Override
    //                public String encode(CharSequence rawPassword) {
    //                    return MD5Util.encode((String)rawPassword);
    //                }
    //
    //                @Override
    //                public boolean matches(CharSequence rawPassword, String encodedPassword) {
    //                    return encodedPassword.equals(MD5Util.encode((String)rawPassword));
    //                }}); //user Details Service验证
    //        }


}