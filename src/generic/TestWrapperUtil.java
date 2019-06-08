package generic;

public class TestWrapperUtil {
    public static void main(String[] args) {
        ObjectWrapper<Object> w1 = new ObjectWrapper<>("hello");
        w1.setData(12);
        WrapperUtil.print(new ObjectWrapper<>("hello"));
        ObjectWrapper<Integer> w2 = new ObjectWrapper<>(12);
        WrapperUtil.print(new ObjectWrapper<>(12));

        ObjectWrapper<?> w3 = new ObjectWrapper<>(12L);
        //w3.setData(100);
    }
}
