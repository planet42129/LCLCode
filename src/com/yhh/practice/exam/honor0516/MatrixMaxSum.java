package com.yhh.practice.exam.honor0516;

import java.util.Scanner;

/**
 * @author hyh
 * @date 2024/5/16
 */
public class MatrixMaxSum {
    public static void main(String[] args) {
/*        // 示例输入
        int n = 2;
        int m = 3;
        String matrixStr = "[1 2 3;4 5 6]";*/

        Scanner scanner = new Scanner(System.in);

        // 读取矩阵行数和列数
        int n = Integer.parseInt(scanner.nextLine());

        int m = Integer.parseInt(scanner.nextLine());
        String matrixStr = scanner.nextLine();


        // 解析输入的矩阵字符串
        int[][] matrix = parseMatrix(matrixStr, n, m);

        // 计算最大路径和
        int maxSum = maxPathSum(matrix);

        // 输出结果
        System.out.println(maxSum);
    }

    // 动态规划计算最大路径和
    private static int maxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 初始化 dp 数组，第一行和第一列直接取矩阵的值
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // 动态规划填充 dp 数组
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        // dp[n-1][m-1] 存储的就是最大路径和
        return dp[n - 1][m - 1];
    }

    // 解析输入的矩阵字符串为 int[][] 形式
    private static int[][] parseMatrix(String matrixStr, int n, int m) {
        matrixStr = matrixStr.substring(1, matrixStr.length() - 1); // 去掉外层的方括号
        String[] rows = matrixStr.split(";");
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }
        return matrix;
    }

}
