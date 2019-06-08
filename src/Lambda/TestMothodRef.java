package Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface ToInt<T> {
    int convert(T t);
}

class Parent {
    void m(){}
}

class Son extends Parent {

}

public class TestMothodRef {
    public static void main(String[] args) {
       /* ToInt<String> t1 = s -> s.length();
        System.out.println(t1.convert("Tom"));*/
        ToInt<String> t1 = Integer::parseInt;
        System.out.println(t1.convert("123"));  //123

        Supplier<Integer> s1 = "Jack"::length;
        System.out.println(s1.get());              //4

        Consumer<String> s2 = System.out::print;

        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("Rose and Jack"));  //13

        Son son = new Son();
        son.m();

        Supplier<Son> son1 = Son::new;
        Son s = son1.get();

    }
}
