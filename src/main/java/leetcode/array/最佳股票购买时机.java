package leetcode.array;

public class 最佳股票购买时机 {
    public static void main(String[] args) {

        int[] prices=new int[]{12,9,8,7,6};
        System.out.println(maxProfit(prices));
    }

    /**
     * 股票最佳购买时机(一次遍历)【推荐】
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice >= maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
