//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2320 👎 0


package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Q0098ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q0098ValidateBinarySearchTree().new Solution();
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


        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            TreeNode pre = null;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();

                    if (pre != null && pre.val >= cur.val) return false;
                    pre = cur;

                    cur = cur.right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*验证一棵二叉树是二叉搜索树，它的中序遍历序列一定是递增的
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }*/

/*
        private TreeNode pre = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            //左
            boolean left = isValidBST(root.left);

            //中
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            //更新pre
            pre = root;

            //右
            boolean right = isValidBST(root.right);

            return left && right;
        }
 */

/*迭代
public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            TreeNode pre = null;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();

                    if (pre != null && pre.val >= cur.val) return false;
                    pre = cur;

                    cur = cur.right;
                }
            }
            return true;
        }
 */
