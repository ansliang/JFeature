package Lambda;

interface Divable1 {
    int div(int num1, int num2);
}

interface Divable2 {
    String div(String num1, int num2);
}

interface Divable3 {
    int div(int num);
}

interface Divable4 {
    int div();
}

interface Divable5 {
    int div(final int num1, final int num2);
}

public class TestLambda {
    public static void main(String[] args) {
        Addable a = new Addable() {
            @Override
            public int add(int num1, int num2) {
                return 0;
            }
        };

        Divable1 d1 = (int num1, int num2) -> {
            return num1 + num2;
        };
        Divable2 d2 = (num1, num2) -> {
            return num1 + num2;
        };
        Divable3 d3 = num -> {
            return num;
        };
        Divable4 d4 = () -> {
            return 0;
        };
        Divable5 d5 = (final int num1, final int num2) -> {
            return num1 + num2;
        };
    }
}
