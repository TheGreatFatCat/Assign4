import java.*;
import java.util.ArrayList;

public class Coins
{
    // Dynamic programming algorithm to solve change making problem.
    // As a result, the coinsUsed array is filled with the
    // minimum number of coins needed for change from 0 -> maxChange
    // and lastCoin contains one of the coins needed to make the change.
    public static ArrayList<Integer> makeChange( int [ ] coins, int maxChange )
    {
        int temp;

        if (maxChange >= 1000)
            throw new IllegalArgumentException("Too much change back give them dollar bills first!");
        if (coins.length == 0) {
            throw new IllegalArgumentException("Array of size 0 is not allowed");
        }
        int [ ] coinsUsed = new int[ maxChange + 1 ];
        int [] lastCoin= new int [maxChange+1];
        coinsUsed[ 0 ] = 0; lastCoin[ 0 ] = 1;
        ArrayList<Integer> changeBack=new ArrayList<>();
    //sort
        for (int i = 0; i < coins.length - 1; i++)
        { int idx = i;
            for (int k = i + 1; k < coins.length; k++)
                if (coins[k] > coins[idx])
                    idx = k;
                    temp = coins[idx];
                    coins[idx] = coins[i];
                    coins[i] = temp;
        }
        if (coins[0] >= 1000)
            throw new IllegalArgumentException("What kind of coin is that?");
        for( int cents = 1; cents <= maxChange; cents++ )
        {
            int minCoins = cents;
            int newCoin  = 1;

            for( int j = 0; j < coins.length; j++ )
            {
                if( coins[ j ] > cents )   // Cannot use coin j
                    continue;
                if( coinsUsed[ cents - coins[ j ] ] + 1 < minCoins )
                {
                    minCoins = coinsUsed[ cents - coins[ j ] ] + 1;
                    newCoin  = coins[ j ];
                }
            }

            coinsUsed[ cents ] = minCoins;
            lastCoin[ cents ]  = newCoin;
        }
        for( int i = maxChange; i > 0; )
        {
            changeBack.add(lastCoin[i]);
            i -= lastCoin[ i ];
        }
        return changeBack;
    }

}