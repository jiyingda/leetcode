/**
 * @(#)WinterOnline2.java, 12月 29, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class WinterOnline2 {

    public static void main(String[] args) {
        doOneGrade(grade7_content, 163L);
        doOneGrade(grade8_content, 178L);
        doOneGrade(grade9_content, 193L);
    }

    public static void doOneGrade(String content, long id) {
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
            po.setBookVersion(0);
            po.setName(aa[3]);
            po.setSubjectId(getSubjectId(aa[3]));
            po.setExerciseId(Long.parseLong(aa[2]));

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
        for (int day = 1; day < 15; day++) {
            WinterBoundContentInfoPO po = map.get(""+day);
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
            id++;
        }
        WinterBoundContentInfoPO po = map.get("复习突破卷");
        if (po != null) {
            String sql = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po) + "' where id = " + id + ";";
            System.out.println(sql);
        }
        WinterBoundContentInfoPO po1 = map.get("预习衔接卷");
       if (po1 != null) {
           String sql1 = "UPDATE winter_stage set boundContentInfo = '" + JSONObject.toJSONString(po1) + "' where id = " + id + ";";
           System.out.println(sql1);
       }
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
        if ("物理".equals(subjectName)) {
            return 4;
        }
        if ("化学".equals(subjectName)) {
            return 5;
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


    private static String grade7_content = "27130\t第1天\t27132\t学习目标\n" +
            "27130\t第1天\t27134\t英语\n" +
            "27130\t第1天\t27136\t数学\n" +
            "27130\t第1天\t27138\t语文\n" +
            "27130\t第1天\t27140\t拓展阅读\n" +
            "27142\t第2天\t27144\t学习目标\n" +
            "27142\t第2天\t27146\t英语\n" +
            "27142\t第2天\t27148\t数学\n" +
            "27142\t第2天\t27150\t语文\n" +
            "27142\t第2天\t27152\t拓展阅读\n" +
            "27154\t第3天\t27156\t学习目标\n" +
            "27154\t第3天\t27158\t英语\n" +
            "27154\t第3天\t27160\t数学\n" +
            "27154\t第3天\t27162\t语文\n" +
            "27154\t第3天\t27164\t拓展阅读\n" +
            "27166\t第4天\t27168\t学习目标\n" +
            "27166\t第4天\t27170\t英语\n" +
            "27166\t第4天\t27172\t数学\n" +
            "27166\t第4天\t27174\t语文\n" +
            "27166\t第4天\t27176\t拓展阅读\n" +
            "27178\t第5天\t27180\t学习目标\n" +
            "27178\t第5天\t27182\t英语\n" +
            "27178\t第5天\t27184\t数学\n" +
            "27178\t第5天\t27186\t语文\n" +
            "27178\t第5天\t27188\t拓展阅读\n" +
            "27190\t第6天\t27192\t学习目标\n" +
            "27190\t第6天\t27194\t英语\n" +
            "27190\t第6天\t27196\t数学\n" +
            "27190\t第6天\t27198\t语文\n" +
            "27190\t第6天\t27200\t拓展阅读\n" +
            "27202\t第7天\t27204\t学习目标\n" +
            "27202\t第7天\t27206\t英语\n" +
            "27202\t第7天\t27208\t数学\n" +
            "27202\t第7天\t27210\t语文\n" +
            "27202\t第7天\t27212\t拓展阅读\n" +
            "27214\t第8天\t27216\t学习目标\n" +
            "27214\t第8天\t27218\t英语\n" +
            "27214\t第8天\t27220\t数学\n" +
            "27214\t第8天\t27222\t语文\n" +
            "27214\t第8天\t27224\t拓展阅读\n" +
            "27226\t第9天\t27228\t学习目标\n" +
            "27226\t第9天\t27230\t英语\n" +
            "27226\t第9天\t27232\t数学\n" +
            "27226\t第9天\t27234\t语文\n" +
            "27226\t第9天\t27236\t拓展阅读\n" +
            "27238\t第10天\t27240\t学习目标\n" +
            "27238\t第10天\t27242\t英语\n" +
            "27238\t第10天\t27244\t数学\n" +
            "27238\t第10天\t27246\t语文\n" +
            "27238\t第10天\t27248\t拓展阅读\n" +
            "27250\t第11天\t27252\t学习目标\n" +
            "27250\t第11天\t27254\t英语\n" +
            "27250\t第11天\t27256\t数学\n" +
            "27250\t第11天\t27258\t语文\n" +
            "27250\t第11天\t27260\t拓展阅读\n" +
            "27262\t第12天\t27264\t学习目标\n" +
            "27262\t第12天\t27266\t英语\n" +
            "27262\t第12天\t27268\t数学\n" +
            "27262\t第12天\t27270\t语文\n" +
            "27262\t第12天\t27272\t拓展阅读\n" +
            "27274\t第13天\t27276\t学习目标\n" +
            "27274\t第13天\t27278\t英语\n" +
            "27274\t第13天\t27280\t数学\n" +
            "27274\t第13天\t27282\t语文\n" +
            "27274\t第13天\t27284\t拓展阅读\n" +
            "27286\t第14天\t27288\t学习目标\n" +
            "27286\t第14天\t27290\t英语\n" +
            "27286\t第14天\t27292\t数学\n" +
            "27286\t第14天\t27294\t语文\n" +
            "27286\t第14天\t27296\t拓展阅读\n" +
            "27298\t预习衔接卷\t27300\t英语\n" +
            "27298\t预习衔接卷\t27302\t数学\n" +
            "27298\t预习衔接卷\t27304\t语文";
    private static String grade8_content = "27306\t第1天\t27308\t学习目标\n" +
            "27306\t第1天\t27310\t英语\n" +
            "27306\t第1天\t27312\t数学\n" +
            "27306\t第1天\t27314\t语文\n" +
            "27306\t第1天\t27316\t物理\n" +
            "27318\t第2天\t27320\t学习目标\n" +
            "27318\t第2天\t27322\t英语\n" +
            "27318\t第2天\t27324\t数学\n" +
            "27318\t第2天\t27326\t语文\n" +
            "27318\t第2天\t27328\t物理\n" +
            "27330\t第3天\t27332\t学习目标\n" +
            "27330\t第3天\t27334\t英语\n" +
            "27330\t第3天\t27336\t数学\n" +
            "27330\t第3天\t27338\t语文\n" +
            "27330\t第3天\t27340\t物理\n" +
            "27342\t第4天\t27344\t学习目标\n" +
            "27342\t第4天\t27346\t英语\n" +
            "27342\t第4天\t27348\t数学\n" +
            "27342\t第4天\t27350\t语文\n" +
            "27342\t第4天\t27352\t物理\n" +
            "27354\t第5天\t27356\t学习目标\n" +
            "27354\t第5天\t27358\t英语\n" +
            "27354\t第5天\t27360\t数学\n" +
            "27354\t第5天\t27362\t语文\n" +
            "27354\t第5天\t27364\t物理\n" +
            "27366\t第6天\t27368\t学习目标\n" +
            "27366\t第6天\t27370\t英语\n" +
            "27366\t第6天\t27372\t数学\n" +
            "27366\t第6天\t27374\t语文\n" +
            "27366\t第6天\t27376\t物理\n" +
            "27378\t第7天\t27380\t学习目标\n" +
            "27378\t第7天\t27382\t英语\n" +
            "27378\t第7天\t27384\t数学\n" +
            "27378\t第7天\t27386\t语文\n" +
            "27378\t第7天\t27388\t物理\n" +
            "27390\t第8天\t27392\t学习目标\n" +
            "27390\t第8天\t27394\t英语\n" +
            "27390\t第8天\t27396\t数学\n" +
            "27390\t第8天\t27398\t语文\n" +
            "27390\t第8天\t27400\t物理\n" +
            "27402\t第9天\t27404\t学习目标\n" +
            "27402\t第9天\t27406\t英语\n" +
            "27402\t第9天\t27408\t数学\n" +
            "27402\t第9天\t27410\t语文\n" +
            "27402\t第9天\t27412\t物理\n" +
            "27414\t第10天\t27416\t学习目标\n" +
            "27414\t第10天\t27418\t英语\n" +
            "27414\t第10天\t27420\t数学\n" +
            "27414\t第10天\t27422\t语文\n" +
            "27414\t第10天\t27424\t物理\n" +
            "27426\t第11天\t27428\t学习目标\n" +
            "27426\t第11天\t27430\t英语\n" +
            "27426\t第11天\t27432\t数学\n" +
            "27426\t第11天\t27434\t语文\n" +
            "27426\t第11天\t27436\t物理\n" +
            "27438\t第12天\t27440\t学习目标\n" +
            "27438\t第12天\t27442\t英语\n" +
            "27438\t第12天\t27444\t数学\n" +
            "27438\t第12天\t27446\t语文\n" +
            "27438\t第12天\t27448\t物理\n" +
            "27450\t第13天\t27452\t学习目标\n" +
            "27450\t第13天\t27454\t英语\n" +
            "27450\t第13天\t27456\t数学\n" +
            "27450\t第13天\t27458\t语文\n" +
            "27450\t第13天\t27460\t物理\n" +
            "27462\t第14天\t27464\t学习目标\n" +
            "27462\t第14天\t27466\t英语\n" +
            "27462\t第14天\t27468\t数学\n" +
            "27462\t第14天\t27470\t语文\n" +
            "27462\t第14天\t27472\t物理\n" +
            "27474\t预习衔接卷\t27476\t英语\n" +
            "27474\t预习衔接卷\t27478\t数学\n" +
            "27474\t预习衔接卷\t27480\t语文\n" +
            "27474\t预习衔接卷\t27482\t物理";

    private static String grade9_content = "27484\t第1天\t27486\t学习目标\n" +
            "27484\t第1天\t27488\t英语\n" +
            "27484\t第1天\t27490\t数学\n" +
            "27484\t第1天\t27492\t语文\n" +
            "27484\t第1天\t27494\t物理\n" +
            "27484\t第1天\t27496\t化学\n" +
            "27498\t第2天\t27500\t学习目标\n" +
            "27498\t第2天\t27502\t英语\n" +
            "27498\t第2天\t27504\t数学\n" +
            "27498\t第2天\t27506\t语文\n" +
            "27498\t第2天\t27508\t物理\n" +
            "27498\t第2天\t27510\t化学\n" +
            "27512\t第3天\t27514\t学习目标\n" +
            "27512\t第3天\t27516\t英语\n" +
            "27512\t第3天\t27518\t数学\n" +
            "27512\t第3天\t27520\t语文\n" +
            "27512\t第3天\t27522\t物理\n" +
            "27512\t第3天\t27524\t化学\n" +
            "27526\t第4天\t27528\t学习目标\n" +
            "27526\t第4天\t27530\t英语\n" +
            "27526\t第4天\t27532\t数学\n" +
            "27526\t第4天\t27534\t语文\n" +
            "27526\t第4天\t27536\t物理\n" +
            "27526\t第4天\t27538\t化学\n" +
            "27540\t第5天\t27542\t学习目标\n" +
            "27540\t第5天\t27544\t英语\n" +
            "27540\t第5天\t27546\t数学\n" +
            "27540\t第5天\t27548\t语文\n" +
            "27540\t第5天\t27550\t物理\n" +
            "27540\t第5天\t27552\t化学\n" +
            "27554\t第6天\t27556\t学习目标\n" +
            "27554\t第6天\t27558\t英语\n" +
            "27554\t第6天\t27560\t数学\n" +
            "27554\t第6天\t27562\t语文\n" +
            "27554\t第6天\t27564\t物理\n" +
            "27554\t第6天\t27566\t化学\n" +
            "27568\t第7天\t27570\t学习目标\n" +
            "27568\t第7天\t27572\t英语\n" +
            "27568\t第7天\t27574\t数学\n" +
            "27568\t第7天\t27576\t语文\n" +
            "27568\t第7天\t27578\t物理\n" +
            "27568\t第7天\t27580\t化学\n" +
            "27582\t第8天\t27584\t学习目标\n" +
            "27582\t第8天\t27586\t英语\n" +
            "27582\t第8天\t27588\t数学\n" +
            "27582\t第8天\t27590\t语文\n" +
            "27582\t第8天\t27592\t物理\n" +
            "27582\t第8天\t27594\t化学\n" +
            "27596\t第9天\t27598\t学习目标\n" +
            "27596\t第9天\t27600\t英语\n" +
            "27596\t第9天\t27602\t数学\n" +
            "27596\t第9天\t27604\t语文\n" +
            "27596\t第9天\t27606\t物理\n" +
            "27596\t第9天\t27608\t化学\n" +
            "27610\t第10天\t27612\t学习目标\n" +
            "27610\t第10天\t27614\t英语\n" +
            "27610\t第10天\t27616\t数学\n" +
            "27610\t第10天\t27618\t语文\n" +
            "27610\t第10天\t27620\t物理\n" +
            "27610\t第10天\t27622\t化学\n" +
            "27624\t第11天\t27626\t学习目标\n" +
            "27624\t第11天\t27628\t英语\n" +
            "27624\t第11天\t27630\t数学\n" +
            "27624\t第11天\t27632\t语文\n" +
            "27624\t第11天\t27634\t物理\n" +
            "27624\t第11天\t27636\t化学\n" +
            "27638\t第12天\t27640\t学习目标\n" +
            "27638\t第12天\t27642\t英语\n" +
            "27638\t第12天\t27644\t数学\n" +
            "27638\t第12天\t27646\t语文\n" +
            "27638\t第12天\t27648\t物理\n" +
            "27638\t第12天\t27650\t化学\n" +
            "27652\t第13天\t27654\t学习目标\n" +
            "27652\t第13天\t27656\t英语\n" +
            "27652\t第13天\t27658\t数学\n" +
            "27652\t第13天\t27660\t语文\n" +
            "27652\t第13天\t27662\t物理\n" +
            "27652\t第13天\t27664\t化学\n" +
            "27666\t第14天\t27668\t学习目标\n" +
            "27666\t第14天\t27670\t英语\n" +
            "27666\t第14天\t27672\t数学\n" +
            "27666\t第14天\t27674\t语文\n" +
            "27666\t第14天\t27676\t物理\n" +
            "27666\t第14天\t27678\t化学\n" +
            "27680\t复习突破卷\t27682\t英语\n" +
            "27680\t复习突破卷\t27684\t数学\n" +
            "27680\t复习突破卷\t27686\t语文\n" +
            "27680\t复习突破卷\t27688\t物理\n" +
            "27680\t复习突破卷\t27690\t化学";
}
