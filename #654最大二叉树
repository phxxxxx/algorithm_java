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
     *递归函数定义为返回构造好的最大二叉树的根节点
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construction(nums,0,nums.length-1);
    }

    public TreeNode construction(int[] nums,int low,int high){
        //base case
        if(low >high) return null;

        //找到数组中最大的值，并获得其索引
        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for(int i = low; i <= high; i++){
            if(maxVal < nums[i]){
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = construction(nums,low,index-1);
        root.right = construction(nums,index+1,high);
        
        return root;

    }

}




