package com.yhh.practice.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hyh
 * @date 2024/4/26
 */
public class Map1 {
    public static void main(String[] args) {
/*    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 123);
    map.put("pear", 456);
    System.out.println(map.get("apple")); // 123
    Integer oldValue = map.put("apple", 789);// 再次放入apple作为key，但value变为789
    // 如果给相同的key通过put()放入了新的value，此时put()可以返回这个key原来的value
    System.out.println(map.get("apple")); // 789
    System.out.println(oldValue); // 123
    // 在一个map中，key不能重复，但value可以重复*/


        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);

/*        //遍历key，通过map实例的keySet()方法
        for (String key : map.keySet()) {
            Integer value = map.get(key);//再通过key获取value
            System.out.println(key + " = " + value);
        }*/

        //要同时遍历key value，通过map实例的entrySet()方法
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry);  //输出的是 key=value 的形式
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }

    }
}
