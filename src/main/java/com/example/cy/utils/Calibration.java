package com.example.cy.utils;


import com.example.cy.bean.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类，对数据进行校验
 */
public class Calibration {


    /**
     * 验证参数是否不为空,非空true
     *
     * @param object
     * @return
     */
    public final static boolean isNotNull(Object object) {
        return object != null && object != "" && object.toString().length() > 0;
    }
    public final static boolean isNotNull(Object object,Object object1) {
        return (object != null && object != "" && object.toString().length() > 0)
                &&(object1 != null && object1 != "" && object1.toString().length() > 0);
    }

    public final static boolean isNull(Object object,Object object1,Object object2,Object object3,Object object4) {
        return (object != null && object != "" && object.toString().length() > 0)
                &&(object1 != null && object1 != "" && object1.toString().length() > 0)&&
                (object2 != null && object2 != "" && object2.toString().length() > 0)
                &&(object3 != null && object3 != "" && object3.toString().length() > 0)&&
                (object4 != null && object4 != "" && object4.toString().length() > 0);
    }
    /**
     * 验证参数是否为空,空true
     *
     * @param object
     * @return
     */
    public final static boolean isNull(Object object) {
        return object == null || object == "" && object.toString().length() <= 0;
    }




    /**
     * 判断对象为空
     *
     * @param obj 对象名
     * @return 是否为空
     */

    public static boolean isEmpty(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        if ((obj instanceof List))
        {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String))
        {
            return ((String) obj).trim().equals("");
        }
        return false;
    }

    /**
     * 判断对象不为空
     *
     * @param obj 对象名
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
    }
    /**
     * email格式验证
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * phone验证
     * @param str
     * @return
     */

    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }


    public static void main(String args[]) {
        String email = "q99296010@qq.com";
        System.out.println(checkEmail(email));
        String phone = "17673817175";
        System.out.println(isMobile(phone));

    }
    }
