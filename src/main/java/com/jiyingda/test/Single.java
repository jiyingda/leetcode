/**
 * @(#)Single.java, 6月 28, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

/**
 * @author jiyingdabj
 */
public class Single {


    private static class Inner {
        private static final Single single = new Single();
    }

    public static Single getInstance() {
        return Inner.single;
    }
}
