package com.yhh.practice.dsalgo;

import java.util.*;

/**
 * 中缀表达式求值
 * Ref：08 | 栈：如何实现浏览器的前进和后退功能？
 *
 * @author hyh
 * @date 2024/5/31
 */
public class StackExpression {
    Deque<Integer> numberStack;//存放操作数的栈
    Deque<String> operatorStack;//存放运算符的栈， + - * /

    Map<String, Integer> priorityMap;//存放运算符优先级的Map

    public StackExpression() {
        this.numberStack = new ArrayDeque<>();
        this.operatorStack = new ArrayDeque<>();
        priorityMap = new HashMap<>();
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
    }

    /**
     * 返回0，优先级相同
     * 返回负数， key1的优先级低于key2
     * 返回正数，key1的优先级高于key2
     *
     * @param key1
     * @param key2
     * @return
     */
    private int comparePriority(String key1, String key2) {
        return priorityMap.get(key1) - priorityMap.get(key2);
      /*
        switch(key) {
            case "+":
            case "-":
                return 1;
                break;
            case "*":
            case "/":
                return 2;
                break;
            default:
                return 0;
        }*/
    }

    public int evaluate(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isDigit(token)) {
                numberStack.push(Integer.valueOf(token));
            } else if ("+".equals(token) || "-".equals(token)
                    || "*".equals(token) || "/".equals(token)) {//遇到运算符
                // 处理当前运算符
                // 与栈顶元素进行比较,当前运算符的优先级小于等于栈顶元素的优先级时
                while (!operatorStack.isEmpty()
                        && comparePriority(token, operatorStack.peek()) <= 0) {
                    calculate(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }
        //处理剩余的运算符
        while (!operatorStack.isEmpty()) {
            calculate(operatorStack.pop());
        }
        return numberStack.pop();
    }

    private boolean isDigit(String s) {
        try {
            Integer number = Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void calculate(String operator) {
        Integer right = numberStack.pop();//以除法为例，这是除数
        Integer left = numberStack.pop();//这是被除数
        int curResult = 0;
        //可以用switch
        if ("+".equals(operator)) {
            curResult = right + left;
        } else if ("-".equals(operator)) {
            curResult = left - right;
        } else if ("*".equals(operator)) {
            curResult = right * left;
        } else if ("/".equals(operator)) {
            curResult = left / right;
        }
        numberStack.push(curResult);
    }


    public static void main(String[] args) {
        StackExpression stackExpression = new StackExpression();
        String[] tokens = {"3", "+", "5", "*", "8", "-", "6"};
        int actual = stackExpression.evaluate(tokens);
        System.out.println("actual = " + actual);
    }

}
