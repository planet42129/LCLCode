//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1774 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new Q0131PalindromePartitioning().new Solution();
       /* List<List<String>> aab = solution.partition("aab");
        System.out.println(aab);*/
//        List<List<String>> res = solution.partition("aabaa");
        //[[a, a, b, a, a], [a, a, b, aa], [a, aba, a], [aa, b, a, a], [aa, b, aa], [aabaa]]
//        System.out.println(res);
//        System.out.println(solution.isPalindrome("aa", 0, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> partition(String s) {
            return null;
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

/*    List<List<String>> res;
    List<String> path;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(s, 0);
        return res;
    }
    private void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i) == true) {// [startIndex, i]
                String substring = s.substring(startIndex, i + 1);
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }*/
}
