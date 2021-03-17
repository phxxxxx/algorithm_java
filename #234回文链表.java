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

    ListNode reverseNode = null;
    public boolean isPalindrome(ListNode head) {
        reverseNode = reverse(head);
        while(head.next != null){
 System.out.println("***");
            if(head.val!=reverseNode.val){
                System.out.println("***");
            return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if(head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;    
    }