/*
 * Authors: Cole Sluggett, John Dickson, Zachariah Fahsi
 * Date: 4/20/18
 * Overview: Solves the change making problem using a dynamic
 *           programming algorithm.
 */

import java.util.ArrayList;

public class PA4 {
    public static ArrayList<Integer> getChange(int[] coins, int change) {
        if(coins.length == 0) {     //checks if the coin array is empty
            throw new IllegalArgumentException("Array of size 0 is not allowed");
        }
        int[] coinGraph = new int[change + 1];
        int[] numCoins = new int[change + 1];
        numCoins[0] = 0;
        coinGraph[0] = 1;
        for (int cents = 1; cents <= change; cents++) {     //goes through each amount up to total
            int total = cents;
            int newCoin = 1;
            for (int j = 0; j < coins.length; j++) {        //goes through each coin in list
                if (coins[j] > cents)
                    continue;               //continues if current coin is greater then cents
                if (numCoins[cents - coins[j]] + 1 < total) {
                    total = numCoins[cents - coins[j]] + 1;     //finds total for each number up to total
                    newCoin = coins[j];
                }
            }
            numCoins[cents] = total;        //sets the number of coins
            coinGraph[cents] = newCoin;      //sets up amount of coin graph for current change
        }
        ArrayList<Integer> used = new ArrayList<>();    //creates final array list
        for (int i = change; i > 0;) {
            used.add(coinGraph[i]); //adds coin used
            i -= coinGraph[i];      //subtracts to next coin
        }
        return used;        //returns coins used
    }
}
