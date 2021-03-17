/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        connectTwoNode( root.left,root.right);

        return root;
    }

/*函数定义为，将传入的两个节点、及下面的子节点按要求全部相连
 *注意定义 不要管递归的细节
 */
    public void connectTwoNode(Node node1,Node node2){
        if(node1==null || node2==null ){
            return ;
        }

        node1.next = node2;
        
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);

        connectTwoNode(node1.right,node2.left);

    }
}











