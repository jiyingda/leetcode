/**
 * @(#)UserResource.java, 12月 26, 2022.
 * <p>
 * Copyright 2022 . All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test.cloud;

import java.util.List;

/**
 * @author jiyingdabj
 */
public class UserResource {

    long id;

    long userId;

    long resourceId;

    long parentId;

    /**
     * 代表文件或者文件夹的路径
     * myFile/xxx/xxx/name.jpg
     */
    String path;

    String name;

    /**
     * 文件 或者 文件夹
     */
    int type;

    /**
     * 来源 个人 或者 共享
     */
    int origin;

    /**
     * 状态 0 正常 1 回收站中 2 删除
     */
    int status;

    List<Integer> tags;
}
