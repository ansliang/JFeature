package exception;

import java.io.IOException;

public class TestMyException {
    public void test(int num) throws MyException {
        if (num == 10) {
            throw new MyException("num==10");
        }
    }
    public static void main(String[] args) {
        TestMyException test = new TestMyException();
        try {
            test.test(1);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
