class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        Set<String> setA = new HashSet<>();
        
        int dAliceStart = Integer.parseInt(arriveAlice.substring(3,5));
        int dAliceEnd = Integer.parseInt(leaveAlice.substring(3,5));
        
        int mAliceStart = Integer.parseInt(arriveAlice.substring(0,2));
        int mAliceEnd = Integer.parseInt(leaveAlice.substring(0,2));
        
        for(int i = dAliceStart,j = mAliceStart; i <= days[j-1] && (j <= mAliceEnd );i++) {
            setA.add(i+"-"+j);
             //   System.out.println(i + "- "+ j);
            if(i == dAliceEnd && j ==mAliceEnd) break; 
            if( j!= mAliceEnd && i == days[j-1] ){
                i = 0;
                j++;
            }
        }
        
        Set<String> setB = new HashSet<>();
        
        
        int dBobStart = Integer.parseInt(arriveBob.substring(3,5));
        int dBobEnd = Integer.parseInt(leaveBob.substring(3,5));
        
        int mBobStart = Integer.parseInt(arriveBob.substring(0,2));
        int mBobEnd = Integer.parseInt(leaveBob.substring(0,2));
        
        for(int i = dBobStart, j = mBobStart; ( i <= days[j-1]) && (j <= mBobEnd );i++) {
           
           setB.add(i+"-"+j);
           
       
            
           if(i == dBobEnd && j ==mBobEnd) break; 
           if((j !=mBobEnd) && i == days[j-1] ){
                i = 0;
                j++;
            }    
        }
        
        int res = 0;
        for(int i = 1; i <= 12; i++) {
            for(int j = 1; j <= days[i-1]; j++) {
                if(setA.contains(j+"-"+i) && setB.contains(j+"-"+i))                     {
               //      System.out.println(i + "- "+ j);
                    res++;
                 }
            }
        }
        
     //   System.out.println();
    
    return res;
    }
}