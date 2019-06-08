package exception;

import java.io.IOException;

class Parent{
    public void m() throws MyException {
    }
}

class Son extends Parent {
    @Override
    public void m() throws MyException{
    }
}


public class TestOverride {
    public static void main(String[] args) {

    }
}
