package com.yhh.practice.collection;

import java.util.*;

/**
 * 1、创建List的三种方式
 * new ArrayList()            允许重复元素，接受null值
 * new LinkedList()           允许重复元素，接受null值
 * List.of("apple","banana")  允许重复元素，不接受null值
 * <p>
 * 2、遍历方式
 * 不推荐get(index),get(index)只有List是ArrayList的时候访问速度才快
 * 推荐Iterator，访问效率高，for each遍历会帮我们使用Iterator遍历
 * <p>
 * 3、List转Array的三种方式
 * 3.1 Object[] objects = list.toArray(),返回值是一个对象数组，丢失的信息多
 * 3.2 T[] arrays = list.toArray(T[]),传入一个相同类型的数组，List内部自动把元素复制到传入的数组中
 * 例如：String[] strings = list.toArray(new String[3]);
 * 3.3  String[] arrays = list.toArray(String[]::new);
 *
 * 4、Array转List的方式
 * 4.1 List.of(arr),但是这种方法返回的List是只读的，
 * 对只读List调用add()、remove()方法会抛出UnsupportedOperationException
 * 4.2 Arrays.asList(arr),JDK11之前的版本
 * @author hyh
 * @date 2024/4/26
 */
public class List1 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();
        list.add("apple");
        list.add("apple");
        list.add("null");

/*
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/


        /*
        通过list实例的iterator()方法来获取Iterator对象it，
        通过对象it的boolean hasNext()方法判断是否有下一个元素
        通过对象it的E next()方法返回元素
        iterator()方法会根据不同的List类型返回不同的对象实现，但总是拥有最高的访问效率
         */
      /*  for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }*/

        // for each的遍历形式是Iterator的简化形式
/*        for (String s : list) {
            System.out.println(s);
        }*/

        // List变为Array的三种方法
/*
        Object[] objects = list.toArray();
        for (Object o:
             objects) {
            System.out.println(o);
        }
*/

/*        String[] strings = list.toArray(new String[3]);
        for (String s:
             strings) {
            System.out.println(s);
        }*/


/*        String[] arrays = list.toArray(String[]::new);
        for (String s:
             arrays) {
            System.out.println(s);
        }*/

        // Array变List的方法
        Integer[] intArr = {1, 2, 3};
        List<Integer> intList1 = List.of(intArr);//但是这种方法返回的list是只读的

        List<Integer> intList2 = Arrays.asList(intArr);

    }
}
