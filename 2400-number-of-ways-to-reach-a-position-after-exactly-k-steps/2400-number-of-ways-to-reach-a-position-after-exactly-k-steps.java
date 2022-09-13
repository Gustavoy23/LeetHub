class Solution {
    private long mod = 1000000007;
    public int numberOfWays(int start, int end, int k) {
        
        long[][] dp = new long[3002][1001];
        
        for(long i[]: dp) Arrays.fill(i,-1);
        
        
        return nOfWays(start, end, k, start, dp);
        
    }
    
    private int nOfWays(int start, int end, int k, int curr, long[][] dp){
        if(k == 0 ) {
            if(curr == end) return 1;
            else return 0;
        }
        
        //if(curr < 0 || curr > (end + 1001)  ) return 0;
    
        if(dp[curr+1001][k] != -1) return (int)dp[curr+1001][k];
        
        long leftWays = nOfWays(start, end, k - 1, curr -1, dp)%mod;
        long rightWays = nOfWays(start, end, k - 1, curr +1, dp)%mod;
    
        dp[curr+1001][k] = (leftWays + rightWays) % mod;
    
        return (int)dp[curr+1001][k];
    }
}