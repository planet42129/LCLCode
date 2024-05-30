//给定二叉搜索树（BST）的根节点
// root 和一个整数值
// val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
// null 。 
//
// 
//
// 示例 1: 
//
// 
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// 示例 2: 
// 
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 463 👎 0


package com.yhh.leetcode.editor.cn;

import com.sun.source.tree.Tree;
import com.yhh.leetcode.editor.cn.common.TreeNode;

import java.util.Stack;

public class Q0700SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q0700SearchInABinarySearchTree().new Solution();
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

        public TreeNode searchBST(TreeNode root, int val) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/*BST中的搜索-迭代
    public TreeNode searchBST(TreeNode root, int val) {
            while (root != null) {
                if (val < root.val) {
                    root = root.left;
                } else if (val > root.val) {
                    root = root.right;
                } else {
                    return root;
                }
            }
            //当 当前节点 为空的时候，跳出循环，返回null值
            return null;
    }
 */
    /*BST中的搜索-递归
            //找到一个符合条件的结果就返回
        public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            TreeNode left = searchBST(root.left, val);
            if (left != null) return left;
        }
        if (val > root.val) {
            TreeNode right = searchBST(root.right, val);
            if (right != null) return right;
        }
        return null;
    }
     */

    /*普通二叉树的搜索-递归
            public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) {
                return root;
            }
            TreeNode left = searchBST(root.left, val);
            if (left != null) return left;
            TreeNode right = searchBST(root.right, val);
            if (right != null) return right;
            return null;
        }

     */
}
