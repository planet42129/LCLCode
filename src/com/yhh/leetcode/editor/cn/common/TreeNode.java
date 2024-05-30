package com.yhh.leetcode.editor.cn.common;

/**
 * @author hyh
 * @date 2024/4/12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }
}
