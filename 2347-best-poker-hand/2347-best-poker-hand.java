class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        Map<Integer, Integer> criteria1 = new HashMap<>();
        Map<Integer, Integer> criteria2 = new HashMap<>();
        
        for(int rank: ranks) {
            criteria1.put(rank, criteria1.getOrDefault(rank,0)+1);
        }
        
        for(int suit: suits) {
            criteria2.put(suit, criteria2.getOrDefault(suit,0)+1);
        }
        
        for(int i: criteria2.values()) {
            if(i == 5) return "Flush";
        }
        
        for(int i: criteria1.values()) {
            if(i >= 3) return "Three of a Kind";
        }
        
        for(int i: criteria1.values()) {
            if(i == 2) return "Pair";
        }
        
        
        return "High Card";
        
    }
}