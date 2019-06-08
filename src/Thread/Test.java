package Thread;

public class Test {
    public static void main(String[] args) {
        Resource r = new Resource();


        ProductorThread p1 = new ProductorThread(r);
        new Thread(p1).start();
        ProductorThread p2 = new ProductorThread(r);
        new Thread(p2).start();
        ProductorThread p3 = new ProductorThread(r);
        new Thread(p3).start();

        ConsumerThread c1 = new ConsumerThread(r);
        new Thread(c1).start();
        ConsumerThread c2 = new ConsumerThread(r);
        new Thread(c2).start();
    }
}
