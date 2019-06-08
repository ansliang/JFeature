package generic;

class User<T>{

}

public class TestInferType {
    public static void main(String[] args) {
        User<String> user1 = new User<>();
    }
}
