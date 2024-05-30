package com.yhh.practice.sort;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class InsertSort3 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 15, 36, 26, 27, 2};
        int[] sortNums = insertSort(nums);
        for (int num :
                sortNums) {
            System.out.print(num + " ");
        }
    }
    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int preIndex = i - 1;//已排序序列的最后一个元素的下标
            int cur = nums[i];//当前要排序的元素
            while (preIndex >= 0 && nums[preIndex] > cur) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = cur;
        }
        return nums;
    }
}
