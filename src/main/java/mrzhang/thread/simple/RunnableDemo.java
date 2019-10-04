package mrzhang.thread.simple;

/**
 * @author zhangnianlei.
 * @date 2019/6/2.
 * @description 简单的线程操作：实现Runnable接口，重写run方法
 */
public class RunnableDemo implements Runnable{

    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("thread create "+ threadName+"...");
    }

    @Override
    public void run() {
        System.out.println("running...");
        try {
            for (int i = 0; i< 10; i ++){
                System.out.println("thread " + threadName + " " + i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println("thread " + threadName + " interrupted.");
        }
        System.out.println("thread " + threadName + " exiting.");
    }


    public void start() {
        System.out.println("starting " + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
