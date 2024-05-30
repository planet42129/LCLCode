package com.yhh.practice.designPatterns;

/**
 * @author hyh
 * @date 2024/5/24
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {}

    public DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
