//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 782 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.*;

public class Q0491NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new Q0491NonDecreasingSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> findSubsequences(int[] nums) {
            return null;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*

不能用之前的 排序 + used数组的方式实现树层去重！ 因为排序会打乱集合原有的顺序！
这里用set或者数组的方式 实现树层去重！

怎么知道同层的元素是否使用过了？ 在递归函数里定义一个set，存放 本层  已经使用过的元素
HashSet<Integer> set = new HashSet<>();


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            // 不能重新排序数组，这会打乱它本来的次序
            backTracking(nums, 0);
            return res;
        }

        private void backTracking(int[] nums, int startIndex) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            if (startIndex >= nums.length) {
                return;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++) {
                if ((!path.isEmpty() && path.get(path.size() - 1) > nums[i]) || set.contains(nums[i])) {
                   continue;
                }
                set.add(nums[i]);
                path.add(nums[i]);
                backTracking(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }


        设置标记数组
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtracking(nums, 0);
            return res;
        }

        private void backtracking(int[] nums, int startIndex) {
            if (path.size() >= 2) {
                res.add(new ArrayList<>(path));
            }
            if (startIndex >= nums.length) {
                return;
            }
            int[] setArr = new int[201];
            for (int i = startIndex; i < nums.length; i++) {
                if ((!path.isEmpty() && path.get(path.size() - 1) > nums[i])
                        || (setArr[nums[i] + 100] == 1)) {
                    continue;
                }
                setArr[nums[i] + 100] = 1;
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
 */