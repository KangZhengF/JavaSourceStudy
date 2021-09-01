package com.kang.collection;

import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayListTest class
 *
 * @author 康正锋
 * @date 2021/08/17
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);

        //启动类加载器
        System.out.println("启动类加载器");
        String bootClassPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootClassPath);
        //扩展类加载器
        System.out.println("扩展类加载器");
        String extPath = System.getProperty("java.ext.dirs");
        System.out.println(extPath);
        URLClassLoader extLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();
        System.out.println(Arrays.toString(extLoader.getURLs()));
        //系统类加载器
        System.out.println("系统类加载器");
        String appPath = System.getProperty("java.class.path");
        System.out.println(appPath);
        URLClassLoader systemClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        System.out.println(Arrays.toString(systemClassLoader.getURLs()));
    }
}
