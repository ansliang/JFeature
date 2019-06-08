package Thread;

class Thread1 extends Thread {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1: " + i + "," + num);
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2: " + i);
        }
    }
}

public class ThreadDemo {

    static void print() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread4: " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        Thread1 t1 = new Thread1();
        t1.setNum(100);
        t1.start();

        Runnable r2 = new Thread2();
        Thread t2 = new Thread(r2);
        t2.start();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread3: " + i);
            }
        });
        t3.start();

        Thread t4 = new Thread(ThreadDemo::print);
        t4.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            System.out.println("Main: " + i);
        }
    }
}
