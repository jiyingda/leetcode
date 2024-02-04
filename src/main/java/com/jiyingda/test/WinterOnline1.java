/**
 * @(#)KnowledgePoint.java, 11月 28, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingdabj
 */
public class WinterOnline1 {


    public static void main(String[] args) {
        int id = 1;
        int totalNumberOfExercises = 3;

        for (int grade = 1; grade <= 6; grade++) {
            int day = 1;
            int k = 1;
            for (int i = 1; i < 22; i++) {
                String name = i <= 9 ? "0" + day : "" + day;
                int learningStage = i <= 14? 2 : 1;

                String s = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                        "('" + name +"'," +day +",1," +grade + ",1,"+learningStage+"," + totalNumberOfExercises + "," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                System.out.println(s);
                day++;
                id++;
                if (k == 7 || k == 14 || k == 21) {
                    String ss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('跨学科实践活动'," +day +",1," + grade + ",3,1,"+learningStage+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(ss);
                    id++;
                }
                if (k == 14) {
                    String ss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('复习巩固卷'," +day +",1," + grade + ",2,"+learningStage+","+totalNumberOfExercises+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(ss);
                    id++;
                }
                if (k == 21) {
                    String ss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('预习衔接卷'," +day +",1," + grade + ",2,"+learningStage+","+totalNumberOfExercises+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(ss);
                    id++;
                    String sssss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('反思自评'," +day +",1," + grade + ",4,1,"+learningStage+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(sssss);
                    id++;
                }
                k++;
            }
        }

        for (int grade = 7; grade <= 7; grade++) {
            int day = 1;
            int k = 1;
            for (int i = 1; i <= 14; i++) {
                String name = i <= 9 ? "0" + day : "" + day;
                int learningSeason = 1;

                String s = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                        "('" + name +"'," +day +","+learningSeason+"," +grade + ",1,1," + totalNumberOfExercises + "," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                System.out.println(s);
                day++;
                id++;
                if (k == 14) {
                    String ss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('预习衔接卷'," +day +"," + learningSeason + "," + grade + ",2,1,"+totalNumberOfExercises+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(ss);
                    id++;
                }
                k++;
            }
        }

        for (int grade = 8; grade <= 8; grade++) {
            totalNumberOfExercises = 4;
            int day = 1;
            int k = 1;
            for (int i = 1; i <= 14; i++) {
                String name = i <= 9 ? "0" + day : "" + day;
                int learningSeason = 1;

                String s = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                        "('" + name +"'," +day +","+learningSeason+"," +grade + ",1,1," + totalNumberOfExercises + "," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                System.out.println(s);
                day++;
                id++;
                if (k == 14) {
                    String ss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('预习衔接卷'," +day +"," + learningSeason + "," + grade + ",2,1,"+totalNumberOfExercises+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(ss);
                    id++;
                }
                k++;
            }
        }

        for (int grade = 9; grade <= 9; grade++) {
            totalNumberOfExercises = 5;
            int day = 1;
            int k = 1;
            for (int i = 1; i <= 14; i++) {
                String name = i <= 9 ? "0" + day : "" + day;
                int learningSeason = 2;

                String s = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                        "('" + name +"'," +day +","+learningSeason+"," +grade + ",1,1," + totalNumberOfExercises + "," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                System.out.println(s);
                day++;
                id++;
                if (k == 14) {
                    String ss = "INSERT INTO `winter_stage` (`name`, `day`, `learningSeason`, `grade`, `type`, `learningStage`, `totalNumberOfExercises`, `orderNum`, `boundContentInfo`, `dbctime`, `dbutime`) VALUES " +
                            "('复习巩固卷'," +day +"," + learningSeason + "," + grade + ",2,1,"+totalNumberOfExercises+"," + id + ",'{}','2023-12-27 11:29:59.156','2023-12-27 11:29:59.156');";
                    System.out.println(ss);
                    id++;
                }
                k++;
            }
        }
    }

}
