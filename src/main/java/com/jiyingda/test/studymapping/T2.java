/**
 * @(#)T2.java, 4月 21, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * 
 */
package com.jiyingda.test.studymapping;

import com.jiyingda.util.FileReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jiyingdabj
 */
public class T2 {
    //

    /**
     * 1158
     * 1160
     * 1162
     * 1164
     * 1186
     * 1188
     * 1190
     * 1192
     * 1194
     * 1196
     * 1216
     * 1218
     * 1220
     * 1222
     * 1224
     * 1226
     * 1228
     * 1244
     * 1246
     * 1248
     * 1250
     * 1252
     * 1254
     * 1256
     * 1282
     * 1284
     * 1286
     * 1288
     * 1290
     * 1292
     * 1296
     * 1298
     * 1299
     * 1300
     * 1302
     * 1304
     * 1308
     * 1310
     * 1320
     * 1322
     * 1324
     * 1342
     * 1344
     * 1346
     * 1348
     * 1350
     * 1352
     * 1354
     * 1356
     * 1358
     * 1360
     * 1362
     * 1364
     * 1368
     * 1390
     * 1410
     * 1424
     * 1486
     * 1524
     * 1526
     * 1552
     * 1566
     * 1576
     * 1584
     * 1612
     * 1632
     * 1916
     * 1918
     * 1920
     * 1922
     * 1924
     * 2050
     * 2119
     * 2120
     * @param args
     */

    public static void main(String[] args) {
        String ssssss = "“5·3专区”目前已支持以下版本\n\n小学数学：人教版、北师大版、苏教版、北京版、冀教版、西师版、青岛六三、青岛五四、\n小学英语：人教PEP版、人教精通版、外研三起点版、苏教译林版、北京一起点版、沪教三起点版、沪教牛津版、教科三起点版、教科EEC版、湘少三起点版\n小学语文：统编版、统编版五四制\n初中数学：人教版、北师大版、鲁教版、苏科版、华师版、北京课改版、青岛六三、浙教版、沪科版、湘教版、冀教版\n初中英语：人教版、沪教版、译林版、外研版、冀教版、北师大版、鲁教版\n初中语文：统编版、统编版五四制\n初中化学：鲁教版、沪教版、科粤版、北京课改版\n初中生物：人教版、北京课改版、北师大版、苏教版、济南版、冀少版、鲁科版\n初中道德与法治：人教版\n初中历史：人教版\n初中地理：人教版、中图版、湘教版、商务星球版、鲁教版\n高中数学：人教A版（2019）、人教B版（2019）北师大版、苏教版、湘教版\n高中英语：人教版（2019）、北师大版、外研版、译林版\n高中语文：部编版（2019）\n高中物理：人教版（2019）、教科版、鲁科版、粤教版\n高中化学：人教版（2019）、鲁科版、苏教版\n高中生物：浙科版、苏教版\n高中地理：人教版、湘教版、中图版、鲁教版\n高中政治：人教版\n高中历史：人教版\n\n如果没找到正在学习的教材，建议先选择较为通用的「人教版」进行练习。\n同时可以前往微信公众号「小猿智能设备」留言告诉我们。";
        StringBuilder sb = new StringBuilder();
        List<String> list = FileReader.readFromVs("语文字词-online");
        int i = 0;
        for (String kkk : list) {
            String[] llll = kkk.split("\t");
            int k = Integer.parseInt(llll[2]);
            k = k > 1000000 ? k - 1000000 : k;
            sb.append(k).append(",");
            i++;
        }
        // System.out.println(sb);
        String ssss = "29227\n" +
                "29228\n" +
                "29229\n" +
                "29230\n" +
                "29335\n" +
                "29384\n" +
                "36152\n" +
                "36153\n" +
                "36154\n" +
                "36155\n" +
                "36156\n" +
                "36158\n" +
                "36159\n" +
                "36160\n" +
                "36161\n" +
                "36163\n" +
                "36164\n" +
                "36165\n" +
                "36167\n" +
                "36168\n" +
                "36169\n" +
                "36171\n" +
                "36172\n" +
                "36173\n" +
                "36175\n" +
                "36176\n" +
                "36177\n" +
                "36178";
        String[] ll = ssss.split("\n");
        Set<Integer> set = Arrays.stream(ll).map(e -> Integer.parseInt(e)).collect(Collectors.toSet());
        Set<Integer> set2 = new HashSet<>();
        String llll = "";

        for (String s : list) {
            String[] aa = s.split("\t");
            int k = Integer.parseInt(aa[2]);
            k = k > 1000000 ? k - 1000000 : k;
            if (set2.contains(k)) {
                // System.out.println(k);
            } else {
                set2.add(k);
                if (set.contains(k)) {
                    String sql = "UPDATE leo_chinese_keypoint_mapping set leoKeypointId = " + aa[0] + " where keypointId = "  +k+ ";";
                    System.out.println(sql);
                } else {
                    String sql = "INSERT INTO leo_chinese_keypoint_mapping (`name`,bookVersion,grade,semester,leoKeypointId,keypointId) VALUES ('" +
                            aa[1] +"',4,0,0," + aa[0] + "," + k +
                            ");";
                    System.out.println(sql);
                    llll = llll + k + ",";

                }
            }
            System.out.println(llll);




        }

    }
}
