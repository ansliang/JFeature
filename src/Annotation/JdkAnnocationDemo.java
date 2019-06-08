package Annotation;

@SuppressWarnings("all")
public class JdkAnnocationDemo{
    private int num;

    @Override
    public String toString(){
        return "new toString";
    }

    @Deprecated
    static void m2(){ //该方法不推荐被使用，可能在后续会被删除
    }

    @FunctionalInterface
    interface Interface {
        void m();
    }

    public static void main(String[] args) {
        m2();
    }
}
