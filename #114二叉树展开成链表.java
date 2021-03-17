/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
     *递归函数定义为 传入节点后，结果是拉长成为链表
     * 1.左子树变链表
     * 2.右子树变链表
     * 3.root.next->左子树，左子树最后节点->拉长的右子树
     */
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode left ;
        TreeNode right;
        //左右子树已经被拉平成一个链表
        flatten(root.left);
        flatten(root.right);

        left = root.left;
        right =root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right!=null){
            p = p.right;
        }
        p.right = right; 

    }
}