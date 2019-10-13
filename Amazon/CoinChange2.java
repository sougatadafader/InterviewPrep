package Amazon;

public class CoinChange2 {

	public int change(int amount, int[] coins) {
		
		int[][] dp = new int[coins.length+1][amount+1];
		dp[0][0] =1;
		
		for(int i=0;i<=coins.length;i++) {
			
			dp[i][0] = 1;
			
			for(int j=0;j<=amount;j++) {
				
				int currentCoinValue = coins[i-1];
				int withoutThisCoin = dp[i-1][j];
				int withThisCoin = currentCoinValue <= j? dp[i][j-currentCoinValue]:0;
				dp[i][j] = withoutThisCoin + withThisCoin;		
			}
			
		}
		
		return dp[coins.length][amount];
	}
	
	
}
