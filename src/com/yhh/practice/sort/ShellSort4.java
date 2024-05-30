package com.yhh.practice.sort;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class ShellSort4 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 15, 36, 26, 27, 2};
        int[] sortNums = shellSort(nums);
        for (int num :
                sortNums) {
            System.out.print(num + " ");
        }
    }

    public static int[] shellSort(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int preIndex = i - gap;
                int cur = nums[i];
                while (preIndex >= 0 && nums[preIndex] > cur) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = cur;
            }
            gap = gap / 2;
        }
        return nums;
    }
}
