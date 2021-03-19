package com.jiyingda.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author jiyingda
 * @date 2021/1/20
 */
public class Test2 {


    public static void main(String[] args) throws InterruptedException {
        long userId = 17L;

        /*for (int i = 100000; i < 200000; i++) {
            System.out.print((i & 0xFF) + "--->");
            System.out.println((i & 0xFF) >> 5);
        }*/

        /*for (int i = 100000; i < 200000; i++) {
            System.out.print((i & 0xFF) + "--->");
            System.out.println((i & 0xFF) >> 1);
        }*/

        String sqla = "CREATE TABLE `user_city_";
        String sqlb = "` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `userId` bigint(20) NOT NULL COMMENT '用户Id',\n" +
                "  `adCode` varchar(255) NOT NULL COMMENT '城市code',\n" +
                "  `dbctime` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',\n" +
                "  `dbutime` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `uq` (`userId`),\n" +
                "  KEY `idx_dbctime` (`dbutime`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
        System.out.println("## tutor_profile_shard0");
        int j = 0;
        List<String> list = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < 128; i++) {
            if (i % 16 == 0) {
                System.out.println("## tutor_profile_shard" + j);
                String s = "tutor_profile_shard"+k+".user_city_${"+(k*16)+".."+((k+1)*16 -1)+"},";
                k++;
                list.add(s);
                j++;
            }
            System.out.println(sqla + i + sqlb);
        }

        for (String ss : list) {
            System.out.print(ss);
        }





    }

}
