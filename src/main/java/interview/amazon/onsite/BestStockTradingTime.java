package interview.amazon.onsite;

public class BestStockTradingTime {
    public int[] bestTime(int[] stock, int[] time) {
        int N = stock.length;
        int max = 0, minIdx = 0;
        int[] res = new int[2];
        for (int i = 1; i < N; i++) {
            if (stock[i] < stock[minIdx]) minIdx = i;
            else if (stock[i] - stock[minIdx] > max) {
                max = stock[i] - stock[minIdx];
                res = new int[]{time[minIdx], time[i]};
            }
        }
        return res;
    }

    public static void main(String... args) {
        int[] prices = new int[]{5, 2, 9, 6, 11, 1, 10, 3, 4};
        int[] times = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 15};
        BestStockTradingTime bestStockTradingTime = new BestStockTradingTime();
        int[] time = bestStockTradingTime.bestTime(prices, times);
        System.out.println(time[0] + " " + time[1]);
    }
}
