package Lambda;

public interface FuncInterface<T> {
    T m(T t);
}

interface FuncInterface1 {
    <T> T m(T t);
}

class TestFunInterface {
    void test() {
        FuncInterface<String> f1 = t -> t + "abc";
        //FuncInterface1 f2 = t -> t + "abc";

        MarkeInterface mi = (MarkeInterface & FuncInterface) t -> t + "abc";
    }
}


interface MarkeInterface {

}
