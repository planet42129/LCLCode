package com.yhh.practice.exam.hw0515;

/**
 * @author hyh
 * @date 2024/5/15
 */
import java.util.*;

public class RouterInterfaceAllocation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetCapacity = scanner.nextInt();
        int num = scanner.nextInt();
        int[] interfaceBoards = new int[num];
        for (int i = 0; i < num; i++) {
            interfaceBoards[i] = scanner.nextInt();
        }

        // Try to find two subsets with the exact sum of targetCapacity
        Arrays.sort(interfaceBoards);
        List<Integer> firstDevice = new ArrayList<>();
        List<Integer> secondDevice = new ArrayList<>();
        if (canPartition(interfaceBoards, targetCapacity, firstDevice, secondDevice)) {
            Collections.sort(firstDevice);
            Collections.sort(secondDevice);
            printList(firstDevice);
            printList(secondDevice);
        } else {
            System.out.println("!");
        }
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    private static boolean canPartition(int[] interfaceBoards, int target, List<Integer> firstDevice, List<Integer> secondDevice) {
        int total = Arrays.stream(interfaceBoards).sum();
        if (total != 2 * target) {
            return false;
        }
        return backtrack(interfaceBoards, 0, target, firstDevice, secondDevice, 0, 0);
    }

    private static boolean backtrack(int[] interfaceBoards, int index, int target,
                                     List<Integer> firstDevice, List<Integer> secondDevice, int sum1, int sum2) {
        if (sum1 > target || sum2 > target) {
            return false;
        }
        if (index == interfaceBoards.length) {
            return sum1 == target && sum2 == target;
        }

        // Try to add current board to the first device
        firstDevice.add(interfaceBoards[index]);
        if (backtrack(interfaceBoards, index + 1, target, firstDevice, secondDevice, sum1 + interfaceBoards[index], sum2)) {
            return true;
        }
        firstDevice.remove(firstDevice.size() - 1);

        // Try to add current board to the second device
        secondDevice.add(interfaceBoards[index]);
        if (backtrack(interfaceBoards, index + 1, target, firstDevice, secondDevice, sum1, sum2 + interfaceBoards[index])) {
            return true;
        }
        secondDevice.remove(secondDevice.size() - 1);

        return false;
    }
}
/*
import java.util.*;

public class InterfaceBoardAllocator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取整机的转发能力
        int deviceCapacity = scanner.nextInt();

        // 读取接口板的数量
        int numBoards = scanner.nextInt();

        // 读取接口板的转发能力列表
        int[] boardCapacities = new int[numBoards];
        for (int i = 0; i < numBoards; i++) {
            boardCapacities[i] = scanner.nextInt();
        }

        // 调用方法计算分配结果
        List<List<Integer>> result = allocateBoards(deviceCapacity, boardCapacities);

        // 输出结果
        if (result != null) {
            for (List<Integer> boardList : result) {
                Collections.sort(boardList); // 确保按容量从小到大输出
                for (int capacity : boardList) {
                    System.out.print(capacity + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("!");
        }
    }

    // 方法：分配接口板到两台设备上
    private static List<List<Integer>> allocateBoards(int deviceCapacity, int[] boardCapacities) {
        int totalCapacity = 2 * deviceCapacity;

        // 如果接口板总转发能力不等于两台设备的总转发能力，直接返回null
        int sum = Arrays.stream(boardCapacities).sum();
        if (sum != totalCapacity) {
            return null;
        }

        // 使用动态规划（DP）进行分配
        int n = boardCapacities.length;
        boolean[][] dp = new boolean[n + 1][deviceCapacity + 1];
        dp[0][0] = true; // 初始条件

        for (int i = 0; i < n; i++) {
            for (int j = deviceCapacity; j >= boardCapacities[i]; j--) {
                for (int k = i; k >= 0; k--) {
                    if (dp[k][j - boardCapacities[i]]) {
                        dp[k + 1][j] = true;
                    }
                }
            }
        }

        // 查找第一个满足条件的分配方案
        for (int i = 0; i <= n; i++) {
            if (dp[i][deviceCapacity]) {
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                int remainingCapacity = deviceCapacity;

                for (int j = n - 1; j >= 0; j--) {
                    if (remainingCapacity >= boardCapacities[j] && dp[i - 1][remainingCapacity - boardCapacities[j]]) {
                        list1.add(boardCapacities[j]);
                        remainingCapacity -= boardCapacities[j];
                        i--;
                    } else {
                        list2.add(boardCapacities[j]);
                    }
                }

                return Arrays.asList(list1, list2);
            }
        }

        return null; // 未找到有效分配
    }
}

 */