package Thread;

public class InterrupterDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t1.interrupt();
        System.out.println(t1.interrupted());           //false
        System.out.println(t1.isInterrupted());         //true
    }
}
