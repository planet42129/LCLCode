package com.yhh.practice.exam.mt0420;

/**
 * @author hyh
 * @date 2024/4/20
 */
import java.util.Scanner;

public class StringTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Number of queries

        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            String s = scanner.next();
            String t = scanner.next();

            System.out.println(canTransform(s, t, k) ? "Yes" : "No");
        }

        scanner.close();
    }

    private static boolean canTransform(String s, String t, long k) {
        long totalOperations = 0;

        for (int i = 0; i < s.length(); i++) {
            int distance = (t.charAt(i) - s.charAt(i) + 26) % 26;
            totalOperations += distance;
        }

        // Check if total operations is exactly k or k minus a multiple of 26 (since 'z' to 'a' can cycle)
        return totalOperations == k || (totalOperations < k && (k - totalOperations) % 26 == 0);
    }
}

