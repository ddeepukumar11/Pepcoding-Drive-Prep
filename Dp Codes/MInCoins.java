class Solution{

	public int minCoins(int coins[], int M, int amt) 
	{ 
	    // Your code goes here
	    int n = M;
	    int[] dp = new int[amt + 1];
        
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int coin: coins){
            for(int i = 1; i < dp.length; i++){
                if(i >= coin){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

    return dp[amt] == Integer.MAX_VALUE - 1 ? -1 : dp[amt];
	} 
}