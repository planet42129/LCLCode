package com.yhh.practice.sort;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class SelectSort2 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 15, 36, 26, 27, 2};
        int[] sortNums = selectSort(nums);
        for (int num :
                sortNums) {
            System.out.print(num + " ");
        }
    }

    public static int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            /*
            首先在未排序序列中找到最小的元素所在的下标
             */
            for (int j = i; j < nums.length; j++) {//未排序序列
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return nums;
    }
}
/*
最好最坏平均时间复杂度都是O(n^2)，唯一的好处是不用开辟新空间
 */
