package mrzhang.thread.simple;

/**
 * @author zhangnianlei.
 * @date 2019/6/3.
 * @description 使用继承Thread类的方法：重写run()方法和start()方法，该方法是线程的入口点，必须调用start()方法才能调用
 *
 * 运行顺序：构造函数 - start()方法 - run()方法
 *
 * run()方法与start()方法的区别：
 */
public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("create " + threadName);
    }

    @Override
    public void run(){
        System.out.println("run " + threadName);
        try {
            for (int i = 0; i< 4; i++){
                System.out.println(threadName + " " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("thread " + threadName + "interrupted.");
        }
        System.out.println(threadName + "exiting.");
    }

    @Override
    public void start() {
        System.out.println("start " + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
