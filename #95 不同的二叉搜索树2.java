/*
95. 不同的二叉搜索树 II
给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

 

示例：

输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/

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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return build(1,n);
    }
    //函数定义为：返回给定的【lo,hi】区间中所有不同结构的二叉搜索树的节点
    public List<TreeNode> build(int lo, int hi){
        List<TreeNode> res = new LinkedList<TreeNode>();
        //首先考虑base case
        if(lo > hi){
            res.add(null);
            return res;
        }
        for(int i = lo; i <= hi;i++){

            List<TreeNode> left = build(lo,i-1);
            List<TreeNode> right = build(i + 1,hi);

            //穷举所有左右子树的组合
            for(TreeNode le : left){
                for(TreeNode ri : right){
                    //将i作为根节点root的值
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    root.right = ri;
                    res.add(root);
                }
            }

        }
        return res;


    }
}




















