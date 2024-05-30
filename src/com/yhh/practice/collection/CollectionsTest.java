package com.yhh.practice.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author hyh
 * @date 2024/4/29
 */
public class CollectionsTest {
    public static void main(String[] args) {
/*        List<Object> list = Collections.emptyList();
        list.add("test");
        System.out.println("list = " + list);
        //UnsupportedOperationException
        */

       /* List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("Bear");
        list.add("orange");
        // 排序前:
        System.out.println(list);
        Collections.sort(list, String::compareToIgnoreCase);
        System.out.println("list = " + list);*/

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add(i);
        }
        // 洗牌前:
        System.out.println(list);
        Collections.shuffle(list);
        // 洗牌后:
        System.out.println(list);
    }
}
