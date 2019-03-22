package com.lxj.com_lxj_student_info;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        // Date d = new Date();
        // System.out.println(d.toString());
        // SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // System.out.println(ft.format(d));

        strToDate();
    }


    /**
     * 字符串转化为时间
     */
    private static void strToDate() {
        String date_str = "2019-03-20";
        // System.out.println(Date.va);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // System.out.println(sdf.parse(date_str));
            Date date=sdf.parse(date_str);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}