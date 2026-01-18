/**
 * @(#)Lanfus.java, 1月 06, 2026.
 * <p>
 * Copyright 2026 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.fenbi.common.util.JsonUtils;
import com.yuanfudao.tutor.efficientai.core.langfuse.LangFuse;
import com.yuanfudao.tutor.efficientai.core.langfuse.model.Prompt;
import com.yuanfudao.tutor.efficientai.langfuse.client.api.PromptsApi;
import com.yuanfudao.tutor.efficientai.langfuse.client.invoker.ApiException;
import com.yuanfudao.tutor.efficientai.langfuse.client.model.ChatMessage;
import com.yuanfudao.tutor.efficientai.langfuse.client.model.PromptOneOf;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiyingdabj
 */
public class Lanfus {


    public static void main(String[] args) throws ApiException {
        PromptsApi helper = new PromptsApi();
        helper.setCustomBaseUrl("https://langfuse.zhenguanyu.com");
        helper.getApiClient().setBasePath("https://langfuse.zhenguanyu.com");
        helper.getApiClient().setUsername("pk-lf-5f669757-1d45-4823-a002-cf3e239810a8");
        helper.getApiClient().setPassword("sk-lf-ab5598b8-7dcd-487d-b3c5-106cd874820c");
        com.yuanfudao.tutor.efficientai.langfuse.client.model.Prompt prompt = helper.promptsGet("recommendQuickReplyPromptIntent", null, "production");
        Prompt promptEntity = new Prompt();
        if (prompt.getSchemaType().equals("oneOf")) {
            PromptOneOf chatPrompt = prompt.getPromptOneOf();

            promptEntity.setName(chatPrompt.getName());
            List<ChatMessage> chatMessages = chatPrompt.getPrompt();
            List<Prompt.ChatMessage> messages = (List)chatMessages.stream().map((chatMessage) -> {
                Prompt.ChatMessage message = new Prompt.ChatMessage();
                message.setRole(chatMessage.getRole());
                message.setContent(chatMessage.getContent());
                return message;
            }).collect(Collectors.toList());
            promptEntity.setMessages(messages);

        } else {
            throw new IllegalArgumentException("Unknown schema type: " + prompt.getSchemaType());
        }
        System.out.println(JsonUtils.writeValue(promptEntity));
    }


}