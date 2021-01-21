package com.jiyingda.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author jiyingda
 * @date 2021/1/20
 */
public class Test2 {


    public static void main(String[] args){
        GregorianCalendar currentCalendar = new GregorianCalendar();
        int hour = currentCalendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);

        System.out.print(15%5);


    }
}
