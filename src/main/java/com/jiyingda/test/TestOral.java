/**
 * @(#)TestOral.java, 8月 02, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONObject;
import com.jiyingda.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class TestOral {

    public static void main(String[] args) {
        List<String> qz = FileReader.readFromVs("口语练习");
        int i = 1;
        for (String s : qz) {
            String[] ss = s.split("\t");
            int dialogueId = 1;
            if ("Level 1".equals(ss[0])) {
                if ("社会文化".equals(ss[1])) {
                    if ("对话一".equals(ss[2])) {
                        dialogueId = 83;
                    } else if ("对话二".equals(ss[2])) {
                        dialogueId = 84;
                    } else if ("对话三".equals(ss[2])) {
                        dialogueId = 85;
                    }
                }

            } else if ("Level 2".equals(ss[0])) {
                if ("社会文化".equals(ss[1])) {
                    if ("对话一".equals(ss[2])) {
                        dialogueId = 87;
                    } else if ("对话二".equals(ss[2])) {
                        dialogueId = 88;
                    } else if ("对话三".equals(ss[2])) {
                        dialogueId = 89;
                    }
                }
            } else if ("Level 3".equals(ss[0])) {
                if ("情感表达".equals(ss[1])) {
                    if ("对话一".equals(ss[2])) {
                        dialogueId = 95;
                    } else if ("对话二".equals(ss[2])) {
                        dialogueId = 96;
                    } else if ("对话三".equals(ss[2])) {
                        dialogueId = 93;
                    }
                } else if ("规则意识".equals(ss[1])) {
                    if ("对话一".equals(ss[2])) {
                        dialogueId = 98;
                    } else if ("对话二".equals(ss[2])) {
                        dialogueId = 99;
                    } else if ("对话三".equals(ss[2])) {
                        dialogueId = 93;
                    }
                }
            }
            int sentenceType = 1;
            if ("系统".equals(ss[4])) {
                sentenceType = 1;
            } else {
                sentenceType = 2;
            }
            String content = ss[5].replace("'", "\\'");
            int role = 1;
            if ("Emma".equals(ss[3])) {
                role = 1;
            } else if ("James".equals(ss[3])) {
                role = 2;
            } else if ("Henry".equals(ss[3])) {
                role = 3;
            } else if ("Sophia".equals(ss[3]) || "Sopia".equals(ss[3])) {
                role = 4;
            } else if ("Michelle".equals(ss[3])) {
                role = 5;
            } else if ("Clerk".equals(ss[3])) {
                role = 6;
            } else if ("Waitress".equals(ss[3]) || "waitress".equals(ss[3])) {
                role = 7;
            } else if ("farmer".equals(ss[3])) {
                role = 8;
            } else if ("Cashier".equals(ss[3])) {
                role = 9;
            } else if ("Seller".equals(ss[3])) {
                role = 10;
            } else if ("dentist".equals(ss[3])) {
                role = 11;
            } else if ("Policeman".equals(ss[3])) {
                role = 12;
            } else if ("Sue".equals(ss[3])) {
                role = 13;
            } else  {
                throw new RuntimeException("role error" + ss[3]);
            }
            String sql = "INSERT INTO `oral_practice_sentence` (dialogueId, sentenceType, role, content, description, contentAudioUrl, ordinal, `status`) VALUES (" +
                    dialogueId + ", " +sentenceType+", " +role+", '" + content + "', '" + ss[6] + "', '"+ ss[7]+"', " + i +", 1);";
            System.out.println(sql);
            /*String sql = "UPDATE `oral_practice_sentence` SET sentenceType = " +sentenceType + ", role = " + role + ", content = '" + content + "', description = '" + ss[6] + "', contentAudioUrl = '" + ss[7] + "' WHERE id = " + ss[8] + ";";
            System.out.println(sql);*/
            i++;
        }

    }



}
