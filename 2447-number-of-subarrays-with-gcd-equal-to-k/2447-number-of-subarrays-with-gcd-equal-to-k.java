class Solution {
    private int find(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return find(b, a % b);
    } 
        
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int GCD = nums[i];
            for(int j = i; j < n; j++) {
                GCD = find(GCD, nums[j]);
                if(GCD == k) {
                    ans++;
                }
            }
        }
    return ans;
    }
}