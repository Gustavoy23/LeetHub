class Solution {
    int res;
    public int distributeCookies(int[] cookies, int k) {
     
        res = Integer.MAX_VALUE;
      
        backtracking(cookies, new int[k],0,k);
        
        
    return res;        
    }
    
    private void backtracking(int[] cookies, int[] bag,int index,int k) {
        if(index >= cookies.length) {   
            int tmp = 0;
            for(int ele: bag) {
                
                tmp = Math.max(tmp, ele);
            }
            res= Math.min(tmp, res);
        return;
        }
        
        for(int i = 0; i < k; i++) {
                bag[i]+=cookies[index];
                backtracking(cookies, bag, index+1, k );
                bag[i]-=cookies[index];
           }
        }
        
        
}