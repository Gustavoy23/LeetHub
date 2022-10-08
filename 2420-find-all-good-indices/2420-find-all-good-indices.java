class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] nonincreasing = new int[n];
        Arrays.fill(nonincreasing, 1);
        
        for(int i = 1; i < n; i++) {
            if(nums[i] <= nums[i-1])
               nonincreasing[i] = 1 + nonincreasing[i-1];
        }
        
        int[] nondecreasing = new int[n];
        Arrays.fill(nondecreasing, 1);
        
        for(int i = n - 2; i >=0; i--) {
            if(nums[i+1] >= nums[i])
            nondecreasing[i] = 1 + nondecreasing[i+1];
        }
        
       // System.out.println(Arrays.toString(nonincreasing));
       // System.out.println(Arrays.toString(nondecreasing));
        List<Integer> res = new ArrayList<>();
        for(int i = k; i < n - k; i++) {
            if(nondecreasing[i+1] >= k && nonincreasing[i-1] >= k) res.add(i);
        }
    return res;
    }
}