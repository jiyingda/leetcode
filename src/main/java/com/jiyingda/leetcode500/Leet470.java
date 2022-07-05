package com.jiyingda.leetcode500;

/**
 *
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 *
 * 输入: 3
 * 输出: [8,1,10]
 *  
 *
 * 提示:
 *
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 *  
 *
 * 进阶:
 *
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiyingda
 * @date 2021/6/21
 */
public class Leet470 {
    static int[] num57 = new int[20];
    static {
        int t = 0;
        int p = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                num57[p] = t+1;
                p++;
                t++;
                if (t == 10) {
                    t = 0;
                }
            }
        }
    }


    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {

            System.out.println(rand10());
        }

    }

    public static int rand10() {
        int aa = rand7() + rand7();
        int cc = num57[aa];
        while (cc > 10) {
            aa += rand7();
            if (aa > 10) {
                aa -= 10;
            }
        }
        return aa;
    }

    public static int rand7() {
        return (int)(Math.random() * 7) + 1;
    }
}
