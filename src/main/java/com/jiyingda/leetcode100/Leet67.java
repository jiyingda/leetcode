package com.jiyingda.leetcode100;

/**
 * @author jiyingda
 * @date 2020/6/1
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet67 {

    public static void main(String[] args){
        String a = "0", b = "1";
        System.out.println(addBinary(a, b));
    }


    public static String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }
        int L = Math.max(n, m);

        int carry = 0, j = m - 1;
        int k = L ;
        char[] re = new char[L +1];
        for(int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            if (carry % 2 == 1) {
                re[k] = '1';
            }
            else {
                re[k] = '0';
            }
            k--;

            carry /= 2;
        }
        if (carry == 1) {
            re[k] = '1';
            return String.valueOf(re);
        } else {
            return String.valueOf(re, 1, L );
        }





    }
}
