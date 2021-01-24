package com.jiyingda.test;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 * @date 2021/1/14
 */
public class ObjectSize {

    public static void main(String[] args){
        int a = 100000;
        int i = 0;
        while ( a > 2) {
            a = a / 2;
            System.out.println(a);
            i++;
        }
        System.out.print("\n\n" + i);

        System.out.println(Long.MAX_VALUE == 9223372036854775807L);

        List<Integer> list = new ArrayList<>(32);
        System.out.println("size = " + list.size());
    }
}


class A {
    int a;
}
