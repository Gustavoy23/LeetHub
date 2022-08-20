class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        
        int count = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            
           
            int countprev= 0;
            Set<Integer> set = new HashSet<>();
            
             int j = i-1;
            while(j >= 0){
               if(nums[i] - nums[j] == diff) set.add(nums[i]-nums[j]);
               j--;
            } 
            
            j = i+1;
            while(j < nums.length) {
                if(set.contains(nums[j]-nums[i])) {
                    countprev++;
                  
                }
                j++;
            }           
            
        count+=countprev;
        }
    return count;
    }
}