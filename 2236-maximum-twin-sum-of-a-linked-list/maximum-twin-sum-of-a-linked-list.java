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
    public int pairSum(ListNode head) {
        // List<Integer> list = new ArrayList<>();
        // ListNode current = head;

        // while(current != null){
        //     list.add(current.val);
        //     current = current.next;
        // }
        // int maxSum = 0;
        // for(int i = 0; i < list.size() / 2; i++){
        //     int sum = list.get(i) + list.get(list.size() - 1 - i);
        //     maxSum = Math.max(maxSum, sum);
        // }
        // return maxSum;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode left = head;
        ListNode right = prev;
        int maxSum = 0;
        while(right != null){
            int sum = left.val + right.val;
            maxSum = Math.max(maxSum, sum);

            left = left.next;
            right = right.next;
        }
        return maxSum;
    }
}