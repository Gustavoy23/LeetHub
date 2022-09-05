class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int res = 0;
        
        boolean flag = true;
        while(flag) {
            flag=false;
        for(int i = 0; i < sb.length() -1; i++) {
           if(sb.charAt(i)=='0' && sb.charAt(i+1) == '1') {
               sb.setCharAt(i,'1');
               sb.setCharAt(i+1,'0');
                flag = true;
               i++;
           } 
              
        }
           if(flag)  res++;
             //System.out.println(sb.toString());
        }
        
       // System.out.println();
    return res;
    }
}