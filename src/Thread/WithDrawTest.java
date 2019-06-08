package Thread;

public class WithDrawTest {
    public static void main(String[] args) {
        Account account = new Account();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new WithDrawThread(account));
            t1.start();


        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getMoney());
    }
}
