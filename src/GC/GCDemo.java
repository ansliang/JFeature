package GC;

public class GCDemo {
    public static void main(String[] args) {
        long m1, m2, m3;
        Runtime r = Runtime.getRuntime();
        for (int i = 0; i < 3; i++) {
            m1 = r.freeMemory();
            creatObject(2000);
            m2 = r.freeMemory();
            System.gc();
            m3 = r.freeMemory();
            System.out.println(m1 + " , " + m2 + " , " + m3);
        }
    }

    public static void creatObject(int num) {
        for (int i = 0; i < num; i++) {
            new Object();
        }
    }
}
