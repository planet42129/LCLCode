package com.yhh.practice.exam.mt0420;

import java.util.*;

public class MT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 树的节点数量
        int[] values = new int[n]; // 存储每个节点的权值
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        // 构建邻接表表示树的连接关系
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 记录路径权值乘积是完全平方数的数量
        int[] count = new int[1];

        // 从每个节点开始深度优先搜索
        for (int i = 1; i <= n; i++) {
            dfs(graph, values, i, 1, count, new HashSet<>());
        }

        System.out.println(count[0] / 2); // 由于路径是双向的，所以要除以 2
    }

    private static void dfs(List<List<Integer>> graph, int[] values, int node, int product, int[] count, Set<Integer> visited) {
        // 计算当前节点的权值乘积
        product *= values[node - 1];

        // 检查当前乘积是否为完全平方数
        int sqrt = (int) Math.sqrt(product);
        if (sqrt * sqrt == product) {
            count[0]++;
        }

        // 将当前节点标记为已访问
        visited.add(node);

        // 遍历当前节点的邻居节点
        for (int neighbor : graph.get(node)) {
            // 避免重复访问已经访问过的节点
            if (!visited.contains(neighbor)) {
                dfs(graph, values, neighbor, product, count, visited);
            }
        }

        // 回溯，将当前节点标记为未访问
        visited.remove(node);
    }
}
