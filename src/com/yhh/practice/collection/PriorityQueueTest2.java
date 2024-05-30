package com.yhh.practice.collection;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hyh
 * @date 2024/4/29
 */
public class PriorityQueueTest2 {
    public static void main(String[] args) {
        Queue<User1> q = new PriorityQueue<User1>();
        q.offer(new User1("Bob", "A1"));
        q.offer(new User1("Alice", "A2"));
        q.offer(new User1("Ama", "A10"));
        q.offer(new User1("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}


class User1 implements Comparable<User1>{
    private String name;
    private String number;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public User1(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public User1() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public int compareTo(User1 o) {
        if (this.getNumber().charAt(0) == o.getNumber().charAt(0)) {
            return Integer.parseInt(this.getNumber().substring(1))
                    - Integer.parseInt(o.getNumber().substring(1));
        }
        if (this.getNumber().charAt(0) == 'V') {
            return -1;
        }
        return 1;
    }
}