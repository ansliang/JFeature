package generic;

class GenericWrapper<T> {
    private T data;

    public GenericWrapper() {
    }

    public GenericWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

public class GenericDemo {
    public void m(GenericWrapper<String>... ws) {

    }

    public static void main(String[] args) {
        GenericWrapper<String> w1 = new GenericWrapper("One");
        System.out.println("w1 " + w1.getData() + " " + w1.getData().getClass());
        GenericWrapper<Object> w2 = new GenericWrapper(new Object());
        System.out.println("w2 " + w2.getData() + " " + w2.getData().getClass());
        GenericWrapper temp = w2;
        System.out.println("temp " + temp.getData() + " " + temp.getData().getClass());
        w1 = temp;
        System.out.println("w1 " + w1.getData() + " " + w1.getData().getClass());



    }
}
