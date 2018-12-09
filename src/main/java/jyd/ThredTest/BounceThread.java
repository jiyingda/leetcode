package jyd.ThredTest;

import javax.swing.*;

public class BounceThread {
    private String ss = "aaa";

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public static void main(String... args){
        BounceThread bb = new BounceThread();



        int i = 0;

        Runnable r = () -> {
            synchronized (bb){
                bb.setSs("aaaa" + 1);
            }
            System.out.println("hello");
        };
        Thread thread = new Thread(r);
        Thread thread2 = new Thread(r);
        thread.start();
        thread2.start();

        Thread.getAllStackTraces().forEach((p,q)->System.out.println(p.getName() + q.length));



    }


}
