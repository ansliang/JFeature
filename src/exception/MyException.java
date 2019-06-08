package exception;

public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }

    public MyException(Throwable t) {
        super(t);
    }

    public MyException(String msg, Throwable t) {
        super(msg, t);
    }
}
