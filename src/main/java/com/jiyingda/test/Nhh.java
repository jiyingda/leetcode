/**
 * @(#)Nhh.java, 8月 26, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.FileReader;
import com.jiyingda.util.FileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.lang.reflect.*;

/**
 * @author jiyingdabj
 */
public class Nhh {

    public static void main(String[] args) {
        // 原字符串（包含双重转义的反斜杠，注意Java中定义时需额外转义）
        String original = "投影向量是$(\\\\\\\\frac{\\\\overrightarrow{m}\\\\cdot\\\\overrightarrow{n}}{|\\\\overrightarrow{m}|^2})\\\\overrightarrow{m}$，投影数量是$\\\\frac{\\\\overrightarrow{m}\\\\cdot\\\\overrightarrow{n}}{|\\\\overrightarrow{m}|}$，现在明白了吗？";

        // 去掉多余转义：将两个反斜杠（\\\\）替换为一个反斜杠（\\）
        String processed = original.replace("\\\\", "\\");

        // 输出结果
        System.out.println(original);
        System.out.println(processed);
        String ss ="a-a-a";
        System.out.println(ss.replace("-", ""));
    }
}