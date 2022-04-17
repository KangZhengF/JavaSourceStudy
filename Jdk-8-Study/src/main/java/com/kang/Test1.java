package com.kang;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号），不允许使用String类型。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * 在完成Solution开发后，请编写单元测试 测试实现的正确性。
 */
public class Test1 {
    public static void main(String[] args) {
        //测试
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;
        int x4 = 0;
        // 会不会有其他的特殊结果呢
        //反转后超出范围 2147485647  1565847412
        int x5 = 1565847412;
        int x6 = -1565847412; // 2147485651 溢出了 -》 2147481645
        // 这两个数值不一样
        ArrayList<Integer> list = new ArrayList<>();
        list.add(solution1(x1));
        list.add(solution1(x2));
        list.add(solution1(x3));
        list.add(solution1(x4));
        list.add(solution1(x5));
        list.add(solution1(x6));
        System.out.println(list);
    }

    private static int solution1(int x) {
        int prime = x;
        int ans = 0;
        x = Math.abs(x);
        int rem;
        Deque<Integer> deque = new LinkedList<>();
        while (x > 0) {
            rem = x % 10;
            deque.addLast(rem);
            x = x / 10;
        }
        while (!deque.isEmpty()) {
            Integer pop = deque.pollFirst();
            ans = ans * 10 + pop;
            // 这里会导致溢出，在这里判断
            // 214748564 * 10 + 8 -> 溢出 ——》 变为负数
            if (ans < 0) {
                return 0;
            }
        }
        // 应该是在加上符号之前判断，ans和之前的数字不同号
        return prime < 0 ? -1 * ans : ans;
        //int 超出32位会重复循环啊，怎么解决呢？
        // 2147485647 + 1 ——》 -2147485648
        // -2147485648 - 1 -》 2147485647
        // 也就是说会发生符号转换？
    }
}
