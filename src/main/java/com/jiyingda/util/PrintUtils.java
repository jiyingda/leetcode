/**
 * @(#)PrintUtils.java, 7月 06, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.util;

import com.jiyingda.entity.ListNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class PrintUtils {

    public static void main(String[] args) throws IOException {
        File preTimeFile = new File("/Users/jiyingda/vs/yfda1");
        if(preTimeFile.isFile() && preTimeFile.exists()) {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(preTimeFile), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String sql = "replace into `sold_device` ( `clientId`, `sold`, `dbctime`, `dbutime`) values ( '" + line + "', '1', '2022-08-01 15:56:43', '2022-08-01 15:56:43');";
                System.out.println(sql);
            }
        }

    }

    public static void printArray(int[] array) {
        for (int b : array) {
            System.out.print(b + "\t");
        }
    }

    public static void printArray(List<Integer> array) {
        for (int b : array) {
            System.out.print(b + "\t");
        }
    }

    public static void printArray(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
    }
}
