/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return head;

        
        List<Integer> list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);

            head = head.next;
        }
            
        int right= 0;

        
        int n = list.size();
        if(n == 1 && list.get(0)==0) return null;

        Set<Integer> set = new HashSet<>();
        
        while(right < list.size()) {
            
            
            int number = -1*list.get(right);
            if(number == 0){
              list.remove(right);  
                right--;
            } 
            
            int sum = 0;
            int left = right -1;
            while(left >= 0) {
                
                sum+=list.get(left);
                if(sum == number) {
                   // System.out.println(sum);
                    while(left <= right) {
                        list.remove(left);
                        right--;
                    }
                 break;   
                }
             left--;
        }
            
        right++;     
         
        }
        
        if(n == 1 && list.get(0)==0) return null;
       // System.out.print(list.get(0));
        ListNode curr = new ListNode();
          ListNode dummy = curr;
        for(int i: list) {
            curr.next = new ListNode(i);
            curr = curr.next;
                                    
        }
      
        
        
    return dummy.next;
    }
}