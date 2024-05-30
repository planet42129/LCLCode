//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1563 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0047PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Q0047PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            return null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            //该数字在树枝中用过，则跳过，接着下一个nums[i]
            if (used[i] == true) {
                continue;
            }

            // used[i - 1] == true，说明同⼀树枝nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过

            //解决树层去重，used[i - 1]为false，说明已经经过回溯才有的false
            //此时nums[i]与nums[i - 1]为同一树层
            //要用这个方法去重，数组一定要先排序！
            if (i > 0 && nums[i]  == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true; //标记同⼀树枝nums[i]使⽤过，防止同一树枝重复使用
            backTracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }*/
