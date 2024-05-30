package com.yhh.practice.designPatterns;

/**
 * 懒汉式单例模式: 在需要时才创建实例，可以节省内存。
 * 然而，在多线程环境下可能会有线程安全问题，
 * 可以使用双重检查锁定（double-checked locking）或者静态内部类来解决。
 * @author hyh
 * @date 2024/4/26
 */
public class Singleton {
    //私有静态成员变量，用于存储唯一的实例
    private static Singleton instance;

    //私有的构造方法，防止外部实例化
    private Singleton() {

    }

    //公共静态方法，用于获取实例
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}

//饿汉式单例模式在类加载时就创建实例，因此在多线程环境下不需要额外的同步措施，可以保证线程安全。
//instance 静态变量在类加载时就被初始化，因此在任何时候调用 getInstance 方法都可以得到同一个实例。
/*public class Singleton {
    // 私有静态成员变量，在类加载时即创建实例
    private static Singleton instance = new Singleton();

    // 私有构造方法，防止外部实例化
    private Singleton() {
    }

    // 公共静态方法，用于获取实例
    public static Singleton getInstance() {
        return instance;
    }
}*/
