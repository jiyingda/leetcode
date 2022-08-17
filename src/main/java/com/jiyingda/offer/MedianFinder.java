/**
 * @(#)MedianFinder.java, 3月 25, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.offer;

import java.util.Calendar;

/**
 * @author jiyingdabj
 */
public class MedianFinder {

    private int a;
    private int b;
    private int c;
    private int size;

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {


    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (b + a) / 2;
        }
        return b;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        System.out.println(cal.getTime().getTime());
    }
}
