package com.jiyingda.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingda
 * @date 2020/6/2
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet68 {


    public static void main(String[] args){

        String[] s = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> ss = fullJustify(s, 16);
        for(String sss : ss){
            System.out.println(sss);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int tmp = words[0].length();
        List<String> rrrrr = new ArrayList<>();
        int left = 0;
        int right = 1;
        char[] lll = new char[maxWidth];
        for(int i = 0; i < maxWidth; i++){
            lll[i] = ' ';
        }
        for(int i = 1; i < words.length;i++){
            if(tmp + words[i].length() + 1 <= maxWidth){
                right++;
                tmp = tmp + words[i].length() + 1;
            } else {
                int size = right - left;
                int m = maxWidth - tmp + size - 1;

                if(size == 1){
                    rrrrr.add(words[left] + String.valueOf(lll, 0, maxWidth - words[left].length()));
                } else {
                    int n = m/(size-1);
                    int k = m % (size-1);
                    StringBuilder sb = new StringBuilder();
                    for(int p = left; p < right;p++){
                        if(p == right - 1){
                            sb.append(words[p]);
                        } else {
                            if(k > 0){
                                sb.append(words[p]).append(lll, 0, n + 1);
                                k--;
                            } else {
                                sb.append(words[p]).append(lll, 0, n);
                            }
                        }
                    }
                    rrrrr.add(sb.toString());
                }
                tmp = words[i].length();
                left = i;
                right = left + 1;
            }
        }
        if(right - left > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = left; i < right; i++){
                sb.append(words[i]);
                if(sb.length() < maxWidth){
                    sb.append(' ');
                }
            }
            int d = maxWidth - sb.length();
            if(d > 0){
                sb.append(lll, 0, d);
            }
            rrrrr.add(sb.toString());
        }
        return rrrrr;

    }
}
