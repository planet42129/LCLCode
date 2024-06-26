//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
// 
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 775 👎 0


package com.yhh.leetcode.editor.cn;

import com.sun.source.tree.Tree;
import com.yhh.leetcode.editor.cn.common.TreeNode;

public class Q0654MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q0654MaximumBinaryTree().new Solution();
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

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
/*
public TreeNode constructMaximumBinaryTree(int[] nums) {
            return helper(nums, 0, nums.length);
        }

        private TreeNode helper(int[] nums, int leftIndex, int rightIndex) {
            if (rightIndex - leftIndex < 1) return null;
            if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
            int maxIndex = leftIndex;
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = helper(nums, leftIndex, maxIndex);
            root.right = helper(nums, maxIndex + 1, rightIndex);
            return root;
        }
 */
    /*
            public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return helper(nums, 0, nums.length);
        }

        private TreeNode helper(int[] nums, int start, int end) {
            if (end - start < 1) {
                return null;
            }
            if (end - start == 1) {
                return new TreeNode(nums[start]);
            }
            int maxValueIndex = start;
            for (int i = start + 1; i < end; i++) {
                if (nums[i] > nums[maxValueIndex]) {
                    maxValueIndex = i;
                }
            }
            TreeNode root = new TreeNode(nums[maxValueIndex]);
            root.left = helper(nums, start, maxValueIndex);
            root.right = helper(nums, maxValueIndex + 1, end);
            return root;
        }

     */
}
