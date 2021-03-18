/*105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
   */

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,0,preorder.length -1,
                        inorder,0,inorder.length -1);

    }

    public TreeNode build(int[] preArr,int preStart,int preEnd,
                            int[] inArr,int inStart,int inEnd ){
            //base case
            if(preStart > preEnd){
                return null;
            }               
            //确认中序遍历中 root的val值索引
            int index = -1;
            int rootVal = preArr[preStart];
            for(int i = inStart;i <= inEnd;i++){
                if(rootVal == inArr[i]){
                    index = i;
                    break;
                }
            }
            int leftSize = index - inStart;
            

            TreeNode root = new TreeNode(rootVal);
            root.left = build(preArr,preStart+1, preStart + leftSize,
                    inArr,inStart, index -1);
            root.right = build(preArr,preStart+leftSize+1,preEnd,
                                inArr,index+1,inEnd);
            return root;                    
    }
}



