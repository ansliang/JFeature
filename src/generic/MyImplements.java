package generic;

public class MyImplements<T> implements GenericInterface<T> {
    @Override
    public T test(T t) {
        return t;
    }

    public static void main(String[] args) {
        MyImplements<String> m = new MyImplements<>();
        String s = m.test("myimplements");
    }
}
