/**
 * @(#)WinterOnline3.java, 12月 29, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class WinterOnline3 {

    public static void main(String[] args) {
        String s = FileReader.readFromVsV2("晨读_online");
        String grade_content_1 = FileReader.readFromVsV2("grade_content_1");
        String grade_content_2 = FileReader.readFromVsV2("grade_content_2");
        String grade_content_3 = FileReader.readFromVsV2("grade_content_3");
        Map<String, Map<String, Long>> map = doCd(s);
        long id = 136;
        doOneGrade(grade_content_1, id, map);
        doOneGrade2(grade_content_2, id + 8, map);
        doOneGrade3(grade_content_3, id + 17, map);
    }


    public static Map<String, Map<String, Long>> doCd(String content) {
        Map<String, Map<String, Long>> stringMapMap = new HashMap<>();
        String[] ss = content.split("\n");
        for (String s : ss) {
            String[] aa = s.split("\t");
            String key = aa[1].replace("第", "").replace("天", "");
            if (stringMapMap.containsKey(key)) {
                stringMapMap.get(key).put(aa[3], Long.parseLong(aa[2]));
                if ("数学_人教版".equals(aa[3])) {
                    stringMapMap.get(key).put("数学_北师大版", Long.parseLong(aa[2]));
                    stringMapMap.get(key).put("数学_苏教版", Long.parseLong(aa[2]));
                }
            } else {
                Map<String, Long> ma = new HashMap<>();
                ma.put(aa[3], Long.parseLong(aa[2]));
                if ("数学_人教版".equals(aa[3])) {
                    ma.put("数学_北师大版", Long.parseLong(aa[2]));
                    ma.put("数学_苏教版", Long.parseLong(aa[2]));
                }
                stringMapMap.put(key, ma);
            }

        }
        return stringMapMap;
    }

    public static void doOneGrade(String content, long id, Map<String, Map<String, Long>> cdMap) {
        String[] ss = content.split("\n");
        Map<String, WinterBoundContentInfoPO> map = new HashMap<>();
        for (String s : ss) {
            String[] aa = s.split("\t");
            String key = aa[1].replace("第", "").replace("天", "");
            if ("学习目标".equals(aa[3])) {
                WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();
                boundContentInfoPO.setLearningGoal(Long.parseLong(aa[2]));
                boundContentInfoPO.setWinterTaskList(new ArrayList<>());
                map.put(key, boundContentInfoPO);
                continue;
            }
            if ("拓展阅读".equals(aa[3])) {
                if (map.containsKey(key)) {
                    map.get(key).setExtendedReading(Long.parseLong(aa[2]));
                } else {
                    WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();
                    boundContentInfoPO.setExtendedReading(Long.parseLong(aa[2]));
                    boundContentInfoPO.setWinterTaskList(new ArrayList<>());
                    map.put(key, boundContentInfoPO);
                }
                continue;
            }
            WinterTaskPO po = new WinterTaskPO();
            po.setId(getId(aa[3]));
            po.setBookVersion(getBookversion(aa[3]));
            po.setName(aa[3]);
            po.setSubjectId(getSubjectId(aa[3]));
            po.setExerciseId(Long.parseLong(aa[2]));
            if (!"预习衔接卷".equals(key) && !"复习巩固卷".equals(key) && !"复习突破卷".equals(key) && !"跨学科实践活动".equals(key)) {
                po.setExplanation(po.getExerciseId());
            }

            if (cdMap.containsKey(key)) {
                // 晨读
                po.setMorningReading(cdMap.get(key).getOrDefault(po.getName(), 0L));
            }
            if (map.containsKey(key)) {
                map.get(key).getWinterTaskList().add(po);
            } else {
                WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();

                List<WinterTaskPO> winterTaskList = new ArrayList<>();
                winterTaskList.add(po);
                boundContentInfoPO.setWinterTaskList(winterTaskList);
                map.put(key, boundContentInfoPO);
            }
        }
        for (int day = 1; day < 8; day++) {
            WinterBoundContentInfoPO po = map.get(""+day);
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po0 = map.get("跨学科实践活动");
        if (po0 != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po0) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po = map.get("复习突破卷");
        if (po != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO pof = map.get("复习巩固卷");
        if (pof != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(pof) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO poy = map.get("预习衔接卷");
        if (poy != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(poy) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
    }

    public static void doOneGrade2(String content, long id, Map<String, Map<String, Long>> cdMap) {
        String[] ss = content.split("\n");
        Map<String, WinterBoundContentInfoPO> map = new HashMap<>();
        for (String s : ss) {
            String[] aa = s.split("\t");
            String key = aa[1].replace("第", "").replace("天", "");
            if (aa.length != 4) {
                System.out.println(s);
            }
            if ("学习目标".equals(aa[3])) {
                WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();
                boundContentInfoPO.setLearningGoal(Long.parseLong(aa[2]));
                boundContentInfoPO.setWinterTaskList(new ArrayList<>());
                map.put(key, boundContentInfoPO);
                continue;
            }
            if ("拓展阅读".equals(aa[3])) {
                if (map.containsKey(key)) {
                    map.get(key).setExtendedReading(Long.parseLong(aa[2]));
                } else {
                    WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();
                    boundContentInfoPO.setExtendedReading(Long.parseLong(aa[2]));
                    boundContentInfoPO.setWinterTaskList(new ArrayList<>());
                    map.put(key, boundContentInfoPO);
                }
                continue;
            }
            WinterTaskPO po = new WinterTaskPO();
            po.setId(getId(aa[3]));
            po.setBookVersion(getBookversion(aa[3]));
            po.setName(aa[3]);
            po.setSubjectId(getSubjectId(aa[3]));
            po.setExerciseId(Long.parseLong(aa[2]));
            if (!"预习衔接卷".equals(key) && !"复习巩固卷".equals(key) && !"复习突破卷".equals(key) && !"跨学科实践活动".equals(key)) {
                po.setExplanation(po.getExerciseId());
            }
            if (cdMap.containsKey(key)) {
                // 晨读
                po.setMorningReading(cdMap.get(key).getOrDefault(po.getName(), 0L));
            }
            if (map.containsKey(key)) {
                map.get(key).getWinterTaskList().add(po);
            } else {
                WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();

                List<WinterTaskPO> winterTaskList = new ArrayList<>();
                winterTaskList.add(po);
                boundContentInfoPO.setWinterTaskList(winterTaskList);
                map.put(key, boundContentInfoPO);
            }
        }
        for (int day = 8; day < 15; day++) {
            WinterBoundContentInfoPO po = map.get(""+day);
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po0 = map.get("跨学科实践活动");
        if (po0 != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po0) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po = map.get("复习突破卷");
        if (po != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO pof = map.get("复习巩固卷");
        if (pof != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(pof) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO poy = map.get("预习衔接卷");
        if (poy != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(poy) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
    }

    public static void doOneGrade3(String content, long id, Map<String, Map<String, Long>> cdMap) {
        String[] ss = content.split("\n");
        Map<String, WinterBoundContentInfoPO> map = new HashMap<>();
        for (String s : ss) {
            String[] aa = s.split("\t");
            String key = aa[1];
            if (aa[1].startsWith("第")) {
                key = String.valueOf(Integer.parseInt(aa[1].replace("第", "").replace("天", "")) + 14);
            }

            if ("学习目标".equals(aa[3])) {
                WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();
                boundContentInfoPO.setLearningGoal(Long.parseLong(aa[2]));
                boundContentInfoPO.setWinterTaskList(new ArrayList<>());
                map.put(key, boundContentInfoPO);
                continue;
            }
            if ("拓展阅读".equals(aa[3])) {
                if (map.containsKey(key)) {
                    map.get(key).setExtendedReading(Long.parseLong(aa[2]));
                } else {
                    WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();
                    boundContentInfoPO.setExtendedReading(Long.parseLong(aa[2]));
                    boundContentInfoPO.setWinterTaskList(new ArrayList<>());
                    map.put(key, boundContentInfoPO);
                }
                continue;
            }
            WinterTaskPO po = new WinterTaskPO();
            po.setId(getId(aa[3]));
            po.setBookVersion(getBookversion(aa[3]));
            po.setName(aa[3]);
            po.setSubjectId(getSubjectId(aa[3]));
            po.setExerciseId(Long.parseLong(aa[2]));
            if (!"预习衔接卷".equals(key) && !"复习巩固卷".equals(key) && !"复习突破卷".equals(key) && !"跨学科实践活动".equals(key)) {
                po.setExplanation(po.getExerciseId());
            }
            if (cdMap.containsKey(key)) {
                // 晨读
                po.setMorningReading(cdMap.get(key).getOrDefault(po.getName(), 0L));
            }
            if (map.containsKey(key)) {
                map.get(key).getWinterTaskList().add(po);
            } else {
                WinterBoundContentInfoPO boundContentInfoPO = new WinterBoundContentInfoPO();

                List<WinterTaskPO> winterTaskList = new ArrayList<>();
                winterTaskList.add(po);
                boundContentInfoPO.setWinterTaskList(winterTaskList);
                map.put(key, boundContentInfoPO);
            }
        }
        for (int day = 15; day < 22; day++) {
            WinterBoundContentInfoPO po = map.get(""+day);
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po0 = map.get("跨学科实践活动");
        if (po0 != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po0) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po = map.get("复习突破卷");
        if (po != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO pof = map.get("复习巩固卷");
        if (pof != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(pof) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO poy = map.get("预习衔接卷");
        if (poy != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(poy) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
    }

    private static int getBookversion(String subjectName) {
        if ("数学_北师大版".equals(subjectName)) {
            return 2;
        }
        if ("数学_苏教版".equals(subjectName)) {
            return 3;
        }
        return 0;
    }

    private static int getId(String subjectName) {
        if ("语文".equals(subjectName)) {
            return 1;
        }
        if ("数学".equals(subjectName)) {
            return 2;
        }
        if ("英语".equals(subjectName)) {
            return 3;
        }
        /*if ("物理".equals(subjectName)) {
            return 4;
        }
        if ("化学".equals(subjectName)) {
            return 5;
        }*/
        if ("数学_人教版".equals(subjectName)) {
            return 2;
        }
        if ("数学_北师大版".equals(subjectName)) {
            return 4;
        }
        if ("数学_苏教版".equals(subjectName)) {
            return 5;
        }
        if ("跨学科实践活动".equals(subjectName)) {
            return 1;
        }
        return 6;
    }

    private static int getSubjectId(String subjectName) {
        if ("语文".equals(subjectName)) {
            return 1;
        }
        if ("数学".equals(subjectName)) {
            return 2;
        }
        if ("数学_北师大版".equals(subjectName)) {
            return 2;
        }
        if ("数学_苏教版".equals(subjectName)) {
            return 2;
        }
        if ("数学_人教版".equals(subjectName)) {
            return 2;
        }
        if ("英语".equals(subjectName)) {
            return 3;
        }
        if ("物理".equals(subjectName)) {
            return 4;
        }
        if ("化学".equals(subjectName)) {
            return 5;
        }
        return 99;
    }
}
