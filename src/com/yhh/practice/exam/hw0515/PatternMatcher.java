package com.yhh.practice.exam.hw0515;

/**
 * @author hyh
 * @date 2024/5/15
 */
import java.util.*;
import java.util.regex.*;

public class PatternMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String target = scanner.nextLine();

        String regex = convertPatternToRegex(pattern);
        Pattern compiledPattern = Pattern.compile(regex);
        Matcher matcher = compiledPattern.matcher(target);

        if (matcher.find()) {
            System.out.println(matcher.group());
        } else {
            System.out.println("!");
        }
    }

    private static String convertPatternToRegex(String pattern) {
        StringBuilder regex = new StringBuilder();
        Deque<Integer> repeatStack = new LinkedList<>();
        Deque<StringBuilder> patternStack = new LinkedList<>();
        StringBuilder currentPattern = new StringBuilder();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
                    i++;
                }
                int repeatCount = Integer.parseInt(pattern.substring(start, i));
                repeatStack.push(repeatCount);
                i--; // Adjust for the loop increment
            } else if (c == '(') {
                patternStack.push(currentPattern);
                currentPattern = new StringBuilder();
            } else if (c == ')') {
                int repeatCount = repeatStack.pop();
                String repeatedPattern = currentPattern.toString();
                currentPattern = patternStack.pop();
                currentPattern.append("(?:").append(repeatedPattern).append("){").append(repeatCount).append("}");
            } else {
                if (c == 'N') {
                    currentPattern.append("[0-9]");
                } else if (c == 'A') {
                    currentPattern.append("[A-Za-z]");
                }
            }
        }
        regex.append(currentPattern);
        return regex.toString();
    }
}

