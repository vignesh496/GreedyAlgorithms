import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] coin = {1, 2, 5, 10};
        int[] count = {10, 5, 2, 1};
        coinChange(coin, count, 20);
    }
    public static void coinChange(int[] coin, int[] count, int amt)    {
        int tot = 0;
        for (int i = coin.length-1; i>=0; i--)  {
            int c = Math.min(count[i], amt / coin[i]);
            if (c > 0)  {
                System.out.println("Rs." + coin[i] + " - " + count[i]);
                amt -= (c * coin[i]);
                tot += c;
            }
        }
        if (amt != 0)   {
            System.out.println("Cannot make coins");
            return;
        }
        System.out.println("Total coins : " + tot);
    }
}
