class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            map.putIfAbsent(a, new ArrayList<>());
            List<Integer> list = map.get(a);
            list.add(b);
            map.put(a,list);
            
            map.putIfAbsent(b, new ArrayList<>());
            list = map.get(b);
            list.add(a);
            map.put(b,list);
            
        }
        
        Set<Integer> restriction = new HashSet<>();
        
        for(int i: restricted) restriction.add(i);
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int node = 0;
        q.add(node);
        int res  = 0;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            if(visited.contains(current) || restriction.contains(current) ) continue;
            
            res++;
            visited.add(current);
            if(map.get(current) == null) continue;
            
            for(int child: map.get(current)) {
                q.add(child);
            }
        }
    return res;
    }
}