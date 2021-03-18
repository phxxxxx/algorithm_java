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
     *怎么找到相同的子树-> 序列化二叉树
     * 递归函数定义，获得一个描述二叉树的字符串
     * 用后序遍历，从叶子节点开始，有重复的就放到hashmap里面
     ****/
    //存入所有的字符串化的子树，【以及出现的次数？？】
    HashMap<String,Integer> memo = new HashMap<>();
    //记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findRepeat(root);
        return res;    
    }

    public String findRepeat(TreeNode root){
        if(root == null) return "#";

        String left = findRepeat(root.left);
        String right = findRepeat(root.right);

        String subTree = left +','+right+ ',' + root.val;

        int freqs = memo.getOrDefault(subTree,0);
        //多次重复也只会被加入结果集一次
        if(freqs==1){
            res.add(root);
        }
        memo.put(subTree,freqs + 1);

        return subTree;

    }
}