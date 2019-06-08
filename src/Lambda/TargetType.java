package Lambda;

import java.io.IOException;
import java.sql.SQLOutput;

@FunctionalInterface
interface Interface1 {
    void m(int num1, int num2);
}

@FunctionalInterface
interface Interface2 {
    int m(int num1, int num2);
}

@FunctionalInterface
interface Interface3 {
    void m() throws IOException;
}

public class TargetType {
    static void m(Interface1 i){}
    static void m(Interface2 i){}
    public static void main(String[] args) {
        Interface1 i1 = (num1, num2) -> System.out.println(num1 + num2);
        Interface2 i2 = (num1, num2) -> {
            return num1 + num2;
        };
        Interface3 i3 = () -> {
            System.in.read(); //这里的异常在函数式接口的方法声明那里throws，或者就在此处try-catch
        };
        m(i1);
        m((Interface1)(num1, num2) -> System.out.println(num1 + num2));
        m((int num1, int num2) -> System.out.println(num1 + num2));
    }
}
