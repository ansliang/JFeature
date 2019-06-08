package exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        try {
            int r = num1 / num2;
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
