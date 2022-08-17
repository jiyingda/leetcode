/**
 * @(#)UserSchoolTest.java, 8月 31, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class UserSchoolTest {

    public static void main(String[] args) {
        String s = "CREATE TABLE `user_school_";
        String ss = "` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
                "  `userId` bigint(20) NOT NULL COMMENT '用户Id',\n" +
                "  `phaseId` tinyint(4) NOT NULL COMMENT '阶段id',\n" +
                "  `schoolId` varchar(255) NOT NULL COMMENT '学校id',\n" +
                "  `dbctime` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',\n" +
                "  `dbutime` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `uq_userId_phaseId` (`userId`, `phaseId`),\n" +
                "  KEY `idx_dbctime` (`dbutime`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户学校';";
        for (int i = 0; i < 8; i++) {
            System.out.println(s + i + ss);
        }
    }
}