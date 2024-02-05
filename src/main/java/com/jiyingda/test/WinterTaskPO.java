/**
 * @(#)WinterTaskPO.java, 12月 20, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;


/**
 * @author jiyingdabj
 */
public class WinterTaskPO {

    /**
     * id
     */
    private long id;

    /**
     * 学科
     */
    private int subjectId;

    /**
     * 名称
     */
    private String name;

    /**
     * 教材版本
     */
    private int bookVersion;

    /**
     * 练习
     */
    private long exerciseId;

    /**
     * 晨读
     */
    private long morningReading;

    /**
     * 讲解 视频
     */
    private long explanation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookVersion() {
        return bookVersion;
    }

    public void setBookVersion(int bookVersion) {
        this.bookVersion = bookVersion;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public long getMorningReading() {
        return morningReading;
    }

    public void setMorningReading(long morningReading) {
        this.morningReading = morningReading;
    }

    public long getExplanation() {
        return explanation;
    }

    public void setExplanation(long explanation) {
        this.explanation = explanation;
    }
}
