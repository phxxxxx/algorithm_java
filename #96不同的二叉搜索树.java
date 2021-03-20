/*
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */

class Solution {

    //int res;
    int [][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1,n);
    }

    //此处函数的定义为 返回[lo,hi]之间BST的个数

    public int count(int lo , int hi){
        if(lo > hi) return 1;
        int res = 0;
        for(int i = lo; i <= hi;i++){
            if(memo[lo][hi] != 0){
                return memo[lo][hi];
            }

            int left = count(lo,i-1);
            int right = count(i+1,hi);
            res+=left*right;
           
        }
         memo[lo][hi] = res;
        return res;
    }
}
