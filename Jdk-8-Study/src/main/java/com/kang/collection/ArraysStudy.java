package com.kang.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 康正锋
 * @date 2021-10-14 22:47:40
 */
public class ArraysStudy {
//    public static void main(String[] args) {
//        //注意修改数组元素的结果
//        String[] arr = {"a", "b", "c"};
//        List<String> list = Arrays.asList(arr);
//        ArrayList<String> arrayList = new ArrayList<>(list);
//        System.out.println("修改前");
//        System.out.println("list=" + list);
//        System.out.println("arrayList" + arrayList);
//        arr[0] = "d";
//        System.out.println("修改后");
//        System.out.println("list=" + list);
//        System.out.println("arrayList" + arrayList);
//    }
    public static void main(String[] args) {
        //不支持增删改操作
//        List<String> list = Arrays.asList("a", "b", "c");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            if (Objects.equals("a", s)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(list);
        int[] array = {1, 2, 3};
        List<int[]> ints = Arrays.asList(array);
        System.out.println(ints.size());//size=1
        System.out.println(ints.get(0));//是一个int类型数组对象的地址值
        System.out.println(ints.get(0).getClass());//int[]
        System.out.println(ints.get(0)[0]);//实际上是array[0]的值
    }
}
