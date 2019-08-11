package jyd.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 * @date 2019/8/10
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet20 {

    public static void main(String[] args){
        System.out.println(isValid("(())([)]"));

    }



    public static boolean isValid(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;
        if(len % 2 != 0){
            return false;
        }
        char[] list = new char[len / 2];
        int l = list.length;
        int i = 0;
        for(char c : ss){
            if('(' == c || '{' == c || '[' == c){
                if(i >= l){
                    return false;
                }
                list[i] = c;
                i++;
            } else if(i < 1){
                return false;
            }else if(')' == c){
                if('(' != list[i - 1]){
                    return false;
                } else {
                    i--;
                }
            }else if(']' == c){
                if('[' != list[i - 1]){
                    return false;
                } else {
                    i--;
                }
            }else if('}' == c){
                if('{' != list[i - 1]){
                    return false;
                } else {
                    i--;
                }
            }
        }

        return i == 0;
    }
}
