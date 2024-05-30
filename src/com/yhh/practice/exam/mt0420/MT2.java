package com.yhh.practice.exam.mt0420;

import java.util.Scanner;

public class MT2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int q = scanner.nextInt(); // 询问次数
    scanner.nextLine(); // 消耗换行符

    for (int i = 0; i < q; i++) {
      int n = scanner.nextInt(); // 字符串长度
      int k = scanner.nextInt(); // 操作次数
      scanner.nextLine(); // 消耗换行符

      String s = scanner.nextLine(); // 字符串s
      String t = scanner.nextLine(); // 字符串t

      if (canTransform(s, t, k)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
    scanner.close();
  }

  // 判断是否可以通过恰好k次操作将s变为t
  private static boolean canTransform(String s, String t, int k) {
    int diffCount = 0;
    for (int i = 0; i < s.length(); i++) {
      int diff = Math.abs(s.charAt(i) - t.charAt(i));
      if (diff > 0) {
        // 计算需要操作的次数，考虑循环差值
        diff = Math.min(diff, 26 - diff);
      }
      diffCount += diff;
    }
    return diffCount <= k && (k - diffCount) % 26 == 0; // 检查剩余的操作次数是否能用于循环操作
  }
}
