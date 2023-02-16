/**
 * @(#)Test666.java, 4月 14, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingda
 */
public class Test666 {

    public static void main(String[] args) {
        String sss = "7月17日-7月23日（备注：北京系统班1期）\n" +
                "7月27日-8月2日（备注：北京系统班2期）\n" +
                "8月6日-8月12日（备注：北京系统班3期）\n" +
                "8月16日-8月22日（备注：北京系统班4期）\n" +
                "7月15日-7月25日（备注：北京小数1-2年级培优1期）\n" +
                "7月27日-8月6日（备注：北京小数1-2年级培优2期）\n" +
                "7月15日-7月24日（备注：北京小数3-6年级培优1期）\n" +
                "7月27日-8月5日（备注：北京小数3-6年级培优2期）\n" +
                "7月14日-7月24日（备注：深圳小语小数荣耀1期）\n" +
                "7月25日-8月4日（备注：深圳小语小数荣耀2期）\n" +
                "8月5日-8月15日（备注：深圳小语小数荣耀3期）\n" +
                "8月16日-8月26日（备注：深圳小语小数荣耀4期）\n" +
                "7月14日-7月30日（备注：深圳小数荣耀15次课1期）\n" +
                "7月14日-7月24日（备注：深圳小数培优1期）\n" +
                "8月3日-8月13日（备注：深圳小数培优2期）\n" +
                "8月16日-8月26日（备注：深圳小数培优3期）";
        String[] sssss = sss.split("\n");
        String a = "";
        String b = "";
        for (String kk : sssss) {
            String[] aaa = kk.split("（备注：");
            System.out.println(aaa[0]);
            a = a + aaa[0] + ",";
            b = b + aaa[1].split("）")[0] + ",";
        }
        System.out.println(a);
        System.out.println(b);
        String s = "--jobs.active=TagsJob --semesterId=126 --phase=3 --ordinalBase=3023 --names=7月17日-7月23日,7月27日-8月2日,8月6日-8月12日,8月16日-8月22日,7月15日-7月25日,7月27日-8月6日,7月15日-7月24日,7月27日-8月5日,7月14日-7月24日,7月25日-8月4日,8月5日-8月15日,8月16日-8月26日,7月14日-7月30日,7月14日-7月24日,8月3日-8月13日,8月16日-8月26日 --remarks=北京系统班1期,北京系统班2期,北京系统班3期,北京系统班4期,北京小数1-2年级培优1期,北京小数1-2年级培优2期,北京小数3-6年级培优1期,北京小数3-6年级培优2期,深圳小语小数荣耀1期,深圳小语小数荣耀2期,深圳小语小数荣耀3期,深圳小语小数荣耀4期,深圳小数荣耀15次课1期,深圳小数培优1期,深圳小数培优2期,深圳小数培优3期 --dryRun=true";
        System.out.println(s);
        String sssssss= "java -DFENBI_CONFIG_URI=https://rz-test-fdc.zhenguanyu.com:443 -DrpcServer.registryUri=http://soho-test.na.zhenguanyu.com -DrpcServer.namingServiceUrl=http://soho-test-na.zhenguanyu.com -DrpcServer.serviceName=tutor-atm-lesson -jar tutor-atm-lesson-job.jar --fdc.projectIdentity=tutor-atm-lesson --spring.profiles.active=test,rz-test --rpcServer.zkNode=false --actcuator.enabled=false --jobs.active=TagsJob --semesterId=126 --phase=3 --ordinalBase=3023 --names=7月17日-7月23日,7月27日-8月2日,8月6日-8月12日,8月16日-8月22日,7月15日-7月25日,7月27日-8月6日,7月15日-7月24日,7月27日-8月5日,7月14日-7月24日,7月25日-8月4日,8月5日-8月15日,8月16日-8月26日,7月14日-7月30日,7月14日-7月24日,8月3日-8月13日,8月16日-8月26日 --remarks=北京系统班1期,北京系统班2期,北京系统班3期,北京系统班4期,北京小数1-2年级培优1期,北京小数1-2年级培优2期,北京小数3-6年级培优1期,北京小数3-6年级培优2期,深圳小语小数荣耀1期,深圳小语小数荣耀2期,深圳小语小数荣耀3期,深圳小语小数荣耀4期,深圳小数荣耀15次课1期,深圳小数培优1期,深圳小数培优2期,深圳小数培优3期 --dryRun=true";

        String jjjjjj="java -DFENBI_CONFIG_URI=https://dx-online-fdc.zhenguanyu.com:443 -DrpcServer.registryUri=http://dx-online.na.zhenguanyu.com -DrpcServer.namingServiceUrl=http://dx-online-na.zhenguanyu.com -DrpcServer.serviceName=tutor-atm-lesson -jar tutor-atm-lesson-job.jar --fdc.projectIdentity=tutor-atm-lesson --spring.profiles.active=online,dx-online --rpcServer.zkNode=false --actcuator.enabled=false --jobs.active=TagsJob --semesterId=126 --phase=3 --ordinalBase=3023 --names=7月17日-7月23日,7月27日-8月2日,8月6日-8月12日,8月16日-8月22日,7月15日-7月25日,7月27日-8月6日,7月15日-7月24日,7月27日-8月5日,7月14日-7月24日,7月25日-8月4日,8月5日-8月15日,8月16日-8月26日,7月14日-7月30日,7月14日-7月24日,8月3日-8月13日,8月16日-8月26日 --remarks=北京系统班1期,北京系统班2期,北京系统班3期,北京系统班4期,北京小数1-2年级培优1期,北京小数1-2年级培优2期,北京小数3-6年级培优1期,北京小数3-6年级培优2期,深圳小语小数荣耀1期,深圳小语小数荣耀2期,深圳小语小数荣耀3期,深圳小语小数荣耀4期,深圳小数荣耀15次课1期,深圳小数培优1期,深圳小数培优2期,深圳小数培优3期 --dryRun=true";
    }
}