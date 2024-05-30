package com.yhh.practice.exam.honor0516;
import java.util.*;

public class DAGExecutor {

    // 用于存储DAG中的顶点及其相邻的顶点
    static Map<Character, List<Character>> graph;

    // 存储每个顶点的入度
    static Map<Character, Integer> indegree;



    // 添加顶点到图中
    static void addVertex(char v) {
        graph.putIfAbsent(v, new ArrayList<>());
        indegree.putIfAbsent(v, 0);
    }

    // 添加有向边到图中
    static void addEdge(char from, char to) {
        graph.get(from).add(to);
        indegree.put(to, indegree.getOrDefault(to, 0) + 1);
    }

    // 构建DAG图
    static boolean buildDAG(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        String[] tasks = input.split(" ");
        graph = new HashMap<>(tasks.length);
        indegree = new HashMap<>(tasks.length);
        for (String task : tasks) {
            char from = task.charAt(0);
            char to = task.charAt(2);

            // 检查是否形成环路
            if (hasCycle(from, to)) {
                System.out.println(task + ";");
                return false;
            }

            addVertex(from);
            addVertex(to);
            addEdge(from, to);
        }
        return true;
    }

    // 判断加入新边后是否会形成环路
    static boolean hasCycle(char from, char to) {
        Set<Character> visited = new HashSet<>();
        visited.add(to);
        return dfs(from, to, visited);
    }

    static boolean dfs(char start, char current, Set<Character> visited) {
        if (!graph.containsKey(current))
            return false;

        for (char neighbor : graph.get(current)) {
            if (neighbor == start)
                return true;
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                if (dfs(start, neighbor, visited))
                    return true;
                visited.remove(neighbor);
            }
        }
        return false;
    }

    // 执行DAG任务
    static void executeDAG() {
        Queue<Character> queue = new LinkedList<>();

        // 找到所有入度为0的顶点
        for (char v : graph.keySet()) {
            if (indegree.get(v) == 0) {
                queue.offer(v);
            }
        }

        // 依次执行顶点任务
        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.print(current + ";");
            for (char neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                // 示例输入
//        String input = "A|B B|C B|D D|E";
        String input = sc.nextLine();




        // 构建DAG图
        if (buildDAG(input)) {
            // 执行DAG任务
            executeDAG();
        }
    }
}



/**
 * 算法中称有向无环图为dag(directed acyclic graph).所谓有向无环图是指：任意一条边有方向，且不存在环路的图。
 * 系统t通过dag模型组织用户编写的任务，一个dag由若干个点(vertex)和链接这些点的边（edge)组成，每个点代表用户编写任务的部分处理逻辑。
 * 系统t处理dag任务的逻辑是优先为那些不依赖任何点（vertex)的点(vertex) 任务分配资源，调度执行，一旦一个点（vertex)任务执行完毕，则将此点（vertex) 从dag图中移除，然后再寻找新的不依赖任何点（vertex)的点（vertex)执行（如有大于1个满足条件的点，系统t按
 * 用户输入先后顺序选择点执行）,直到所有点（vertex)执行完毕。
 * 请编写一段程序模拟实现系统t完成dag任务执行，接收一段用户输入任务，组织生产dag (如果输入存在非法信息， 导致任务形成有向有环图， 则识别并输出输入任务中的非法输入，例如：输入A|B;B|C;C|A;A|D，输出C|A;),然后依次执行完成dag中的任务。
 *
 * 输入描述
 * 用户输入任务
 * 输入vertex接口：(vertex间使用空格分隔）
 * 源vertex|目标vertex
 *
 * 输出描述
 * 输出dag图中任务的执行顺序
 *
 * 输出接口：(用分号;分隔）
 * Vertex(n);
 *
 * 示例 1
 *
 * 输入
 * A|B B|C B|D D|E
 *
 * 输出
 * A;B;C;D:E;
 *
 * @author hyh
 * @date 2024/5/16
 */

