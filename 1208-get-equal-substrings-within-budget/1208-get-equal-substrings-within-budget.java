class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int dif[] = new int[n];
        
        for(int i = 0; i  < n; i++) {
            dif[i] = Math.abs(s.charAt(i) - t.charAt(i));    
        }
        
        int right = 0;
        int left = 0;
        int res = 0;
        int cost = 0;
        int len = 0;
        while( right < n ) {
        

            cost+= dif[right];
   
        len++;    
        if(cost > maxCost) {
            cost = cost - dif[left];
            left++;
            len--;
        } else {
            res = Math.max(len,res);
        }
            
        right++;
            
        }
    return res;
    }
}