class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int energyReq = 0;
        for(int i: energy) {
            energyReq +=i;
        }
        
        if(initialEnergy > energyReq) {
            energyReq = 0;
        } else {
           energyReq = energyReq - initialEnergy + 1 ;  
        }
        
        int expReq = 0;
        int accExp=initialExperience;

        for(int exp: experience) {     
            if(accExp <= exp) {
                expReq = expReq + (exp - accExp)+1;
                accExp+=  (exp - accExp+1) + exp;
                 //accExp+=exp;    
            } else {
                accExp+=exp;    
            }               
        }
        
        
            
        return (energyReq) + (expReq);
    }
}