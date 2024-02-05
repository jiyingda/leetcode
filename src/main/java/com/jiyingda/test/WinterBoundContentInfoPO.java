/**
 * @(#)WinterBoundContentInfoPO.java, 12月 20, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import java.util.List;

/**
 * @author jiyingdabj
 */
public class WinterBoundContentInfoPO {

    /**
     * 学习目标
     */
    private long learningGoal;

    /**
     * 扩展阅读
     */
    private long extendedReading;

    /**
     * 任务列表
     */
    private List<WinterTaskPO> winterTaskList;

    public long getLearningGoal() {
        return learningGoal;
    }

    public void setLearningGoal(long learningGoal) {
        this.learningGoal = learningGoal;
    }

    public long getExtendedReading() {
        return extendedReading;
    }

    public void setExtendedReading(long extendedReading) {
        this.extendedReading = extendedReading;
    }

    public List<WinterTaskPO> getWinterTaskList() {
        return winterTaskList;
    }

    public void setWinterTaskList(List<WinterTaskPO> winterTaskList) {
        this.winterTaskList = winterTaskList;
    }
}
