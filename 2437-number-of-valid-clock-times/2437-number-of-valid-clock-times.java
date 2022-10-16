class Solution {
    public int countTime(String time) {
        
        int h1 = time.charAt(0);
        int h2 = time.charAt(1);
        
        int m1 = time.charAt(3);
        int m2 = time.charAt(4);
        
        int a = 1, b = 1, c = 1, d =1;
        if(h1 == '?') {
           if(h2 == '?') {
               a = 3;
           } else if(h2 - '0' < 4){
               a = 3;
           } else {
               a = 2;
           }
        } 
        
        if( h2 == '?') {
            if(h1 == '?') {
                b = 10; 
             } else if(h1 - '0' == 2) {
                b = 4;
            } else {
                b = 10;
            }
        }
        if( h2 == '?'&& h1 == '?') {
            a=24;
            b=1;
        }
        
        if(m1 == '?') c = 6;
        
        if(m2 == '?') d = 10;
        
        return a*b*c*d;
    }
}