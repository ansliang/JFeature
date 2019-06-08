package Annotation;

public class TestAnnocation {
    @Test(num = 10)
    public void testAdd() {
        System.out.println("Hello Add");
    }

    @Test(num = 1)
    public void testDiv() {
        System.out.println("Hello Div");
    }

    public void testDel() {
        System.out.println("Hello Del");
    }
}
