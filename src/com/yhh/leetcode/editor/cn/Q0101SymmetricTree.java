//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2698 👎 0


package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q0101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Q0101SymmetricTree().new Solution();
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
        // 比较当前节点的两棵子树

        public boolean isSymmetric(TreeNode root) {

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/*public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> que = new LinkedList<>();
    que.offer(root.left);
    que.offer(root.right);
    while (!que.isEmpty()) {
        TreeNode node1 = que.poll();
        TreeNode node2 = que.poll();
        if (node1 == null && node2 == null) continue;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;

        que.offer(node2.left);
        que.offer(node1.right);
        que.offer(node2.right);
        que.offer(node1.left);
    }
    return true;
}*/
     /*    private boolean compare(TreeNode left, TreeNode right) {
                //比较的是左右子树
                if (left == null && right == null) return true;
                if (left == null || right == null || left.val != right.val) return false;

                //如果左右孩子均不为空，且数值相等，则继续判断外侧、里侧
                boolean outside = compare(left.left, right.right);
                boolean inside = compare(left.right, right.left);
                return outside && inside;
            }
            public boolean isSymmetric(TreeNode root) {
                if (root == null) return true;
                return compare(root.left, root.right);
            }*/
}
