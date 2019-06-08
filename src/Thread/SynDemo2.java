package Thread;

public class SynDemo2 {
    public void m1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A:" + i);
            }
        }
    }

    public void m2() {
        synchronized ("") {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B:" + i);
            }
        }
    }

    public static void m3() {
        synchronized ("") {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C:" + i);
            }
        }
    }

    public static void main(String[] args) {
        SynDemo2 d = new SynDemo2();
        new Thread(d::m1).start();
        new Thread(d::m2).start();
        new Thread(SynDemo2::m3).start();
    }
}