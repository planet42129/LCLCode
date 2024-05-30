package com.yhh.practice.sort;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 15, 36, 26, 27, 2};
        int[] sortNums = bubbleSort(nums);
        for (int num :
                sortNums) {
            System.out.print(num + " ");
        }
    }

    public static int[] bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) { //控制遍历的终止位置
            boolean flag = true;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return nums;
    }
}
/*
    public static int[] bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) { //控制遍历的终止位置
//            第一轮： [0, nums.length - 1], j最大为nums.length - 2
//            第二轮： [0, nums.length - 2]
            boolean flag = true;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            //如果上一轮次都没有交换过元素，说明此时数组已经有序，直接break结束循环
            if (flag) break;
        }
        return nums;
    }


    */
