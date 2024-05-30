package com.yhh.practice.dsalgo;

/**
 * @author hyh
 * @date 2024/5/30
 */
public class ArrayStack {
    int[] data;
    int size;
    int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.data = new int[this.maxSize];
    }

    public void push(int val) {
        if (this.size == this.maxSize) {//扩容
            int capacity = (int)(this.maxSize * 1.5);
            int[] newData = new int[capacity];
            for (int i = 0; i < newData.length; i++) {
                if (i == this.maxSize) {
                    break;
                }
                newData[i] = this.data[i];
            }
            this.data = newData;
            this.maxSize = capacity;
        }
        this.data[this.size] = val;
        this.size++;
    }

    public int pop() {
        int res = this.data[this.size - 1];
        this.size--;
        return res;
    }

    public int peek() {
        int res = this.pop();
        this.push(res);
        return res;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        int pop = arrayStack.pop();
        System.out.println("pop = " + pop);
        arrayStack.push(11);
        int peek = arrayStack.peek();
        System.out.println("peek = " + peek);
        arrayStack.push(12);
    }
}
