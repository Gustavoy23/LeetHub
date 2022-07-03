/*
Input: n = 6, delay = 2, forget = 4
Output: 5
Explanation:
Day 1: Suppose the first person is named A. (1 person)
Day 2: A is the only person who knows the secret. (1 person)
Day 3: A shares the secret with a new person, B. (2 people)
Day 4: A shares the secret with a new person, C. (3 people)
Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
Day 6: B shares the secret with E, and C shares the secret with F. (5 people)

*/

class Solution {
    long mod = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n];
        long[] awareF = new long[n];
        
        int k = 0;
        awareF[0] = 1;
        while(k <= delay) {
            dp[k] = 1;
            k++;
        }
        
        long count = delay;
        for(int i = delay; i < n; i++) { //3(Day 4)
            dp[i] = dp[i-1] % mod; 
            
 
            if(i - forget >= 0) {
               dp[i] = (dp[i] - awareF[i - forget]) % mod;
               awareF[i - forget] = 0;
            }
            
            if(i - forget >= 0) {
            for(int j = i - forget ; j <= i-delay; j++) 
                 awareF[i]+= awareF[j] % mod;
    
                dp[i] = (dp[i] + awareF[i]) % mod;
            } else {
            for(int j = 0; j <=  i-delay; j++) 
                awareF[i]+= awareF[j] % mod;
          
                dp[i] = (dp[i] + awareF[i]) % mod;
            }
            

        }
    
    return (int)(dp[n-1] % mod);
    }
}