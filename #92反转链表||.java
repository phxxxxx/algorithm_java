92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

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

    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left ==1 ){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left - 1, right -1);
        return head;        
    
    }

    public ListNode reverseN(ListNode head,int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}