package jyd.ThredTest;

public class ThMain {
    public static void main(String... args){
        Thread.getAllStackTraces().forEach((p,q)->System.out.println(p.getName() + q.length));

        Thread.activeCount();
    }
}
