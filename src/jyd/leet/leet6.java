package jyd.leet;

public class leet6 {
    public static void main(String... args){
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR");

    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        int k = length / (numRows - 1);
        int m = length % (numRows - 1);
        char[] sss = s.toCharArray();
        char[] re = new char[length];
        int i = 0;
        for(int n = 0; n < numRows; n++){
            for(int p = 0; p < k; p++){
                int tmp = 2 * p * (numRows - 1) + n;
                if(tmp < length && i < length){
                    re[i] = sss[tmp];
                    i++;
                }
            }
        }

        return String.valueOf(re);
    }
}
