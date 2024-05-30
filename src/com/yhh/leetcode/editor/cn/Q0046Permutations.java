//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2875 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0046Permutations {
    public static void main(String[] args) {
        Solution solution = new Q0046Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }
    private void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (used[i] == true) { //该数字在树枝中用过，则跳过，接着下一个nums[i]
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }*/
