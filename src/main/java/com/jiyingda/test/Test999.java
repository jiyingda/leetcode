/**
 * @(#)Test999.java, 8月 11, 2025.
 * <p>
 * Copyright 2025 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import okhttp3.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jiyingdabj
 */
public class Test999 {


    private static final OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    // 创建请求体（GET请求可以使用空的请求体）
    private static final MediaType mediaType = MediaType.parse("text/plain");
    private static final RequestBody body = RequestBody.create(mediaType, "");

    public static void main(String[] args) {
        // 定义并发数量
        int concurrentCount = 1;

        // 创建线程池，控制并发数量
        ExecutorService executor = Executors.newFixedThreadPool(concurrentCount);

        // 提交多个请求任务到线程池
        for (int i = 0; i < concurrentCount; i++) {
            final int requestId = i;
            executor.submit(() -> {
                try {
                    // 执行请求
                    Response response = executeRequest();
                    // 处理响应
                    handleResponse(requestId, response);
                } catch (IOException e) {
                    System.err.println("请求 " + requestId + " 发生错误: " + e.getMessage());
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
        try {
            // 等待所有任务完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    // 执行单个请求
    private static Response executeRequest() throws IOException {
        Request request = new Request.Builder()
                .url("https://megrez.yuanfudao.biz/megrez-profile/android/timestamp?clientTraceId=e78axtm5vt0afu9oiud&_productId=2011&platform=android30&YFD_U=CSBASH16LUW00034&version=2.49.1&YFD_OS=1.3.1.7%28S3DD257E%29&YFD_SUPPLIER=S3&YFD_MODEL=S3&YFD_SUB_MODEL=S3N%28T2001%29&YFD_APP=com.fenbi.megrez.app.launcher&_lastAppVersion=2.49.1&rebootByAutoUpdate=0&deviceIsInteractive=1&YFD_GRADE=4&YFD_PHASE=2&YFD_SEMESTER=2")
                .method("GET", body)
                .addHeader("Host", "megrez.yuanfudao.biz")
                .addHeader("Cookie", "g_loc=vPeteFfrRL2jJ0VNIL3TWQ==; megrez_family_member_id=200658236; __sub_user_infos__=/24T7Ovgtuud9LSYuz4IEyZGjurDvBc+I9vYQO+9IgQ+fahwzKTuK6AFl+6xuOIuIU5q2JqkthtVKbgsfNX8ow==; megrez_family_sess=qKJ3rTQHL9ExYqiavEC311EhljBybC6NI8/koPnP7ApzGnzEo7ptLXEMSeEI4D/6; sess=qzYJ3yh9UaTgMiO5CKl6uByKnD0L1Wi5j9hZjiI/p/Q/vR3IZFS5o/iSOLT768VtY9M2C/SaE2nPwVPj2JUABGlacmNJ+sM4shrh3KxdQvM=; g_sess=qzYJ3yh9UaTgMiO5CKl6uByKnD0L1Wi5j9hZjiI/p/Q/vR3IZFS5o/iSOLT768VtY9M2C/SaE2nPwVPj2JUABBT/PVlO1O374CXKhksK+oiqdybK5ZKAp0keLBfTYb+uVEpBinV+lco0yPiNN5xST0H912kqYcImuDXXBCk20xg=; persistent=c4T1lwA1WSgP9uQw+WTYGkQDC1/iczn0A4SQh/EC25Nv2Fv/iAvNXr/Y8JZWIbIrxWjCjzPX6uSPuhidyAFyAA==; userid=200658236; megrez_family_persistent=jPDeHc/oKtQabVcqKOGvVodDQvM/2yHoXt+X31kS4DAFPfimwxh0B686E/sGQZzL; sid=998185402132183442; megrez_family_persistent=eJB7aBcVzm3EA7wSJbc/bbCGVEiu0RbnGeWqta6fF0W7TI0kW5IXY0bIRe82eLg8")
                .addHeader("default-namespace-sw8", "1-ZTc4YXh0bTV2dDBhZnU5b2l1ZA==-MA==-0-X19PX1JfVF9f-UF9J-UF9F-SV9Q")
                .addHeader("user-agent", "okhttp/4.11.0")
                .build();

        return client.newCall(request).execute();
    }

    // 处理响应结果
    private static void handleResponse(int requestId, Response response) throws IOException {
        try (ResponseBody responseBody = response.body()) {
            if (!response.isSuccessful()) {
                System.out.println("请求 " + requestId + " 失败: " + response.code());
                return;
            }

            String responseData = responseBody.string();
            System.out.println("请求 " + requestId + " 成功，响应内容: " + responseData);
        } finally {
            response.close(); // 确保响应被正确关闭
        }
    }
}