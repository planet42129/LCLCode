//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1412 👎 0


package com.yhh.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0093RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new Q0093RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            return null;
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

/*    List<String> res =new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backTracking(sb, 0, 0);
        return res;
    }

    private void backTracking(StringBuilder sb, int startIndex, int dotCount) {
        if (dotCount == 3) {
            if (isValid(sb, startIndex, sb.length() - 1)) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb, startIndex, i)) {
                sb.insert(i + 1, ".");
                dotCount++;
                backTracking(sb, i + 2, dotCount);
                sb.deleteCharAt(i + 1);
                dotCount--;
            } else {
                break;
            }

        }
    }

    //左闭右闭区间[start, end]
    private boolean isValid(StringBuilder sb, int start, int end) {
        if (start > end) return false;
        String str = sb.substring(start, end + 1);
        if (str.length() > 3) {
            return false;
        }
        if (str.length() > 1 && str.charAt(0) == '0'){
            return false;
        }
        try {
            int num = Integer.parseInt(str);
            return num >= 0 && num <= 255;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
