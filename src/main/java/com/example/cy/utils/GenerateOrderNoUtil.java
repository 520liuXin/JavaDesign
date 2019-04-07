package com.example.cy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成订单号 工具类
 *
 */
public class GenerateOrderNoUtil { private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 生成订单号
     *
     * @param
     * @return
     */
    public static String gens( Long museId) { //生成
        String orderNo =  museId +sdf.format(new Date())  ;
        return orderNo;
    }


    public static void main(String[] args) {
        System.out.println(gens(530L));

    } }