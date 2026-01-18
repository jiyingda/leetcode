/**
 * @(#)RecommendDynamicData.java, 1月 14, 2026.
 * <p>
 * Copyright 2026 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.fenbi.common.util.JsonUtils;
import lombok.Data;

/**
 * @author jiyingdabj
 */
@Data
public class RecommendDynamicData {

    private int bizRecommendQuickReplyTestLessonId;

    private long mockMessageId;

    private long mockStatusId;

    private int newRecommendTtlSeconds;

    private int promptCacheTtlSeconds;

    private int incrMaxCount;

    private boolean testBindPhone;

    private int maxMessage;

    public static RecommendDynamicData defaultConfig() {
        RecommendDynamicData data = new RecommendDynamicData();
        data.setBizRecommendQuickReplyTestLessonId(10572047);
        data.setMockMessageId(108L);
        data.setMockStatusId(109L);
        data.setNewRecommendTtlSeconds(30);
        data.setPromptCacheTtlSeconds(60);
        data.setIncrMaxCount(10);
        data.setTestBindPhone(false);
        data.setMaxMessage(100);
        return data;
    }

    public static void main(String[] args) {
        System.out.println(JsonUtils.writeValue(defaultConfig()));

    }
}