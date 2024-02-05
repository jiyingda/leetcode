/**
 * @(#)WinterStagePO.java, 12月 19, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingdabj
 */
public class WinterStagePO {

    /**
     * id
     */
    private long id;

    /**
     * 第几天
     */
    private int day;

    /**
     * 名称
     */
    private String name;

    /**
     * 学季
     */
    private long learningSeason;

    /**
     * 年级
     */
    private int grade;

    /**
     * 类型 1练习 2试卷 3跨学科实践活动 4反思自评
     */
    private int type;

    /**
     * 学习阶段
     */
    private int learningStage;

    /**
     * 练习总数
     */
    private int totalNumberOfExercises;

    /**
     * 排序 小的排前面
     */
    private int orderNum;

    /**
     * 绑定内容的信息
     */
    private WinterBoundContentInfoPO boundContentInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLearningSeason() {
        return learningSeason;
    }

    public void setLearningSeason(long learningSeason) {
        this.learningSeason = learningSeason;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLearningStage() {
        return learningStage;
    }

    public void setLearningStage(int learningStage) {
        this.learningStage = learningStage;
    }

    public int getTotalNumberOfExercises() {
        return totalNumberOfExercises;
    }

    public void setTotalNumberOfExercises(int totalNumberOfExercises) {
        this.totalNumberOfExercises = totalNumberOfExercises;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public WinterBoundContentInfoPO getBoundContentInfo() {
        return boundContentInfo;
    }

    public void setBoundContentInfo(WinterBoundContentInfoPO boundContentInfo) {
        this.boundContentInfo = boundContentInfo;
    }
}
