import java.util.*;

public class CoinChange {

    public static void coinChange(int[] coins, int[] counts, int amount) {
        int tot = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int count = Math.min(counts[i], amount / coins[i]);
            if (count > 0) {
                System.out.println("Rs." + coins[i] + "\t: "+ count + " coins");
                amount -= (count * coins[i]);
                tot += count;
            }
        }
        
        if (amount != 0) {
            System.out.println("Cannot make coins");
            return;
        }
        System.out.println("Total coins : " + tot); 
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int[] counts = {5, 3, 2, 1};   // Assuming limited number of coins
        int amount = 56;
        System.out.println("Coins used:");
        coinChange(coins, counts, amount);
    }
}
