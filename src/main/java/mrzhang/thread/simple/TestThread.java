package mrzhang.thread.simple;

/**
 * @author zhangnianlei.
 * @date 2019/6/3.
 * @description 运行测试类
 */
public class TestThread {
    public static void main(String[] args) {
//        runableDemoTest();
        threadDemoTest();
    }

    /**
     * 测试继承Thread的方法
     */
    private static void threadDemoTest() {
        ThreadDemo t1 = new ThreadDemo("zhang");
        t1.start();

        ThreadDemo t2 = new ThreadDemo("ding");
        t2.start();
    }

    /**
     * 测试实现Runnable接口的方法
     */
    private static void runableDemoTest() {
        RunnableDemo r1 = new RunnableDemo("zhang");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("ding");
        r2.start();
    }
}
