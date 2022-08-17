/**
 * @(#)Leet278.java, 7月 05, 2022.
 * <p>
 * 
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.leetcode500;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 *  
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= bad <= n <= 231 - 1
 * 通过次数353,282提交次数777,090
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jiyingdabj
 */
public class Leet278 {


    public int firstBadVersion(int n) {
        return binarySearch(0, n);
    }

    public int binarySearch(int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if (isBadVersion(mid)) {
            int t = binarySearch(left, mid - 1);
            if (t < 0) {
                return mid;
            } else {
                return t;
            }
        } else {
            return binarySearch(mid + 1, right);
        }
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
