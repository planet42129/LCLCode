package com.yhh.practice.exam.hw0424;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author hyh
 * @date 2024/4/24
 */
public class Main {
    static StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int target = sc.nextInt();
        String[] s1 = str.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(nums);
        // 左闭右开区间
        TreeNode root = buildTree(nums, 0, nums.length);
        path.append("S");
        TreeNode searchResult = searchBST(root, target);
        if (searchResult == null) {
            path.append("N");
        } else {
            path.append("Y");
        }
        System.out.println(path.toString());
    }

    private static TreeNode searchBST(TreeNode cur, int target) {
        if (cur == null || cur.val == target) {
            return cur;
        }
        if (cur.left == null  && cur.right == null &&  cur.val != target) {
            return null;
        }
        TreeNode result = null;
        if (target < cur.val) {
            path.append("L");
            result = searchBST(cur.left, target);
        }
        if (target > cur.val) {
            path.append("R");
            result = searchBST(cur.right, target);
        }
        return result;
    }

    /*private static TreeNode searchBST(TreeNode cur, int target) {
        if (cur == null || cur.val == target) {
            return cur;
        }
        TreeNode result = null;
        if (target < cur.val) {
            TreeNode left = searchBST(cur.left, target);
            if (left != null) {
                return left;
            }
        }
        if (target > cur.val) {
            TreeNode right = searchBST(cur.right, target);
            if (right != null) {
                return right;
            }
        }
        return null;
    }*/
    private static TreeNode buildTree(int[] nums, int left, int right) {
        if (right - left < 1) return null;
        if (right - left == 1) return new TreeNode(nums[left]);
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
    }
}