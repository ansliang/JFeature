package exception;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

public class ExceptionDemo2 {
    public static void test() throws IOException {
        System.in.read();
    }

    public static void main(String[] args) {
        try{
            test();
        } catch (IOException e) {

        }
    }
}
