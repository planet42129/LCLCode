//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1122 👎 0


package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q0257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new Q0257BinaryTreePaths().new Solution();
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

        public List<String> binaryTreePaths(TreeNode root) {
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
/*
    private void traversal(TreeNode root, List<Integer> path) {
        path.add(root.val);//中
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        //回溯和递归同时进行，所以要放在同一个花括号里
        if (root.left != null) {//左
            traversal(root.left, path);
            path.remove(path.size() - 1);// 回溯
        }
        if (root.right != null) {//右
            traversal(root.right, path);
            path.remove(path.size() - 1);// 回溯
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, path);
        return res;
    }
 */

    /*
        class Solution {
        List<String> res;
        List<Integer> path;

        public List<String> binaryTreePaths(TreeNode root) {
            res = new ArrayList<>();
            path = new ArrayList<>();
//            path.add(root.val);
            traversal(root, path);
            return res;
        }

        private void traversal(TreeNode root, List<Integer> path) {
            path.add(root.val);
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size() - 1; i++) {
                    sb.append(path.get(i)).append("->");
                }
                sb.append(path.get(path.size() - 1));
                res.add(sb.toString());
            }
            if (root.left != null) {
//                path.add(root.left.val);
                traversal(root.left, path);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
//                path.add(root.right.val);
                traversal(root.right, path);
                path.remove(path.size() - 1);
            }
        }
    }
     */
}
