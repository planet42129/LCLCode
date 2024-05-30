package com.yhh.practice.dsalgo;

/**
 * @author hyh
 * @date 2024/5/29
 */
public class DoubledList {
    class Node {
        int val;
        Node pre;
        Node next;

        Node(int val) {
            this.val = val;
            this.pre = null;
            this.next = null;
        }
        Node() {

        }
    }
    Node dummyHead;
    Node tail;
    DoubledList(){

        dummyHead = new Node(-1);
        tail = new Node();
    }

public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummyHead.next;
        if (dummyHead.next != null) {
            dummyHead.next.pre = newNode;
            dummyHead.next = newNode;
        }
        newNode.pre = dummyHead;
    }


    public void addAtTail(int val) {
        Node newNode = new Node(val);
        tail.next = newNode;
        newNode.pre = tail;
        tail = newNode;
    }

    public void removeByNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void removeByVal(int val) {

        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }


    public static void main(String[] args) {
        DoubledList doubledList = new DoubledList();
        doubledList.addAtHead(1);
        doubledList.addAtHead(2);
        doubledList.addAtTail(31);
        doubledList.addAtTail(22);
    }

}
