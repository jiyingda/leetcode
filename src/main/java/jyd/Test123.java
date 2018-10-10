package jyd;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test123 {

    public static void main(String... args){
        String key = "sssaa";
        int i = key.hashCode();
        int k = hash(key);
        System.out.println(i + "\n" + k);
        Date date = new Date();
        System.out.println(date.getTime());
        long currentTime = System.currentTimeMillis();
        int tim = 6 * 60 * 60 * 1000;
        currentTime = currentTime - tim;
        System.out.println(currentTime);

    }

    public static int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
