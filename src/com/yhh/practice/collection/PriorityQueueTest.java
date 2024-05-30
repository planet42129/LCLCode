package com.yhh.practice.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hyh
 * @date 2024/4/29
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<User>(new UserComparator());
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Ama", "A10"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {


    @Override
    public int compare(User o1, User o2) {
        if (o1.getNumber().charAt(0) == o2.getNumber().charAt(0)) {
//            String o1Number = o1.getNumber().substring(1);
//            String o2Number = o2.getNumber().substring(1);
//            int n1 = Integer.parseInt(o1Number);
//            int n2 = Integer.parseInt(o2Number);
//            return n1 - n2;

            return Integer.valueOf(o1.getNumber().substring(1)).compareTo(Integer.valueOf(o2.getNumber().substring(1)));
        }
        if (o1.getNumber().charAt(0) == 'V') {
            return -1;
        }
        return 1;
    }
}

class User {
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

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}