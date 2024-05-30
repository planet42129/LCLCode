//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2804 👎 0


package com.yhh.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0017LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Q0017LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> actual = solution.letterCombinations("23");
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            return null;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    /*List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] digitStringMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, 0, digitStringMap);
        return res;
    }

    private StringBuilder sb = new StringBuilder();

    *//**
     * @param digits         传入的数字字符串，如“23”
     * @param digitStringMap 一个字符串数组，数字字符对应的字符串的映射
     * @param index          传入的字符串digits中遍历到第几个数字，index=0，表示遍历到“23”中的2，去digitStringMap中获取2下标对应的字符串
     *//*
    private void backTracking(String digits, int index, String[] digitStringMap) {
        //终止条件：当digits遍历完毕时
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';  // '2' - '0'结果为int的2
        String str = digitStringMap[digit];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(digits, index + 1, digitStringMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }




        List<String> res = new ArrayList<>();
        String[] digitStringMap = {"", "", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        public List<String> letterCombinations(String digits) {
            if (digits.equals("")) return res;
            backtracking(digits, 0);
            return res;
        }

        private void backtracking(String digits, int index) {
            if (index >= digits.length()) {
                res.add(sb.toString());
                return;
            }
            int mapIndex = digits.charAt(index) - '0';
            String s = digitStringMap[mapIndex];
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                backtracking(digits, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    */
}
