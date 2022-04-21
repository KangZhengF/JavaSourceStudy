package com.kang.thread.threadconnect;

import java.util.Arrays;
import java.util.HashMap;

public class SelfIntro {
    public static void main(String[] args) {
        String a = "11,12,,14,,17,";
//        String a = "276242161";
        String[] split = a.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(Arrays.toString(split));
        /*
        自我介绍：面试官下午好，首先感谢贵司提供的面试机会。
        我叫康正锋，毕业于重庆师范大学物理学专业。
        毕业后在格力电商公司从事Java开发，一直都做的重构老系统相关的项目。
        主要业务类型都是电商方面的，公司项目技术栈就是简历上的那些。
        第一个项目中主要是学习和摸索，第二个项目中开始独立的写一些功能。
        感谢面试官的聆听，我的自我介绍完毕
         */
    }
}
