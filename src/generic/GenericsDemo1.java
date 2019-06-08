package generic;

class Wrapper1<T> {

}

public class GenericsDemo1 {
    public static void main(String[] args) {
        Wrapper1<String> w1 = new Wrapper1<>();
        Wrapper1<Object> w2 = new Wrapper1<>();
        Wrapper1 w3 = new Wrapper1(); //raw type
        //w2 = w1;
        w2 = w3;
        w3 = w1;
    }
}
