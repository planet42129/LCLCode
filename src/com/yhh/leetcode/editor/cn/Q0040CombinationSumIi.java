//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1537 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q0040CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Q0040CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            return null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*
1、组合问题：需要startIndex控制每次递归调用中for循环遍历的起始位置，避免出现{1,2} {2,1}这样重复的结果
2、candidates中的每个数字在每个组合中只能使用 一次 ：调用递归时给startIndex赋值为i+1，从左往右取，不回头
3、如何去重？
解法1：排序 + used数组
解法2：排序 + 设置一个递归函数中局部的set
解法3：排序 + i > startIndex
i>startIndex时，说明进入for循环的横向遍历，这时候可以树层去重，前提还是先排序集合


解法1：
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            used = new boolean[candidates.length];
            Arrays.fill(used, false);
            Arrays.sort(candidates);
            backtracking(candidates, target, 0, 0);
            return res;
        }

        private void backtracking(int[] candidates, int targetSum, int sum, int startIndex) {
            if (sum > targetSum) return;
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                    continue;
                }
                sum += candidates[i];
                path.add(candidates[i]);
                used[i] = true;
                backtracking(candidates, targetSum, sum, i + 1);
                used[i] = false;
                path.remove(path.size() - 1);
                sum -= candidates[i];
            }
        }

解法2：
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, target, 0, 0);
            return res;
        }

        private void backtracking(int[] candidates, int targetSum, int sum, int startIndex) {
            if (sum > targetSum) return;
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }
            HashSet<Integer> set = new HashSet<>(candidates.length);
            for (int i = startIndex; i < candidates.length; i++) {
                if (set.contains(candidates[i])) {
                    continue;
                }
                set.add(candidates[i]);
                sum += candidates[i];
                path.add(candidates[i]);
                backtracking(candidates, targetSum, sum, i + 1);
                path.remove(path.size() - 1);
                sum -= candidates[i];
            }
        }


解法3：
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, target, 0, 0);
            return res;
        }

        private void backtracking(int[] candidates, int targetSum, int sum, int startIndex) {
            if (sum > targetSum) return;
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                //如果是树枝的话（一直往下递归），i一直都是等于startIndex
                //i > startIndex 说明是开始横向遍历（for循环）了，处在同一树层，
                // 这时候就可以判断树层中是否有重复元素，当然在递归调用前要先对集合排序
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                sum += candidates[i];
                path.add(candidates[i]);
                backtracking(candidates, targetSum, sum, i + 1);
                path.remove(path.size() - 1);
                sum -= candidates[i];
            }
        }
 */