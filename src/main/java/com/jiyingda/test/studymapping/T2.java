/**
 * @(#)T2.java, 4月 21, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
