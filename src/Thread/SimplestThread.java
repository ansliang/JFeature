package Thread;

public class SimplestThread {
    public static void main(String[] args) {
        Thread simplestThread = new Thread();
        simplestThread.start();
        System.out.println(simplestThread.getState());


        ThreadGroup tg1 = new ThreadGroup("ThreadGroup");
        Thread t1 = new Thread(tg1, "thread1");
    }
}
