class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || head.next == null || k == 0){
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while(tail.next != null){
            n++;
            tail = tail.next;
        }
        k %= n;
        if(k == 0)
            return head;

            int count = 1;
            ListNode newTail = head;
            while(newTail != null){
                if(count == n-k){
                    break;
                }
                    count++;
                    newTail = newTail.next;
            }
                tail.next = head;
                ListNode res = newTail.next;
                newTail.next = null;

                head = res;
            
            return head;
    }
}