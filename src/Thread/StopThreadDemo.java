package Thread;

class Thread4 implements Runnable {
    private boolean stop = false;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        for (int i = 0; ; i++) {
            if (stop) {
                break;
            }
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class StopThreadDemo {
    public static void main(String[] args) throws Exception {
        Thread4 t4 = new Thread4();
        Thread t5 = new Thread(t4);
        t5.setDaemon(true);
        t5.start();

        Thread.sleep(4000);
        //t4.setStop(true);
    }
}
