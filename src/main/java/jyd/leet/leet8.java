package jyd.leet;

public class leet8 {
    public static void  main(String[] args){
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        char[] sss = str.toCharArray();
        int length = str.length();
        String re = "";
        if(sss.length < 1) return 0;
        if(sss[0] == 45 || sss[0] == 43){
            int i = 1;
            while (i < length && sss[i] >= 48 && sss[i] <= 57 ){
                i++;
            }
            if(i == 1){
                return 0;
            }
           re = str.substring(0, i);


        }else{
            int i = 0;
            while (i < length && sss[i] >= 48 && sss[i] <= 57 ){
                i++;
            }
            if(i == 0){
                return 0;
            }
            re = str.substring(0, i);
        }
        long ll = 0;
        try {
            ll = Long.parseLong(re);
        } catch (NumberFormatException e){
            if(sss[0] == 45){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        if(ll < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(ll > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        return (int)ll;
    }
}
