package com.kang.thread.threadconnect;

public class CacheTest {
    public static void main(String[] args) {
        int n = 2048;
        long start = System.currentTimeMillis();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                a[i][j] = 1;//按行赋值 30-35ms
                a[j][i] = 1;//按列赋值 110ms以上
            }
        }
        System.out.println("time ====" + (System.currentTimeMillis() - start));
    }
}
