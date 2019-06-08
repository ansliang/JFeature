package generic;

class Wrapper {
    private Object data;

    public Wrapper(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class NoGenericDemo {
    public static void main(String[] args) {
        Wrapper w1 = new Wrapper("One");
        Wrapper w2 = new Wrapper(new Integer(100));
        Wrapper w3 = new Wrapper(1);

        String d1 = (String)w1.getData();
        //Integer d2 = (Integer)w1.getData(); WRONG
    }
}
