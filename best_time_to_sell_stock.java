import java.sql.Time;
import java.util.*;
public class best_time_to_sell_stock {
    // Complexity Analysisime complexity: O(n^2)
    class brute_force{
        public int maxProfit(int[] prices) {
            int n=prices.length;
           int profit=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(prices[i]<prices[j]){
                        profit=Math.max(profit,prices[j]-prices[i]);
                    }
                }
            }
            return profit;
        }
    }
//Time complexity: O(n)
    class optimal_Solution{
        public int maxProfit(int[] prices) {
            int n=prices.length;
            int minprice=Integer.MAX_VALUE;
            int maxpro=0;
            for(int i=0;i<n;i++){
                minprice=Math.min(minprice,prices[i]);
                maxpro=Math.max(maxpro,prices[i]-minprice);
            }
            return maxpro;
        }
    }
}
