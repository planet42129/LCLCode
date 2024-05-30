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

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        HashMap<Integer, Integer> map;
        private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            //1 终止条件，注意是左闭右开区间
            if (inStart >= inEnd || postStart > postEnd) {
                return null;
            }
            //2 后序数组的最后一个元素就是当前的节点元素（根节点）
            int rootValue = postorder[postEnd - 1];
            TreeNode root = new TreeNode(rootValue);

            //3 当前根节点元素在中序数组的下标
            Integer rootIndex = map.get(rootValue);

           //4 左中序数组的长度与左后序数组的长度相同
            int subtreeLen = rootIndex - inStart;

            //5 切割中序数组和后序数组，递归地构造左子树和右子树
            root.left = buildTreeHelper(inorder, inStart, rootIndex, postorder, postStart, postStart + subtreeLen);
            root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, postorder, postStart + subtreeLen, postEnd - 1);

            return root;
        }
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            //都是左闭右开区间
            return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
