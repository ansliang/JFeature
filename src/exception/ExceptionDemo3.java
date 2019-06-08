package exception;

import java.io.IOException;

public class ExceptionDemo3 {
    {
        System.in.read();
    }

    static {
        try {
            System.in.read();
        } catch (IOException e) {

        }
    }

    public ExceptionDemo3() throws IOException {

    }

    public static void main(String[] args) {
        try {
            ExceptionDemo3 ex = new ExceptionDemo3();
        } catch (IOException e) {

        }
    }
}
