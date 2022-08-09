class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int item[]: items1) {
            map.put(item[0], map.getOrDefault(item[0],0)+item[1]);
        }
        
         for(int item[]: items2) {
            map.put(item[0], map.getOrDefault(item[0],0)+item[1]);
        }
        
          Map<Integer, Integer> map2 = new HashMap<>();
         List<Integer> l = new ArrayList<>();
         for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
             
             l.add(entry.getKey());
            
         }
        
        Collections.sort(l);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < l.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add((l.get(i)));
            list.add(map.get(l.get(i)));
            res.add(list);
        }
    
    return res;
    }
}