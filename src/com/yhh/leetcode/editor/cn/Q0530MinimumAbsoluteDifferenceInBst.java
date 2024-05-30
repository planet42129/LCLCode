//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 551 👎 0

  
package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

public class Q0530MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
         Solution solution = new Q0530MinimumAbsoluteDifferenceInBst().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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

    public int getMinimumDifference(TreeNode root) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
    private TreeNode pre = null;
    private int min = Integer.MAX_VALUE;
    private void traversal(TreeNode root) {
        if (root == null) return ;
        traversal(root.left);
        if (pre != null && (root.val - pre.val) < min) {
            min = root.val - pre.val;
        }
        pre = root;
        traversal(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return min;
    }
 */
    /*
        private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    //BST的中序遍历序列是递增的，最小差值从中序序列中找
    private void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);

        //中
        if (pre != null && root.val - pre.val < min) {
            min = root.val - pre.val;
        }
        pre = root;

        //右
        traversal(root.right);
    }
     */
}
