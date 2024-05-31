package com.yhh.practice.nowcoder;

/**
 * 先解决push pop top min的问题
 * 再解决处理输入输出的问题
 *
 * @author hyh
 * @date 2024/5/31
 */
public class StackJZ30 {
    private int[] data;//顺序栈
    private int capacity;//栈的容量
    private int size;//栈当前的大小

    private int min;
    private final static int INIT_CAPACITY = 10;

    public StackJZ30() {
        this.capacity = INIT_CAPACITY;
        this.size = 0;
        this.data = new int[this.capacity];
        this.min = Integer.MAX_VALUE;
    }


    public void push(int node) {
        if (this.size == this.capacity) {//扩容
            int newCapacity = (int)(INIT_CAPACITY * 1.5);
            int[] newData = new int[newCapacity];
            for (int i = 0; i < this.capacity; i++) {
                newData[i] = this.data[i];
            }
            this.capacity = newCapacity;
            this.data = newData;
        }
        if (node < this.min) {
            this.min = node;
        }
        this.data[size] = node;
        this.size++;
    }

    public void pop() {
//        int res = this.data[this.size - 1];
        this.size--;
    }

    public int top() {
        int res = this.data[this.size - 1];
        return res;
    }

    /**
     * 维护一个成员变量min，后续需要获取栈中的最小数据的时候直接返回即可
     * push数据的时候，就维护min
     * pop()也需要维护min
     * @return
     */
    public int min() {
        return this.min;
    }

}
