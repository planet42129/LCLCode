//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1206 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.*;

public class Q0090SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new Q0090SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            return  null;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)
    /*
            List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            boolean[] used = new boolean[nums.length];
            Arrays.fill(used, false);
            Arrays.sort(nums);
            backTracking(nums, 0, used);
            return res;
        }

        private void backTracking(int[] nums, int startIndex, boolean[] used) {
            res.add(new ArrayList<>(path));
            if (startIndex == nums.length) {
                return;
            }
            for (int i = startIndex; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums, i + 1, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
     */
}
