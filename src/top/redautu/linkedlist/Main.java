package top.redautu.linkedlist;

import top.redautu.linkedlist.ListNode;
import top.redautu.linkedlist.ListNodeUtils;
public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);


        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        ListNodeUtils listNodeUtils = new ListNodeUtils();
//        ListNode reverse = listNodeUtils.reverse(listNode);
//        System.out.println(reverse);
//
//        System.out.println("====================/n");
//        ListNode reverseN = listNodeUtils.reverseN(listNode, 3);
//        System.out.println(reverseN);
//        ListNode listNode5 = listNodeUtils.reverseBetween(listNode, 2, 4);
//
//        System.out.println(listNode5);

        Solution solution = new Solution();
        ListNode listNode5 = solution.reverseBetween(listNode, 2, 4);
        System.out.println(listNode5);
    }
}
