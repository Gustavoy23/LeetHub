class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        
        int currentTime = 0;
        int biggest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < logs.length; i++) {
            int time = logs[i][1] - currentTime;
            int id = logs[i][0];
            
            if(!map.containsKey(id) || map.containsKey(id) && map.get(id) < time) map.put(id, time);
           
            biggest = Math.max(biggest, time);
            
            currentTime = logs[i][1];
        }
        
        for(int i = 0; i < n; i++) {
            if(map.containsKey(i) && map.get(i) == biggest) return i;  
        }
        
    return 0;
    }
}