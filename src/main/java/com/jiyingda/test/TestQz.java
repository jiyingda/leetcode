/**
 * @(#)TestQz.java, 7月 27, 2023.
 * <p>
 * Copyright 2023 . All rights reserved.
 * FENBI.COM . Use is subject to license terms.
 */
package com.jiyingda.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jiyingda.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiyingdabj
 */
public class TestQz {

    public static void main(String[] args) {
        String ssssss = "[{\"role\":\"system\",\"content\":\"你是一个小学语文老师，请根据提供给你的1-2年级的作文评判标准（满分100分），之后需要你以小学老师的视角给我提供的文章进行评分、评级（我会提供年级、文章标题、正文）。仅输出评分、评级结果。输出的结果按json的格式输出，key为综合评分、评级\\n\\n评分标准：\\n1.内容创意（30分）：作文的主题是否新颖独特，具有一定的深度和见解。故事情节是否吸引人，有趣且具有启发性。\\n优秀：25-30分\\n良好：20-24分\\n中等：15-19分\\n较差：0-14分\\n\\n2.语言表达（30分）：句子是否通顺流畅，用词是否恰当准确。作文中是否有生动的描绘和优美的修辞，能够引发读者共鸣。\\n优秀：25-30分\\n良好：20-24分\\n中等：15-19分\\n较差：0-14分\\n\\n3.文章结构（20分）：作文是否有明确的开头、发展和结尾，结构是否合理，层次分明。\\n优秀：17-20分\\n良好：13-16分\\n中等：9-12分\\n较差：0-8分\\n\\n4.文章立意（10分）：作文立意是否积极健康。（注：没有不健康内容时不予扣分，不用对此做点评）\\n优秀：9-10分\\n良好：7-8分\\n中等：5-6分\\n较差：0-4分\\n\\n笔迹书写（10分）\"},{\"role\":\"user\",\"content\":\"二年级作文《可爱的小白兔》\\n\\n我喜欢的小动物是小白兔。它全身雪白的毛，远远看上去像一堆白云。小白兔的耳朵又大又尖，像两片大树叶。小白兔的眼睛红红的像两对大宝石。小白兔的嘴是三瓣嘴，吃胡萝卜的时候嘴巴和胡须一动一动的，像在跳舞。小白兔的尾巴是圆圆的，白白的，像个小绒球。我觉得小白兔最有趣的地方是走路的时候，它走路的时候是一蹦一跳的，可爱极了。小白兔真可爱我也想养一只。\"},{\"content\":\"{\\n    \\\"综合评分\\\": \\\"85\\\",\\n    \\\"评级\\\": \\\"良好\\\"\\n}\",\"usage\":{\"prompt_tokens\":759,\"completion_tokens\":23,\"total_tokens\":782},\"role\":\"assistant\"},{\"role\":\"user\",\"content\":\"一年级作文《我的发现》\\n\\n星期六，我去香草世界植树。大家排着整齐的队伍，愉快地走在植树的路上。走着走着，我发现了薰衣草工坊，我好奇地走到窗户旁往里看，薰衣草还可以做出饼干？\\n我看到的薰衣草饼是圆圆的，像一个曲奇饼，和薰衣草的紫色是一模一样。我想薰衣草饼一定用了不少的薰衣草吧，一定像外面的薰衣草那么香吧。\\n我的口水快流出来了！\"},{\"content\":\"{\\n    \\\"综合评分\\\": \\\"62\\\",\\n    \\\"评级\\\": \\\"中等\\\"\\n}\",\"usage\":{\"prompt_tokens\":1024,\"completion_tokens\":22,\"total_tokens\":1046},\"role\":\"assistant\"}]\n";
        List<String> qz = FileReader.readFromVs("权重");
        Map<Integer, Integer> qzMap = new HashMap<>();
        for (String q : qz) {
            String[] qq = q.split("\t");
            if (qq.length == 2) {
                qzMap.put(Integer.parseInt(qq[1]), Integer.parseInt(qq[0]));
            }
        }
        String st = "{\"10\":1001, \"11\":1002, \"12\":1003, \"16\":1006, \"17\":1025, \"13\":1004, \"14\":1110, \"15\":1042, \"18\":1005, \"19\":1028, \"20\":1033}";
        Map<String, Integer> map = JSONObject.parseObject(st, Map.class);
        Map<Integer, Integer> map2 = new HashMap<>();
        map.forEach((k, v) ->  {
            map2.put(v, Integer.parseInt(k));
        });
        qzMap.forEach((k, v) -> {
            if (map2.containsKey(k)) {
                System.out.println("update bookversion_config set weight = " +v+ " where bookVersion = " + map2.get(k) + ";");
            } else {
                System.out.println("update bookversion_config set weight = " +v+ " where bookVersion = " + k + ";");
            }
        });
    }
}
