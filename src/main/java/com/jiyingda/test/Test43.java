/**
 * @(#)Test43.java, 6月 30, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jiyingda
 */
public class Test43 {

    public static void main(String[] args) {
        String province = "广西省的";
        if (province.endsWith("省")) {
            province = province.substring(0, province.length() - 1);
        }
        System.out.println(province);
        M m = new M();
        m.a = "10";
        m.b = "bbb";
        ;
        System.out.println(JSONObject.toJSONString(m));
        System.out.println(Integer.MAX_VALUE);
        int j = 0;
        System.out.println("tutor_profile_shard" + 0);
        for (int i = 0; i < 128; i++) {
            String ssss = "CREATE TABLE `student_level_"+ i +"` (\n" +
                    "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
                    "  `studentId` bigint(20) NOT NULL COMMENT '学生id',\n" +
                    "  `gradeId` int(11) NOT NULL COMMENT '年级',\n" +
                    "  `subjectId` int(11) NOT NULL COMMENT '学科',\n" +
                    "  `labelId` int(11) NOT NULL COMMENT 'labelId',\n" +
                    "  `majorId` int(11) NOT NULL DEFAULT '-1' COMMENT '文理科',\n" +
                    "  `levelId` int(11) NOT NULL COMMENT '等级id',\n" +
                    "  `extra` tinyint(1) NOT NULL DEFAULT '0' COMMENT '后面标志',\n" +
                    "  `disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可见',\n" +
                    "  `productLineId` int(11) DEFAULT '0' COMMENT '用户等级产品线id',\n" +
                    "  `channel` tinyint(4) NOT NULL DEFAULT '0' COMMENT '渠道',\n" +
                    "  `remarks` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',\n" +
                    "  `createdTime` bigint(20) DEFAULT NULL COMMENT '创建时间',\n" +
                    "  `updatedTime` bigint(20) DEFAULT NULL COMMENT '更新时间',\n" +
                    "  `dbctime` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',\n" +
                    "  `dbutime` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  KEY `idx_studentId_gradeId_subjectId_labelId_majorId_productLineId` (`studentId`,`gradeId`,`subjectId`,`labelId`,`majorId`,`productLineId`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT '用户定级';";
            System.out.println(ssss);
            if ((i+1) % 16 == 0) {
                j++;
                System.out.println("tutor_profile_shard" + j);

            }
        }

    }
}

class M {
     String a;
     String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{" +
                "\"a\"='" + a + '\'' +
                ", \"b\"='" + b + '\'' +
                '}';
    }
}