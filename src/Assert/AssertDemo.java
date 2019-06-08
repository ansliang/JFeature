package Assert;

public class AssertDemo {
    public static void main(String[] args) {
        int num = 10;
        assert num == 10 : "num != 10, num = " + num;
        assert num == 1 : "num != 1, num = " + num;
        System.out.println("Assert");
    }
}
