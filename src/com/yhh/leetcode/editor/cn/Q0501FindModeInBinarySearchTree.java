//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 744 👎 0


package com.yhh.leetcode.editor.cn;

import com.yhh.leetcode.editor.cn.common.TreeNode;

import java.util.*;

public class Q0501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q0501FindModeInBinarySearchTree().new Solution();
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
        /*
给你一个含重复值的二叉搜索树（BST）的根节点 root ，
找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。
假定 BST 满足如下定义：
结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树
         */
        Map<Integer, Integer> map = new HashMap<>();

        private void traverse(TreeNode root) {
            if (root == null) return;
            //值-次数
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            traverse(root.left);
            traverse(root.right);
        }
        public int[] findMode(TreeNode root) {
            traverse(root);
            //找到最大次数
            int maxFrequency = 0;
            for (Integer value : map.values()) {
                if (value > maxFrequency) {
                    maxFrequency = value;
                }
            }
            List<Integer> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) == maxFrequency) {
                   list.add(key);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
/*BST版本
    private int count;
    private int maxCount;
    private TreeNode pre;
    private List<Integer> resList;

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(root.val);
        } else if (count == maxCount) {
            resList.add(root.val);
        }
        pre = root;
        traversal(root.right);
    }
    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        resList = new ArrayList<>();
        pre = null;
        traversal(root);
        int[] res = new int[resList.size()];
        int index = 0;
        for (int i = 0; i < resList.size(); i++) {
            res[index++] = resList.get(i);
        }
        return res;
    }





 */

    /*
           private int[] res;
        private int count;
        private int maxCount;
        private TreeNode pre;
        private List<Integer> list;

        public int[] findMode(TreeNode root) {
            count = 0;
            maxCount = Integer.MIN_VALUE;
            pre = null;
            list = new ArrayList<>();
            traversal(root);
            //处理List
            res = new int[list.size()];
            int index = 0;
            for (Integer num : list) {
                res[index++] = num;
            }
            return res;
        }

       //中序遍历BST，众数一定是相邻节点
    private void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);

        //中
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            list.clear();
            maxCount = count;
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        pre = root;

        //右
        traversal(root.right);
    }
     */
    /*普通二叉树中找众数

     */
}
