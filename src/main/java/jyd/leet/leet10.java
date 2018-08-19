package jyd.leet;

import java.util.HashMap;
import java.util.Map;

public class leet10 {
    public static void main(String[] args){
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));;
    }

    public static int numJewelsInStones(String J, String S) {
        Map<String, Integer> map = new HashMap();
        char[] jj = J.toCharArray();
        for(int i = 0; i<J.length(); i++){
            map.put(String.valueOf(jj[i]),0);
        }
        int r = 0;
        char[] ss = S.toCharArray();
        for(int j = 0; j < S.length(); j++){
            String sr = String.valueOf(ss[j]);
            if(map.containsKey(sr)){
                r++;
            }
        }
        return r;
    }


}
