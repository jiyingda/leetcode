package com.jiyingda.leetcode150;

/**
 * @author jiyingda.
 * @date 2020/7/13.
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Leet121 {


    public static void main(String[] args){

        int[] prices = {1,2};
        System.out.print(maxProfit(prices));;
    }



    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
        int[] ss = new int[len];
        int[] sss = new int[len];
        ss[0] = 0;
        sss[0] = 0;
        ss[1] = prices[1] - prices[0];
        sss[1] = ss[1];

        int max = Math.max(sss[1], 0);
        for(int i = 2; i < len; i++){
            ss[i] = prices[i] - prices[i-1];
            sss[i] = Math.max(ss[i], ss[i] + sss[i-1]);
            max = Math.max(max, sss[i]);
        }


        return Math.max(max, 0);
    }

    /**
     * 思路：题目只问最大利润，没有问这几天具体哪一天买、哪一天卖，因此可以考虑使用 动态规划 的方法来解决。
     *
     * 买卖股票有约束，根据题目意思，有以下两个约束条件：
     *
     * 条件 1：你不能在买入股票前卖出股票；
     * 条件 2：最多只允许完成一笔交易。
     * 因此 当天是否持股 是一个很重要的因素，而当前是否持股和昨天是否持股有关系，为此我们需要把 是否持股 设计到状态数组中。
     *
     * 状态定义：
     *
     * dp[i][j]：下标为 i 这一天结束的时候，手上持股状态为 j 时，我们持有的现金数。换种说法：dp[i][j] 表示天数 [0, i] 区间里，下标 i 这一天状态为 j 的时候能够获得的最大利润。其中：
     *
     * j = 0，表示当前不持股；
     * j = 1，表示当前持股。
     * 注意：下标为 i 的这一天的计算结果包含了区间 [0, i] 所有的信息，因此最后输出 dp[len - 1][0]。
     *
     * 说明：
     *
     * 使用「现金数」这个说法主要是为了体现 买入股票手上的现金数减少，卖出股票手上的现金数增加 这个事实；
     * 「现金数」等价于题目中说的「利润」，即先买入这只股票，后买入这只股票的差价；
     * 因此在刚开始的时候，我们的手上肯定是有一定现金数能够买入这只股票，即刚开始的时候现金数肯定不为 00，但是写代码的时候可以设置为 0。极端情况下（股价数组为 [5, 4, 3, 2, 1]），此时不发生交易是最好的（这一点是补充说明，限于我的表达，希望不要给大家造成迷惑）。
     * 推导状态转移方程：
     *
     * dp[i][0]：规定了今天不持股，有以下两种情况：
     *
     * 昨天不持股，今天什么都不做；
     * 昨天持股，今天卖出股票（现金数增加），
     * dp[i][1]：规定了今天持股，有以下两种情况：
     *
     * 昨天持股，今天什么都不做（现金数与昨天一样）；
     * 昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
     * 状态转移方程请见 参考代码 2。
     *
     * 知识点：
     *
     * 多阶段决策问题：动态规划常常用于求解多阶段决策问题；
     * 无后效性：每一天是否持股设计成状态变量的一维。状态设置具体，推导状态转移方程方便。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int[][] dp = new int [len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            // 这里dp[i - 1][1] + prices[i]为什么能保证只卖了一次，因为下面一行代码买的时候已经保证了只买一次，所以这里自然就保证了只卖一次，不管是只允许交易一次还是允许交易多次，这行代码都不用变，因为只要保证只买一次（保证了只卖一次）或者买多次（保证了可以卖多次）即可。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //  - prices[i]这里可以理解为dp[0][0] - prices[i]，这里为什么是dp[0][0] - prices[i]，因为只有这样才能保证只买一次，所以需要用一开始初始化的未持股的现金dp[0][0]减去当天的股价
            dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
            // 如果题目允许交易多次，就说明可以从直接从昨天的未持股状态变为今天的持股状态，因为昨天未持股状态可以代表之前买过又卖过后的状态，也就是之前交易过多次后的状态。也就是下面的代码。
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
