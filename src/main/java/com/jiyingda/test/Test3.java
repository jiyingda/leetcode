/**
 * @(#)Test3.java, 12月 10, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiyingdabj
 */
public class Test3 {
    static int i = 0;


    static Semaphore s1 = new Semaphore(1);

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException, ParseException {
        String s = "update error_question set questionType = -1 where `type` = 4 and exerciseType = -1 and questionType = 7 and id >= ";
        for (int i = 0; i < 20; i++) {
            System.out.println(s + (i * 5000) +" and id < "+ ((i+1) * 5000) + ";");
        }
        HashMap h = new HashMap();
        h.put(1,1);



        /*Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (i < 100) {
                        if (i % 2 == 1) {
                            i++;
                            System.out.println("1 -> " + i);
                            obj.notifyAll();
                        } else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        };

        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                while (i < 100) {
                    if (i % 2 == 0) {
                        i++;
                        System.out.println("2 -> " + i);
                        obj.notifyAll();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();*/
    }
}
