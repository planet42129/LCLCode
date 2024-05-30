package com.yhh.practice.collection;

import java.util.*;

/**
 * @author hyh
 * @date 2024/4/27
 */
public class SetTest {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {

        //报错
/*        Set<Integer> set = new HashSet<>();
        Iterator<Message> iterator = received.iterator();
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            if (set.contains(msg.sequence)) {
//                received.remove(msg);
                iterator.remove(); // Safely remove the current element from the list
            } else {
                set.add(msg.sequence);
            }
        }
        return received;*/

        //这个代码报错
        /*for (Message msg: received) {
            if (set.contains(msg.sequence)) {
                received.remove(msg);
            } else {
                set.add(msg.sequence);
            }
        }
        */
        //成功
        Set<Message> set = new TreeSet<>((o1, o2)->{
            return o1.sequence - o2.sequence;
        });
        set.addAll(received);
        ArrayList<Message> messages = new ArrayList<>();
        for (Message s:
             set) {
            messages.add(s);
        }
        return messages;
    }
}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}

