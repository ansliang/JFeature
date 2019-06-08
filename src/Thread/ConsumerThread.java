package Thread;

public class ConsumerThread implements Runnable{
    private Resource resource;

    public ConsumerThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run(){
        for(int i=0; i<10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.decrease();
        }
    }
}