package Reflection;

public class Dog {
    private String name;



    public void m1() {
        System.out.println("m1");
    }

    public Dog(String name) {
        this.name = name;
        System.out.println("m2 " + name);
    }
}
