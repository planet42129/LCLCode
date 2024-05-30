//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1211 👎 0


package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q0106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            //左闭右开区间
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
/*
    HashMap<Integer, Integer> map = new HashMap<>();
    private TreeNode helper(int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart, int postEnd) {
        if (inStart >= inEnd || postStart >= postEnd) return null;
        int rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeftSubTree = rootIndex - inStart;
        root.left = helper(inorder, inStart, rootIndex, postorder, postStart, postStart  + lenOfLeftSubTree);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart  + lenOfLeftSubTree, postEnd - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //给中序数组构造元素值和数组下标索引的映射
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //左闭右开区间
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
 */

    /*
            Map<Integer, Integer> map = new HashMap<>();
        private TreeNode helper(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int postStart, int postEnd) {
            //终止条件
            if (inStart >= inEnd || postStart >= postEnd) {
                return null;
            }
            //后序序列的最后一个元素为当前的根节点元素
            int rootValue = postorder[postEnd - 1];
            TreeNode root = new TreeNode(rootValue);

            //获取当前的根节点元素在中序数组中的下标rootIndex
            int rootIndex = map.get(rootValue);

            //中序序列的左子数组的长度等于后序序列的左子数组的长度
            int lenOfLeft = rootIndex - inStart;

            //以rootIndex分割后序序列的左子数组、右子数组
            //递归构造左子树
            root.left = helper(inorder, inStart, rootIndex,
                    postorder, postStart, postStart + lenOfLeft);
            //递归构造右子树
            root.right = helper(inorder, rootIndex + 1, inEnd,
                    postorder, postStart + lenOfLeft, postEnd - 1);
            //将根节点返回
            return root;
        }
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            //将中序序列数组的 值->下标 放入map
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            //左闭右开区间
            return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }

     */
}
