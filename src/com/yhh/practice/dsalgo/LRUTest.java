package com.yhh.practice.dsalgo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyh
 * @date 2024/5/27
 */
public class LRUTest {
    public static void main(String[] args) {
//        LinkedListLRU cache = new LinkedListLRU(4);
//        ArrayLRU cache = new ArrayLRU(4);
        LRUCache cache = new LRUCache(4);
        cache.put(11,11);
        cache.put(4,4);
        cache.put(7,7);
        cache.put(3,3);
        cache.put(1,1);
        cache.get(3);
        cache.get(11);
    }
}

/**
 * 基于链表实现LRU算法
 * <p>
 * 维护一个逻辑上“有序”的链表，把最近最久未使用的数据放在链表尾部
 * 链表的节点ListNode包括数据值val和指向下一个节点的指针next
 * <p>
 * 查询一个数据是否在LRU链表中：
 * 如果该数据不存在则返回-1
 * 如果该数据存在则将其移动到链表的表头
 * （先遍历找到该数据，将该数据从链表中删除，再创建一个新节点，从表头插入链表中）；
 * <p>
 * 添加数据时：
 * 如果当前链表大小等于LRU容量，则先删除链表表尾的元素，再将新数据插入表头
 * 如果当前链表大小小于LRU容量，则直接将新数据插入表头
 */
class LinkedListLRU {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ListNode sentinle;      //虚拟头结点

    int capacity;
    int size;

    public LinkedListLRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.sentinle = new ListNode(-1);
    }

    public int get(int value) {
        ListNode cur = sentinle;
        boolean isFounded = false;
        while (cur.next != null) {
            if (cur.next.val == value) {
                isFounded = true;
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        if (isFounded) {
            sentinle.next = new ListNode(value, sentinle.next);
        } else {
            return -1;
        }
        return value;
    }

    public void put(int value) {
        if (this.size == this.capacity) {
            ListNode cur = sentinle.next;
            ListNode pre = sentinle;
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;//删除最后一个节点
            this.size--;
            //将新节点插入表头
            sentinle.next = new ListNode(value, sentinle.next);
            this.size++;
        }
        if (this.size < this.capacity) {
            //直接将新节点插入表头
            sentinle.next = new ListNode(value, sentinle.next);
            this.size++;
        }
    }
    /*
这段代码实现了基于链表的LRU算法。
LRU（Least Recently Used）是一种缓存淘汰策略，当缓存满时，会删除最近最少使用的数据。
这段代码首先定义了一个内部类ListNode，表示链表节点，包含值val和指向下一个节点的指针next。
然后定义了LinkedListLRU类，包含一个虚拟头结点sentinle、容量capacity和当前大小size。
构造方法初始化容量和大小，并创建一个虚拟头结点。
get方法用于获取值，遍历链表查找目标值，如果找到则将该节点移动到链表头部，否则返回-1。
put方法用于插入值，如果缓存已满，则删除最后一个节点；然后将新值插入到链表头部。

整体上，这段代码实现了LRU算法的基本功能，通过链表实现了数据的存储和淘汰。
     */
}


/**
 * 基于数组实现LRU算法
 * 数组头部存储最近最久未使用的元素
 */
class ArrayLRU {
    int[] data;
    int capacity;//LRU缓存容量

    int size;


    public ArrayLRU(int capacity) {
        this.capacity = capacity;
        this.data = new int[this.capacity];
        this.size = 0;
    }

    public void put(int value) {
        if (size < this.capacity) {
            data[size] = value;
            size++;
        } else if (size == this.capacity) {
            //删除头部元素，最近最久未使用元素
            for (int i = 0; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = value;
        }
    }

    public int get(int value) {
        int valueIndex = -1;
        //遍历数组元素，查找是否存在该元素
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                valueIndex = i;
                break;
            }
        }
        if (valueIndex != -1) {//找到了
            for (int i = valueIndex; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = value;
            return value;
        } else {
            return -1;
        }
    }

}

/**
 * 基于双向循环链表和map
 * 链表尾部是最近最久未使用元素
 */
class LRUCache {
    Map<Integer, Integer> cacheMap;
    int capacity;
    Node head;
    Node tail;
    int size;

    class Node {//双向链表的节点
        Integer key;
        Node pre;
        Node next;

        public Node(Integer key) {
            this.key = key;
        }

        public Node() {
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        cacheMap = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {//查询元素：如果元素存在，则将元素移动至表头（先删再new）；如果元素不存在，则返回-1
        if (cacheMap.containsKey(key)) {
            int value = cacheMap.get(key);
            moveToHead(new Node(key));
            return value;
        }
        return -1;
    }

    /**
     * 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
     * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {//
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);//关键字 key 已经存在，则变更其数据值 value
            moveToHead(new Node(key));
        } else {//如果不存在，则向缓存中插入该组 key-value
            if (this.size == this.capacity) {//如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字
                removeTail();
            }
            addToHead(new Node(key));
            cacheMap.put(key, value);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        this.size++;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.size--;
    }

    private void removeTail() {
        cacheMap.remove(tail.key);
        Node preTail = tail.pre;
        preTail.next = null;
        tail = preTail;
        this.size--;
    }


}

/*
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node dummyHead;
    Node tail;

    public DoublyLinkedList() {
        this.dummyHead = new Node(-1); // 虚拟头结点
        this.tail = dummyHead;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = dummyHead.next;
        if(dummyHead.next != null) {
            dummyHead.next.prev = newNode;
        }
        dummyHead.next = newNode;
        newNode.prev = dummyHead;
    }

    public void display() {
        Node current = dummyHead.next; // 从第一个真实节点开始遍历
        if (current == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);

        dll.insertAtHead(0);

        dll.display();
    }
}
 */