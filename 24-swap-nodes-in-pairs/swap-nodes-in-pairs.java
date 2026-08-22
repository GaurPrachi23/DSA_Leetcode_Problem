
class Solution {
    public ListNode swapPairs(ListNode head) {
       if(head == null){
            return null;
       } 
       
       
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode prev = dummy;

       while(prev.next != null && prev.next.next != null){
           ListNode first = prev.next;
           ListNode second = first.next;
           ListNode nextPair = second.next;

           second.next = first;
           first.next = nextPair;
           prev.next = second;

           prev = first;
       }
       return dummy.next;
    }
}