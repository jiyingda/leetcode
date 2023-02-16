/**
 * @(#)Test55555.java, 3月 27, 2021.
 * <p>
 * Copyright 2021 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jiyingda
 */
public class Test55555 {

    public static void main(String[] args) {
        String ss = "4639389\n" +
                "4639391\n" +
                "4639393\n" +
                "4639395\n" +
                "4639397\n" +
                "4639399\n" +
                "4639401\n" +
                "4639403\n" +
                "4639405\n" +
                "4639407\n" +
                "4639411\n" +
                "4639415\n" +
                "4639417\n" +
                "4639419\n" +
                "4639421\n" +
                "4639423\n" +
                "4639425\n" +
                "4827885\n" +
                "4827887\n" +
                "5162237\n" +
                "5162239\n" +
                "5268795\n" +
                "4643513\n" +
                "4643515\n" +
                "4643517\n" +
                "4643519\n" +
                "4643521\n" +
                "4643523\n" +
                "4828863\n" +
                "4828865\n" +
                "5162243\n" +
                "5162245\n" +
                "5162247\n" +
                "5162249\n" +
                "5162251\n" +
                "5162253\n" +
                "5164177\n" +
                "5164181\n" +
                "5164185\n" +
                "5164347\n" +
                "5164349\n" +
                "5164351\n" +
                "5164365\n" +
                "5164367\n" +
                "5164369\n" +
                "5166335\n" +
                "5166349\n" +
                "5166351\n" +
                "5166355\n" +
                "5166363\n" +
                "5166367\n" +
                "5166381\n" +
                "5166391\n" +
                "5166395\n" +
                "5239009\n" +
                "5239013\n" +
                "5239017\n" +
                "5239021\n" +
                "5295375\n" +
                "4643837\n" +
                "4643839\n" +
                "4643841\n" +
                "4826223\n" +
                "4828885\n" +
                "4828887\n" +
                "5162291\n" +
                "5162293\n" +
                "5162297\n" +
                "5162311\n" +
                "5162313\n" +
                "5162315\n" +
                "5164389\n" +
                "5164411\n" +
                "5164415\n" +
                "5164417\n" +
                "5164421\n" +
                "5166419\n" +
                "5166423\n" +
                "5166425\n" +
                "5166707\n" +
                "5239025\n" +
                "5239027\n" +
                "5239029\n" +
                "4643989\n" +
                "4643991\n" +
                "4643993\n" +
                "4828891\n" +
                "5164449\n" +
                "5166721\n" +
                "5166723\n" +
                "5239071\n" +
                "4644099\n" +
                "4644101\n" +
                "4644105\n" +
                "4644107\n" +
                "4644109\n" +
                "4644111\n" +
                "4644113\n" +
                "4644115\n" +
                "4644117\n" +
                "4644119\n" +
                "4828893\n" +
                "4863845\n" +
                "4863847\n" +
                "5162325\n" +
                "5162327\n" +
                "5162329\n" +
                "5162331\n" +
                "5164467\n" +
                "5164471\n" +
                "5164477\n" +
                "5164487\n" +
                "5164489\n" +
                "5164491\n" +
                "5164925\n" +
                "5164927\n" +
                "5166545\n" +
                "5166547\n" +
                "5166549\n" +
                "5166553\n" +
                "5239085\n" +
                "5295439\n" +
                "4644279\n" +
                "4644281\n" +
                "5162559\n" +
                "5162561\n" +
                "5166609\n" +
                "5166611\n" +
                "5166613\n" +
                "5166727\n" +
                "4644329\n" +
                "4644331\n" +
                "4644333\n" +
                "4644335\n" +
                "4644337\n" +
                "4828895\n" +
                "4828897\n" +
                "4828899\n" +
                "5162571\n" +
                "5162573\n" +
                "5162575\n" +
                "5162577\n" +
                "5162579\n" +
                "5162581\n" +
                "5164523\n" +
                "5164555\n" +
                "5164557\n" +
                "5164809\n" +
                "5164899\n" +
                "5239147\n" +
                "5239169\n" +
                "4644467\n" +
                "4644469\n" +
                "4644471\n" +
                "4644473\n" +
                "5162599\n" +
                "5164787\n" +
                "5239183\n" +
                "4644741\n" +
                "4644743\n" +
                "4644745\n" +
                "4828915\n" +
                "5162603\n" +
                "5162605\n" +
                "5164561\n" +
                "5164565\n" +
                "5164567\n" +
                "5164569\n" +
                "5164579\n" +
                "5164583\n" +
                "5164589\n" +
                "5273763\n" +
                "4645085\n" +
                "4645087\n" +
                "4645089\n" +
                "4645091\n" +
                "4645093\n" +
                "5162617\n" +
                "5164683\n" +
                "5166743\n" +
                "4646783\n" +
                "4646785\n" +
                "4646907\n" +
                "4828917\n" +
                "4828919\n" +
                "5162635\n" +
                "5162637\n" +
                "5162639\n" +
                "5164321\n" +
                "5164323\n" +
                "5164325\n" +
                "5164631\n" +
                "5164633\n" +
                "5164635\n" +
                "5164639\n" +
                "5164733\n" +
                "5164735\n" +
                "5164737\n" +
                "5164751\n" +
                "5164753\n" +
                "5164759\n" +
                "5166899\n" +
                "5239235\n" +
                "5239239";
        String[] sss = ss.split("\n");
        System.out.println("lesson = \n");
        for (String s : sss) {
            System.out.print(s + ",");
        }
        System.out.println("\n");

        String kk = "{\"header\":[[\"lessonTemplateId\"]],\"data\":[{\"lessonTemplateId\":12477},{\"lessonTemplateId\":12477},{\"lessonTemplateId\":12477},{\"lessonTemplateId\":12477},{\"lessonTemplateId\":12477},{\"lessonTemplateId\":12477},{\"lessonTemplateId\":12479},{\"lessonTemplateId\":12479},{\"lessonTemplateId\":12479},{\"lessonTemplateId\":12479},{\"lessonTemplateId\":12479},{\"lessonTemplateId\":12481},{\"lessonTemplateId\":12481},{\"lessonTemplateId\":12481},{\"lessonTemplateId\":12483},{\"lessonTemplateId\":12483},{\"lessonTemplateId\":12485},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12583},{\"lessonTemplateId\":12583},{\"lessonTemplateId\":12583},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12585},{\"lessonTemplateId\":12585},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12587},{\"lessonTemplateId\":12587},{\"lessonTemplateId\":12587},{\"lessonTemplateId\":12587},{\"lessonTemplateId\":12595},{\"lessonTemplateId\":12595},{\"lessonTemplateId\":12595},{\"lessonTemplateId\":12589},{\"lessonTemplateId\":12589},{\"lessonTemplateId\":12589},{\"lessonTemplateId\":12589},{\"lessonTemplateId\":12589},{\"lessonTemplateId\":12597},{\"lessonTemplateId\":12597},{\"lessonTemplateId\":12597},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12599},{\"lessonTemplateId\":12599},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12583},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12595},{\"lessonTemplateId\":12597},{\"lessonTemplateId\":12597},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12599},{\"lessonTemplateId\":12599},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12577},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12581},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12591},{\"lessonTemplateId\":12585},{\"lessonTemplateId\":12585},{\"lessonTemplateId\":12593},{\"lessonTemplateId\":12593}]}";
        JSONObject obj = JSONObject.parseObject(kk);
        JSONArray array = obj.getJSONArray("data");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array.size(); i++) {
            set.add(array.getJSONObject(i).getString("lessonTemplateId"));
            i++;
        }
        for (String s : set) {
            System.out.print( s+ ",");;
        }

        String lessonId = "{\"header\":[[\"id\"]],\"data\":[{\"id\":4639389},{\"id\":4639391},{\"id\":4639393},{\"id\":4639395},{\"id\":4639397},{\"id\":4639399},{\"id\":4639401},{\"id\":4639403},{\"id\":4639405},{\"id\":4639407},{\"id\":4639409},{\"id\":4639411},{\"id\":4639415},{\"id\":4639417},{\"id\":4639419},{\"id\":4639421},{\"id\":4639423},{\"id\":4639425},{\"id\":4643513},{\"id\":4643515},{\"id\":4643517},{\"id\":4643519},{\"id\":4643521},{\"id\":4643523},{\"id\":4828863},{\"id\":4828865},{\"id\":5162243},{\"id\":5162245},{\"id\":5162247},{\"id\":5162249},{\"id\":5162251},{\"id\":5162253},{\"id\":5163953},{\"id\":5164171},{\"id\":5164177},{\"id\":5164179},{\"id\":5164181},{\"id\":5164183},{\"id\":5164185},{\"id\":5164187},{\"id\":5164343},{\"id\":5164347},{\"id\":5164349},{\"id\":5164351},{\"id\":5164365},{\"id\":5164367},{\"id\":5164369},{\"id\":5166331},{\"id\":5166333},{\"id\":5166335},{\"id\":5166337},{\"id\":5166349},{\"id\":5166351},{\"id\":5166355},{\"id\":5166359},{\"id\":5166363},{\"id\":5166365},{\"id\":5166367},{\"id\":5166381},{\"id\":5166383},{\"id\":5166385},{\"id\":5166387},{\"id\":5166391},{\"id\":5166393},{\"id\":5166395},{\"id\":5166403},{\"id\":5166405},{\"id\":5166409},{\"id\":5166677},{\"id\":5239007},{\"id\":5239009},{\"id\":5239011},{\"id\":5239013},{\"id\":5239017},{\"id\":5239019},{\"id\":5239021},{\"id\":5295375},{\"id\":5379191},{\"id\":4643837},{\"id\":4643839},{\"id\":4643841},{\"id\":4826223},{\"id\":4828885},{\"id\":4828887},{\"id\":5162289},{\"id\":5162291},{\"id\":5162293},{\"id\":5162295},{\"id\":5162297},{\"id\":5162311},{\"id\":5162313},{\"id\":5162315},{\"id\":5162317},{\"id\":5162319},{\"id\":5164373},{\"id\":5164375},{\"id\":5164377},{\"id\":5164379},{\"id\":5164389},{\"id\":5164393}]}";

        JSONObject objll = JSONObject.parseObject(lessonId);
        JSONArray arrayss = objll.getJSONArray("data");
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < arrayss.size(); i++) {
            set2.add(arrayss.getJSONObject(i).getString("id"));
            i++;
        }
        System.out.print("--=====---\n");
        for (String s : set2) {
            System.out.print(s + ",");
        }
        System.out.print("--=====---\n");
        List<String> aaa = new ArrayList<>();
        for (String s : sss) {
            set2.remove(s);
        }
        System.out.print("-----\n");
        for (String s : set2) {
            System.out.print(s + ",");
        }



    }
}