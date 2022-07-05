package com.jiyingda.leetcode500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2021/1/1 22:56
 */
public class Leet208 {
    public static void main(String[] args) {
        Leet208 trie = new Leet208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));;
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


    private Map<Character, Map> map;
    private Set<String> set;

    /** Initialize your data structure here. */
    public Leet208() {
        this.map = new HashMap<>();
        this.set  = new HashSet<>();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        set.add(word);
        Map<Character, Map> tmp = map;
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++){
            Character key = arr[i];
            if(tmp.containsKey(key)){
                tmp = tmp.get(key);
            } else {
                while (i < arr.length) {
                    Map<Character, Map> tt = new HashMap<>();
                    tmp.put(arr[i], tt);
                    tmp = tt;
                    i++;
                }
                break;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return set.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(search(prefix)){
            return true;
        }
        char[] arr = prefix.toCharArray();
        Map<Character, Map> tmp = map;
        for(int i = 0; i < arr.length; i++){
            Character key = arr[i];
            if(tmp.containsKey(key)){
                tmp = tmp.get(key);
            } else {
                return false;
            }
        }
        return true;
    }
}
