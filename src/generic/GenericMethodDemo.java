package generic;

public class GenericMethodDemo<T> {
    public <V> GenericMethodDemo(V v) {

    }

    public <V> GenericMethodDemo() {

    }

    public <V> T m(V v, T t) {
        System.out.println("Demo.m().");
        return (T) v;
    }

    public static void main(String[] args) {
        GenericMethodDemo<String> g1 = new GenericMethodDemo<>();
        GenericMethodDemo<String> g = new GenericMethodDemo<>(20);
        g1.m(new Integer(100), "String");

        GenericMethodDemo g2 = new GenericMethodDemo();
        System.out.println(g2.<Object>m(new Integer(200), "1").getClass());
    }
}

class GenericMethodDemo1 {
    public <V> Integer m(V v) {
        System.out.println("Demo1.m().");
        return 1;
    }
}

class GenericMethodDemo2<T> {
    public static <V> void m(V v) {
    }
}