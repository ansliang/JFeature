package Thread;

public class Resource {
    private int num = 0;

    public synchronized void increase(){
        while(num != 0) {
            try {
                wait(); //等待
                System.out.println("increase wait()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        notify();       //唤醒
        System.out.println("increase notify()");
        System.out.println("当前资源数：" + num);
    }

    public synchronized void decrease(){
        while(num==0) {
            try {
                wait(); //等待
                System.out.println("decrease wait()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        notify();       //唤醒
        System.out.println("decrease notify()");
        System.out.println("当前资源数：" + num);
    }
}
