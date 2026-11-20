package two_pointers;

public class StockSell {
       public int maxProfit(int[] prices) {
        int min_Price = prices[0];
        int maxProf = 0;

        for(int i=1;i<prices.length;i++){
            maxProf = Math.max(maxProf,prices[i]-min_Price);
            min_Price = Math.min(prices[i],min_Price);
        }

        return maxProf;
    }
    
    
}
