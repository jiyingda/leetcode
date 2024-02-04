/**
 * @(#)Question.java, 11月 28, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.jiyingda.util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiyingdabj
 */
public class Question {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("cc");
        l.add("dd");
        l.add("bb");
        l.sort((a, b) -> a.compareTo(b));
        PrintUtils.printArray(l);


        /*List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setQuestionId(6873);
        question.setWeakPoint(true);
        question.setMistakeProneRate(20);
        List<KnowledgePoint> knowledgePoints = new ArrayList<>();
        KnowledgePoint knowledgePoint = new KnowledgePoint();
        knowledgePoint.setId(4370);
        knowledgePoint.setPersonalAccuracyRate(55);
        knowledgePoint.setSameGradeAccuracyRate(66);
        knowledgePoints.add(knowledgePoint);
        question.setKnowledgePoints(knowledgePoints);
        questions.add(question);
        System.out.println(JSONObject.toJSONString(questions));*/
    }

    private long questionId;

    private boolean weakPoint;

    private int mistakeProneRate;

    private List<WinterOnline1> winterOnline1s;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public boolean isWeakPoint() {
        return weakPoint;
    }

    public void setWeakPoint(boolean weakPoint) {
        this.weakPoint = weakPoint;
    }

    public int getMistakeProneRate() {
        return mistakeProneRate;
    }

    public void setMistakeProneRate(int mistakeProneRate) {
        this.mistakeProneRate = mistakeProneRate;
    }

    public List<WinterOnline1> getKnowledgePoints() {
        return winterOnline1s;
    }

    public void setKnowledgePoints(List<WinterOnline1> winterOnline1s) {
        this.winterOnline1s = winterOnline1s;
    }
}
