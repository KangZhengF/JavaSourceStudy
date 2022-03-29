package com.kang.thread.threadconnect;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@State(Scope.Group)//共享
//@State(Scope.Thread)//每个线程创建一份
public class TlabTest {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(TlabTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .threads(4)
                .build();
        new Runner(opt).run();
    }
    private static class MyObject {
        volatile int myValue;
    }

    /**
     * 1. share组共享MyCount
     * 2. 每个线程创建一个MyCount
     */
    @State(Scope.Group) //44ns/op
//    @State(Scope.Thread) //11ns/op
    public static class MyCount {
        MyObject[] myObjects = new MyObject[2];
        public MyCount() {
            myObjects[0] = new MyObject();
            myObjects[1] = new MyObject();
        }
    }

    @Benchmark
    @Group("share")
    public void testA(MyCount myCount) {
        myCount.myObjects[0].myValue++;
    }

    @Benchmark
    @Group("share")
    public void testB(MyCount myCount) {
        myCount.myObjects[1].myValue++;
    }
}
