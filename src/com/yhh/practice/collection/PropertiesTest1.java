package com.yhh.practice.collection;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author hyh
 * @date 2024/4/27
 */
public class PropertiesTest1 {
    public static void main(String[] args) throws IOException {
        // 1、从文件系统中读取
        /*
        1.1 创建Properties实例
        1.2 调用load读取输入流
        1.3 调用getPrpperty(key)
         */
        Properties props = new Properties();
        String filePath = "D://Code_Projects//Java Projects//LCCode//src//com//yhh//practice//collection//test.properties";
        props.load(new FileInputStream(filePath));
//        props.load(new FileReader(filePath), StandardCharsets.UTF_8);
        String username = props.getProperty("username");
        System.out.println("username = " + username);
        String password = props.getProperty("password");
        System.out.println("password = " + password);

        props.setProperty("url", "https://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.store(new FileOutputStream(filePath), "写入时的注释");


/*
        Properties prop = new Properties();
        String filePath = "test.properties";
        prop.load(PropertiesTest1.class.getResourceAsStream(filePath));
        String name = prop.getProperty("name");
        System.out.println("name = " + name);
        String password = prop.getProperty("password");
        System.out.println("password = " + password);*/

    }
}
