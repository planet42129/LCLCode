package com.yhh.practice.collection;

import java.util.List;
import java.util.Objects;

/**
 * @author hyh
 * @date 2024/4/26
 */
public class List2 {
    public static void main(String[] args) {
/*        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains(new String("C"))); // true or false?
        System.out.println(list.indexOf(new String("C"))); // 2 or -1?*/
        // true 2
        //List的contains()和indexOf()是依赖equals()方法来判断的，而String、Integer等的equals()方法已经重写过了，
        //会比较值是否相等


        List<Person> list = List.of(
                new Person("Xiao Ming"),
                new Person("Xiao Hong"),
                new Person("Bob")
        );
        System.out.println(list.contains(new Person("Bob"))); // 如果没有重写equals方法则返回false
        System.out.println(list.indexOf(new Person("Bob"))); // 如果没有重写equals方法则返回-1

    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    //如果obj是Person类的实例，或是Person类的子类的实例，返回true，否则返回false
    // 但是这个方法如果this.name为空，就会报错
/*    @Override
    public boolean equals(Object obj) {
       if (obj instanceof  Person p) {
           return this.name.equals(p.name);
       }
       return false;
    }*/

   /* @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Person p) {
            boolean nameEquals = false;
            if (this.name == null && p.name == null) {
                nameEquals = true;
            }
            if (this.name != null) {
                nameEquals = this.name.equals(p.name);
            }
            return nameEquals;
        }
        return false;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person p) {
            return Objects.equals(this.name, p.name);
        }
        return false;
    }
}