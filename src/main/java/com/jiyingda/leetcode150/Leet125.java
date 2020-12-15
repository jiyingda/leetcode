package com.jiyingda.leetcode150;

/**
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2020/12/15 22:54
 */
public class Leet125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.print(isPalindrome(s));;

    }


    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        if(chars.length < 2){
            return true;
        }
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if(chars[i] == chars[j]){
                i++;
                j--;
            } else {
                if(isOtherChar(chars[i])){
                    i++;
                } else if(isOtherChar(chars[j])){
                    j--;
                }  else {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isOtherChar(char c){
        return ((int) c < 48 || (int) c > 57) && ((int) c < 97 || (int) c > 122);
    }
}
