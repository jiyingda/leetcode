/**
 * @(#)SyncCatalogMain.java, 9月 19, 2024.
 * <p>
 * Copyright 2024 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.megrez;

import com.jiyingda.util.FileReader;
import com.jiyingda.util.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jiyingdabj
 */
public class SyncCatalogMain {

    public static void main(String[] args) {
        runCatalog("synclog", "sync-out.csv");
        runMessagePopup("message-popup", "message-popup-out.csv");
        runSyncGen("sync-gen-log", "sync-gen-out.csv");
        runMathVideo("math-video-log", "math-video-out.csv");
        runChineseMainPoint("chinese-main-point-log", "chinese-main-point-out.csv");
        runLastExercise("lastExercise-log", "lastExercise-out.csv");
        runEnglishMainPoint("english-main-point-log", "english-main-point-out.csv");
        runEnglishUnitSummary("english-unit-summary-log", "english-unit-summary-out.csv");
        runChineseUnitSummary("chinese-unit-summary-log", "chinese-unit-summary-out.csv");
        runSimilarQuestion("similar-question-log", "similar-question-out.csv");
        getUserIds();
    }

    private static void getUserIds() {
        List<String> rrr = new ArrayList<>();
        List<String> list =  FileReader.readFromVsPts("userIds");
        for (String s : list) {
            String[] array = s.split("generate-memberId: ");
            if (array.length < 2) {
                continue;
            }
            System.out.print(array[1] + ",");
        }
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=test&ql=%22%E5%90%8C%E6%AD%A5%E7%BB%83%E4%B8%BE%E4%B8%80%E5%8F%8D%E4%B8%89%E5%87%BA%E9%A2%98%E8%AF%B7%E6%B1%82%2C%20request%3A%22&time=1726099200000-1726646400000
    private static void runSimilarQuestion(String inFile, String outFile) {
        List<String> rrr = new ArrayList<>();
        List<String> list =  FileReader.readFromVsPts(inFile);
        for (String s : list) {
            String[] array = s.split("同步练举一反三出题请求, request:");
            if (array.length < 2) {
                continue;
            }
            String aa = array[1].replaceAll("\"\"", "\"");
            System.out.println(aa);
            rrr.add(aa);
        }

        FileWriter.writePts(outFile, rrr);
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=service%20%3D%20megrez-sync-exercise%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fchinese%2Funit-summary%20AND%20%22%01sc%3D200%22&time=day
    private static void runChineseUnitSummary(String inFile, String outFile) {
        // bookVersion=4&grade=1&semester=1&keypointId=1032354&clientTraceId=${clientTraceId}&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("bookVersion", "grade", "semester", "keypointId", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        runWithList(inFile, outFile, set);
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=service%20%3D%20megrez-sync-exercise%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fenglish%2Funit-summary%20AND%20%22%01sc%3D200%22&time=4h
    private static void runEnglishUnitSummary(String inFile, String outFile) {
        // bookVersion=1024&unitId=1036918&keypointIds=1036919&keypointIds=1036920&keypointIds=1036921&keypointIds=1036918&clientTraceId=${clientTraceId}&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("bookVersion", "unitId", "keypointIds", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        runWithList(inFile, outFile, set);
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=service%20%3D%20megrez-sync-exercise%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fenglish%2Fmain-point%20AND%20%22%01sc%3D200%22&time=4h
    private static void runEnglishMainPoint(String inFile, String outFile) {
        // bookVersion=1024&grade=1&semester=1&keypointId=1036919&clientTraceId=2c0fad28-a886-36cc-80c5-aeb98d676ee1&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("bookVersion", "grade", "semester", "keypointId", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=test&ql=service%20%3D%20megrez-math%20AND%20url%20%3D%20%2Fmegrez-math%2Fandroid%2FcommonExercises%2FlastExercise%20AND%20%22%01sc%3D200%22&time=1726635600000-1726650000000
    private static void runLastExercise(String inFile, String outFile) {
        // subjectId=2&exerciseType=10003&clientTraceId=2c0fad28-a886-36cc-80c5-aeb98d676ee1&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("subjectId", "exerciseType", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=service%20%3D%20megrez-sync-exercise%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fchinese%2Fmain-point%20AND%20%22%01sc%3D200%22&time=4h
    private static void runChineseMainPoint(String inFile, String outFile) {
        // bookVersion=4&grade=1&semester=1&keypointId=1029175&clientTraceId=15c75ec7-76b6-3473-a62c-e8b7ba2c56bb&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("bookVersion", "grade", "semester", "keypointId", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    // 日志地址 https://octopus.zhenguanyu.com/#/logs/search?env=test&ql=service%20%3D%20megrez-sync-exercise%20AND%20%22%01sc%3D200%22%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fmath%2Fknowledge-explanation-video&time=2d
    private static void runMathVideo(String inFile, String outFile) {
        // keypointId=1000175&bookVersion=1&clientTraceId=5b6fd776-b36c-3273-8882-e5a5ae842c26&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("keypointId", "bookVersion", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    // https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=service%20%3D%20megrez-sync-exercise%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fgen%20AND%20%22%01sc%3D200%22&time=15m
    private static void runSyncGen(String inFile, String outFile) {
        // keypointId=1000167&subjectId=2&grade=1&semester=1&clientTraceId=6558497f-afee-3906-b659-2a0f7f13f383&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("keypointId", "subjectId", "grade", "semester", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    // https://octopus.zhenguanyu.com/#/logs/search?env=test&ql=url%20%3D%20%2Fmegrez-profile%2Fandroid%2Fmessage-popup%2Fhome%20AND%20service%20%3D%20megrez-profile%20AND%20%22%01sc%3D200%22&time=1d
    private static void runMessagePopup(String inFile, String outFile) {
        // clientTraceId=0a618020-7414-3980-b56f-24fcfb7071a1&_productId=2011&platform=android30&YFD_U=XYS2LQ230510W00188&version=2.23.0&YFD_OS=1.0.1.73%28S2RD243C%29&YFD_SUPPLIER=S2&YFD_MODEL=S2&YFD_SUB_MODEL=S2%28T1000%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.23.0&rebootByAutoUpdate=&deviceIsInteractive=1&YFD_GRADE=1&YFD_PHASE=2&YFD_SEMESTER=1
        Set<String> set = new HashSet<>(Arrays.asList("clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    // https://octopus.zhenguanyu.com/#/logs/search?env=online&ql=service%20%3D%20megrez-sync-exercise%20AND%20url%20%3D%20%2Fmegrez-sync-exercise%2Fandroid%2Fsync-exercises%2Fcatalogue%20AND%20%22%01sc%3D200%22&time=15m
    private static void runCatalog(String inFile, String outFile) {
        Set<String> set = new HashSet<>(Arrays.asList("subjectId", "bookVersion", "grade", "semester", "volume", "clientTraceId", "_productId", "platform", "YFD_U", "version", "YFD_OS", "YFD_SUPPLIER", "YFD_MODEL", "YFD_SUB_MODEL", "YFD_APP", "_lastAppVersion", "rebootByAutoUpdate", "deviceIsInteractive", "YFD_GRADE", "YFD_PHASE", "YFD_SEMESTER"));
        run(inFile, outFile, set);
    }

    private static void run(String inFile, String outFile, Set<String> set) {
        List<String> rrr = new ArrayList<>();
        List<String> list =  FileReader.readFromVsPts(inFile);
        for (String s : list) {
            String[] array = s.split(" \u0001");
            if (array.length < 5) {
                continue;
            }
            Map<String, Object> map = new HashMap<>();
            for (String ss : array) {
                String[] aaa = ss.split("=");
                if (aaa.length != 2) {
                    continue;
                }
                if (set.contains(aaa[0])) {
                    map.put(aaa[0], aaa[1]);
                }
            }
            map.put("YFD_U", "CSNATU07SYW00105");
            map.put("clientTraceId", "4d8ddb00-ec27-3712-8f8c-3091dfb291f0");

            String pp = SyncCatalogMain.appendParams(map);

            System.out.println(pp);
            rrr.add(pp);
        }

        FileWriter.writePts(outFile, rrr);
    }

    private static void runWithList(String inFile, String outFile, Set<String> set) {
        List<String> rrr = new ArrayList<>();
        List<String> list =  FileReader.readFromVsPts(inFile);
        for (String s : list) {
            String[] array = s.split(" \u0001");
            if (array.length < 5) {
                continue;
            }
            Map<String, List<Object>> map = new HashMap<>();
            for (String ss : array) {
                String[] aaa = ss.split("=");
                if (aaa.length != 2) {
                    continue;
                }
                if (set.contains(aaa[0])) {
                    map.putIfAbsent(aaa[0], new ArrayList<>());
                    map.get(aaa[0]).add(aaa[1]);
                }
            }
            map.put("YFD_U", Arrays.asList("CSNATU07SYW00105"));
            map.put("clientTraceId", Arrays.asList("4d8ddb00-ec27-3712-8f8c-3091dfb291f0"));

            String pp = SyncCatalogMain.appendParamsWithList(map);

            System.out.println(pp);
            rrr.add(pp);
        }

        FileWriter.writePts(outFile, rrr);
    }

    public static String appendParams(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String appendParamsWithList(Map<String, List<Object>> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
            for (Object o : entry.getValue()) {
                sb.append(entry.getKey()).append("=").append(o).append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}