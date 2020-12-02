package com.jiyingda.code;

/**
 * @author jiyingda
 * @date 2020/11/28 22:57
 */
public class Cube {
    public static void main(String[] args) {

        int n = 200;
        long q = System.currentTimeMillis();

        for(int a = 1; a <= n; a++){
            int aaa = a * a * a;
            for(int b = 1; b <= a; b++){
                int bbb = b*b*b;
                for(int c = 1; c <= b; c++){
                    int ccc = c*c*c;
                    if(aaa < bbb + ccc){
                        break;
                    }
                    for(int d = 1; d <= c; d++){
                        int ddd = d*d*d;
                        if(aaa < bbb + ccc + ddd){
                            break;
                        }
                        if(aaa == bbb + ccc + ddd){
                            System.out.println(aaa + ":" + bbb + ":" +ccc + ":" + ddd);
                        }
                    }
                }
            }
        }
        //185
        long w = System.currentTimeMillis();

        System.out.println(w-q);

    }

}
