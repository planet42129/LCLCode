//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
//
// Related Topics 栈 字符串 👍 623 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.Stack;

public class Q1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new Q1047RemoveAllAdjacentDuplicatesInString().new Solution();
        solution.removeDuplicates("abbaca");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1 栈
       /* public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            *//*String ss = new String();
            int size = stack.size();
            for (int i = 0; i < stack.size(); i++) {
                ss =  stack.pop() + ss;
            }*//*
            StringBuilder sb = new StringBuilder();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }*/

        // 2 双指针
       /* public String removeDuplicates(String s) {
            char[] chs = s.toCharArray();
            int slow = 0;
            for (int fast = 0; fast < s.length(); fast++) {
                chs[slow] = chs[fast];
                if (slow > 0 && chs[slow] == chs[slow - 1]) {
                    slow--;
                } else {
                    slow++;
                }
            }
            return new String(chs, 0, slow);
        }*/

        public String removeDuplicates(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!sb.isEmpty() && c == sb.charAt(sb.length() - 1)) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
