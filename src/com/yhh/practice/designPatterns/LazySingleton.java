package com.yhh.practice.designPatterns;

/**
 * @author hyh
 * @date 2024/4/26
 */
public class LazySingleton<T> {
    private static volatile LazySingleton<?> instance;

    private LazySingleton() {
    }

    public static <T> LazySingleton<T> getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton<>();
                }
            }
        }
        return (LazySingleton<T>) instance;
    }
}
