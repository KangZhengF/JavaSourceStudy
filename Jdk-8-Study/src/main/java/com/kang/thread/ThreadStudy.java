package com.kang.thread;

/**
 * @author 康正锋
 * @date 2021-11-02 23:18:09
 */
public class ThreadStudy {
    public static void main(String[] args) {
        UseMyFunctionInterface useMyFunctionInterface = new UseMyFunctionInterface(() ->
                System.out.println("这是我自己写的函数式接口"));
        useMyFunctionInterface.apply();
    }

    /**
     * 自己写的使用函数式接口的示例
     */
    static class UseMyFunctionInterface {
        private MyFunctionInterface myFunctionInterface;

        public UseMyFunctionInterface() {
        }

        public UseMyFunctionInterface(MyFunctionInterface myFunctionInterface) {
            this.myFunctionInterface = myFunctionInterface;
        }

        public void setMyFunctionInterface(MyFunctionInterface myFunctionInterface) {
            this.myFunctionInterface = myFunctionInterface;
        }

        public void apply() {
            if (this.myFunctionInterface != null) {
                myFunctionInterface.method1();
            }
        }
    }
}
