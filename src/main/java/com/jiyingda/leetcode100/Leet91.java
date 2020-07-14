package com.jiyingda.leetcode100;

/**
 * @author jiyingda.
 * @date 2020/7/14.
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet91 {

    public static void main(String[] args){

        System.out.print(numDecodings("230"));;
    }






    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        };
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < chars.length; i++) {
            int tmp = curr;
            if (chars[i] == '0') {
                if (chars[i - 1] == '1' || chars[i - 1] == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }
}
