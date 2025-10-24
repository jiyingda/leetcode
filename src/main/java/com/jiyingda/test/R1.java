/**
 * @(#)R1.java, 10月 02, 2024.
 * <p>
 * Copyright 2024 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author jiyingdabj
 */
public class R1 {


    public static void main(String[] args) {
        CompletableFuture<Boolean> future = null;
        try {
            future = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("start");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("end");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return true;
            });
        future.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("超时取消");
            //future.cancel(true);
        } catch (Exception e1) {

        }

    }
}