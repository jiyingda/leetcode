/**
 * @(#)Leet1032.java, 3月 24, 2023.
 * <p>
 * Copyright 2023 chapaof.com. All rights reserved.
 * chapaof.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode2000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 *
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 *
 * 按下述要求实现 StreamChecker 类：
 *
 * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 *
 *
 * 示例：
 *
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 *
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] 由小写英文字母组成
 * letter 是一个小写英文字母
 * 最多调用查询 4 * 104 次
 *
 * https://leetcode.cn/problems/stream-of-characters/
 *
 * @author jiyingda
 */
public class Leet1032 {
    public static void main(String[] args) {
        Leet1032 leet1032 = new Leet1032(new String[]{"ab","ba","aaab","abab","baa"});
        // ["a"],["a"],["a"],["a"],["a"],
        // ["b"],["a"],["b"],["a"],["b"]
        // ,["b"],["b"],["a"],["b"],["a"],
        // ["b"],["b"],["b"],["b"],["a"],
        // ["b"],["a"],["b"],["a"],["a"],
        // ["a"],["b"],["a"],["a"],["a"]]
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));

        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('b'));

        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));

        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));

        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));

        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('b'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));
        System.out.println(leet1032.query('a'));
        //false,false,false,false,false,true,true,true,true,true,false,false,true,true,true,true,false,false,false,true,true,true,true,true,true,false,true,true,true,false

    }


    List<Character> chars;
    Trie trie;

    public Leet1032(String[] words) {
        chars = new ArrayList<>();
        trie = new Trie();
        for(String word: words){
            trie.add(word);
        }
    }

    public boolean query(char letter) {
        chars.add(letter);
        return trie.isSuffix(chars);
    }

    class Trie{
        TrieNode root;  // 根节点

        public Trie(){
            root = new TrieNode();
        }

        /**
         * 添加字符串word到字典树中，因为是匹配后缀，所以是反向添加
         */
        public void add(String word){
            int n = word.length();
            TrieNode node = root;   // 从根节点开始遍历
            int ch;
            while(--n >= 0){
                ch = word.charAt(n) - 'a';      // 获取字符对应的数组索引
                if(node.children[ch] == null){
                    // 子节点不存在 新建一个
                    node.children[ch] = new TrieNode();
                }
                // 获取这一位字符对应的子节点
                node = node.children[ch];
            }
            // 最后一位字符对应的子节点进行标识
            node.isEnd = true;
        }

        /**
         * 判断字符流word是否有后缀存在于字典树中，因为是匹配后缀，所以是反向查找
         */
        public boolean isSuffix(List<Character> word){
            int size = word.size();
            int ch;
            TrieNode node = root;
            while(--size >= 0){
                ch = word.get(size) - 'a';  // 获取字符对应的数组索引
                if(node.isEnd){
                    // 当前节点是一个叶子节点，说明当前遍历到的位置所对应的后缀存在于字典树中
                    return true;
                }else if(node.children[ch] == null){
                    // 这一位字符对应的子节点不存在，说明就没有对应的后缀存在
                    return false;
                }else{
                    // 这一位字符对应的子节点存在，更新子节点
                    node = node.children[ch];
                }
            }
            // 当前节点（对应字符流的第一个字符）是一个叶子节点，就说明整个字符流对应的字符串就是字典树中存储的某个字符串；
            // 如果不是一个叶子节点，整个字符流对应的字符串只是添加到字典树中的某个字符串的后缀。
            return node.isEnd;
        }
    }

    /**
     * 字典树节点
     */
    class TrieNode{
        boolean isEnd = false;      // 是否为叶子节点（是否为添加的字符串的结尾节点）
        TrieNode[] children = new TrieNode[26]; // 子节点
    }

}