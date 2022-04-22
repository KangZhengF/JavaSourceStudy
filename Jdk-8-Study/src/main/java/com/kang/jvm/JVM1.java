package com.kang.jvm;

/**
 * JVM1 class
 *
 * @author 康正锋
 * @date 2022/04/13
 */
public class JVM1 {
    public static void main(String[] args) {
        // javac 然后javap -v反编译，使用jclasslib查看字节码。
        int i = 11;
        int j = 12;
        int k = i + j;
        System.out.println(k);
    }


}
