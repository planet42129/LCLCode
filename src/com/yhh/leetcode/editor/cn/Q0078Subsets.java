//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2281 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0078Subsets {
    public static void main(String[] args) {
        Solution solution = new Q0078Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            return null;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*
怎么表示空集？
怎么处理终止条件？

求纯的子集问题，不需要任何剪枝操作！因为求子集问题本来就是要遍历整棵树

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
 */
