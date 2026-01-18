/**
 * @(#)DorisPartitionGenerator.java, 11月 25, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.focus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DorisPartitionGenerator {

    /**
     * 生成Doris按天分区的语句
     * @param startDate 起始日期（含），格式：yyyy-MM-dd
     * @param endDate 结束日期（含），格式：yyyy-MM-dd
     * @return 分区语句列表（如 PARTITION p20250817 VALUES [("2025-08-17"), ("2025-08-18")),）
     * @throws ParseException 日期格式错误时抛出
     */
    public static List<String> generateDailyPartitions(String startDate, String endDate) throws ParseException {
        // 日期格式化器（线程不安全，此处局部创建）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 解析起始和结束日期
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);

        // 校验日期有效性
        if (start.after(end)) {
            throw new IllegalArgumentException("起始日期不能晚于结束日期");
        }

        List<String> partitions = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);

        // 循环生成每一天的分区
        while (!calendar.getTime().after(end)) {
            // 当前日期（分区起始）
            Date currentDate = calendar.getTime();
            String currentDateStr = sdf.format(currentDate);

            // 下一天（分区结束，左闭右开）
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Date nextDate = calendar.getTime();
            String nextDateStr = sdf.format(nextDate);

            // 分区名：p + 8位日期（如 p20250817）
            String partitionName = "p" + currentDateStr.replace("-", "");

            // 拼接分区语句（如 PARTITION p20250817 VALUES [("2025-08-17"), ("2025-08-18")),）
            String partitionSql = String.format(
                    "PARTITION %s VALUES [(\"%s\"), (\"%s\")),",
                    partitionName, currentDateStr, nextDateStr
            );
            partitions.add(partitionSql);
        }

        return partitions;
    }

    // 测试示例
    public static void main(String[] args) {
        try {
            // 生成2025-08-28至2025-11-26的分区（共90天）
            List<String> partitions = generateDailyPartitions("2025-08-28", "2025-11-26");

            // 打印分区语句（可直接复制到建表语句中）
            for (String partition : partitions) {
                System.out.println(partition);
            }
        } catch (ParseException e) {
            System.err.println("日期格式错误，请使用yyyy-MM-dd格式");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}