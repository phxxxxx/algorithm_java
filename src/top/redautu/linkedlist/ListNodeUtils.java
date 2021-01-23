package top.redautu.linkedlist;
import top.redautu.*;
public class ListNodeUtils {

    ListNode successor = null; //后驱节点

    /**
     * 递归反转整个列表
     */
    public ListNode reverse(ListNode head){
        //考虑base case
        if (head.next == null)
            return head;
        //不要跳进去,考虑整个函数的功能逻辑
        ListNode last = reverse(head.next);
        head.next.next =head;
        head.next=null;
        return last;
    }

    /**
     * 递归反转链表的前N个节点
     */
    public ListNode reverseN(ListNode head,int n){
        if (n == 1){
            //记录下第n+1个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        
        //将第二个节点指向第一个
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 递归反转指定区间(从1开始)的节点
     */
    public ListNode reverseBetween(ListNode head,int m,int n){
        if (m == 1){
            return this.reverseN(head,n);
        }

        /*
        * 如果 m != 1 怎么办？如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；
        * 如果把 head.next 的索引视为 1 呢？那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的；
        * 那么对于 head.next.next 再往后推,就变成*/
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
}
