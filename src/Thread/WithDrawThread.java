package Thread;

public class WithDrawThread implements Runnable{
    private Account account;

    public WithDrawThread(Account account){
        this.account = account;
    }

    @Override
    public void run(){
        account.withdraw(300);
    }
}
