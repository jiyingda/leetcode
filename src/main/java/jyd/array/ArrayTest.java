package jyd.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ArrayTest {
    public static void main(String... args){
        List<Integer> list = new ArrayList<Integer>(50);
        for(int i = 0; i < 50; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        list.forEach(p -> System.out.print(p));
        System.out.println(list);
        System.out.println();
        List<Integer> ll = list.subList(0, 10);
        Collections.sort(ll);
        Collections.sort(list);
        System.out.println(list);
        Integer ii = Collections.binarySearch(list, 10);
        System.out.println(ii);

        Integer[] ik = list.toArray(new Integer[0]);

        System.out.println("ik === " + ik[0]);



        Stack<String> sl = new Stack();
        sl.push("sss");
        System.out.println(sl.peek());


        int ppp = 11;
        System.out.println(ppp >>> 1);
    }
}
