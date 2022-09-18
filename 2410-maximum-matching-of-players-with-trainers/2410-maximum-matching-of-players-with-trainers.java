class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int np = players.length;
        int nt = trainers.length;
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        int res = 0;
        int i =0, j =0;
        while(i < np && j < nt) {
                
                int dif = 0;
                while(j < nt && players[i] > trainers[j] ) {
                    j++;
                }
            
            if(j == nt) break;   
            
            res++;
  
        j++;
        i++;
        }
        
    return res;
    }
}