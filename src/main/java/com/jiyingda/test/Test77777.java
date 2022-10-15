/**
 * @(#)Test77777.java, 4月 19, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONObject;
import sun.jvm.hotspot.opto.HaltNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingda
 */
public class Test77777 {

    // 1631808000000 9-17
    // 1631894400000 9-18
    // 1631980800000 9-19
    // 1632067200000 9-20
    // 1632412800000 9-24
    // 1632499200000 9-25
    // 1632585600000 9-26
    // 1633017600000 10-1
    // 1633104000000 10-2
    // 1633190400000 10-3
    // 1633276800000 10-4
    // 1633363200000 10-5
    // 1633449600000 10-6
    // 1633536000000 10-7
    // 1633622400000 10-8
    // 1633708800000 10-9
    // 1633795200000 10-10

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1632585600000", "1633536000000");
        map.put("1633708800000", "1633449600000");
        Para para = new Para();
        para.setLessonIds(Arrays.asList(
                5758465,5758477,5758481,5758489,5758459,5758471,5758479,5758483,5758935,5758499,5758503,5758505,5758521,5758493,5758515,5758519,5758525,5758507,5758511,5758571,5758533,5758551,5758555,5758569,5758529,5758531,5758545,5758549,5758563,5758565,5758537,5758561,5765065,5765069,5765079,5765081,5776887,5765087,5765095,5765097,5765099,5765105,5765107,5765111,5765115,5765117,5765119,5765121,5765125,5765129,5765135,5765139,5765141,5765149,5765155,5765163,5765169,5765209,5765215,5765223,5765235,5765241,5765253,5765257,5765265,5765267,5673267,5673281,5682987,5673287,5673293,5673297,5673307,5673315,5673319,5673329,5673335,5673341,5673349,5673353,5673357,5673363,5673371,5673377,5673381,5673389,5673397,5673399,5673407,5673409,5673411,5673417,5673431,5673439,5673447,6005309
                ));
                para.setUseTimeMap(true);
        para.setUpdateEpisode(false);
        para.setTimeMap(map);
        para.setDryRun(false);
        para.setUpdateMeg(true);
        System.out.println(JSONObject.toJSONString(para));;

    }






    private static class Para {

        private List<Integer> lessonIds;

        private long delayTimeInMillis;

        private Map<String, String> timeMap;

        private boolean useTimeMap;

        private long filterTime;

        private boolean dryRun;

        private boolean updateEpisode;

        private boolean updateMeg;

        private boolean updateJam;

        private boolean updateStageReview;

        public List<Integer> getLessonIds() {
            return lessonIds;
        }

        public void setLessonIds(List<Integer> lessonIds) {
            this.lessonIds = lessonIds;
        }

        public long getDelayTimeInMillis() {
            return delayTimeInMillis;
        }

        public void setDelayTimeInMillis(long delayTimeInMillis) {
            this.delayTimeInMillis = delayTimeInMillis;
        }

        public Map<String, String> getTimeMap() {
            return timeMap;
        }

        public void setTimeMap(Map<String, String> timeMap) {
            this.timeMap = timeMap;
        }

        public boolean isUseTimeMap() {
            return useTimeMap;
        }

        public void setUseTimeMap(boolean useTimeMap) {
            this.useTimeMap = useTimeMap;
        }

        public long getFilterTime() {
            return filterTime;
        }

        public void setFilterTime(long filterTime) {
            this.filterTime = filterTime;
        }

        public boolean isDryRun() {
            return dryRun;
        }

        public void setDryRun(boolean dryRun) {
            this.dryRun = dryRun;
        }

        public boolean isUpdateEpisode() {
            return updateEpisode;
        }

        public void setUpdateEpisode(boolean updateEpisode) {
            this.updateEpisode = updateEpisode;
        }

        public boolean isUpdateMeg() {
            return updateMeg;
        }

        public void setUpdateMeg(boolean updateMeg) {
            this.updateMeg = updateMeg;
        }

        public boolean isUpdateJam() {
            return updateJam;
        }

        public void setUpdateJam(boolean updateJam) {
            this.updateJam = updateJam;
        }

        public boolean isUpdateStageReview() {
            return updateStageReview;
        }

        public void setUpdateStageReview(boolean updateStageReview) {
            this.updateStageReview = updateStageReview;
        }
    }
}