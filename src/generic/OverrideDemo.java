package generic;

public class OverrideDemo {
}

class Parent<T> {
    public void test(T t) {
    }
}

class Son extends Parent<String> {
    @Override
    public void test(String s) {
        super.test(s);
    }
}