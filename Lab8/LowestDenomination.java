package lab8CS146;

import java.util.Arrays;

public class LowestDenomination {

	public static int coinChange(int[] coins, int amount)
	{
		int[] total = new int[amount + 1];
		
		Arrays.fill(total, Integer.MAX_VALUE);
		total[0] = 0;
		
		for (int i = 1; i <= amount; i++)
		{
			for (int coin : coins)
			{
				if (i >= coin && total[i - coin] != Integer.MAX_VALUE)
				{
					total[i] = Math.min(total[i], total[i - coin] + 1);
				}
			}
		}
		
		if (total[amount] == Integer.MAX_VALUE) return -1;
		
		return total[amount];
	}
	
	public static void main(String[] args)
	{	
		int[] coins = {2, 4, 8};
		
		System.out.println(coinChange(coins, 13));
	}
}
