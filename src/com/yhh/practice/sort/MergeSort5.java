package com.yhh.practice.sort;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class MergeSort5 {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] sortArr = mergeSort(arr);
        for (int num :
                sortArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        //左闭右闭区间
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int[] mergeSort(int[] nums, int left, int right) {
        int[] res = new int[nums.length];
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            res = merge(nums, left, mid, right);
        }
        return res;
    }

    private static int[] merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//临时数组用来存放合并后的结果
        int index = 0;//临时数组的指针
        int i = left;//左半部分的指针
        int j = mid + 1;//右半部分的指针

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= right) {
            temp[index++] = nums[j++];
        }
        return temp;
    }
}
