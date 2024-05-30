//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 572 👎 0


package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

public class Q0513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new Q0513FindBottomLeftTreeValue().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {


        public int findBottomLeftValue(TreeNode root) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/*
最底层：求最大深度
最左边：当前处于最大深度的节点的值， 每次求深度的时候记录当前值，逐步更新
    private int maxDepth = Integer.MIN_VALUE;
    private int res = 0;
    private void getDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
            return;
        }
        if (root.left != null) {
            depth++;
            getDepth(root.left, depth);
            depth--;
        }
        if (root.right != null) {
            depth++;
            getDepth(root.right, depth);
            depth--;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        getDepth(root, 0);
        return res;
    }
 */
}
