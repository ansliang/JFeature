package Reflection;

import java.lang.reflect.Method;

abstract class Class2 {
    public void m1() {
    }

    public void m1(int i){

    }

    private void m2() {
    }

    static void m3() {
    }

    abstract void m4();
}

public class MethodInfo {
    public static void main(String[] args) {
        Class<Class2> c = Class2.class;
        Method[] ms1 = c.getMethods();
        for (Method m : ms1) {
            System.out.println(m.getName());        //所有public方法（包括继承而来的）
        }
        System.out.println("--------------------");
        Method[] ms2 = c.getDeclaredMethods();
        for (Method m : ms2) {
            System.out.println(m.getName());        //类中声明的所有方法（不包括继承的）
        }
        System.out.println("--------------------");
        try {
            Method m1 = c.getMethod("m1");
            Method m2 = c.getMethod("m1",int.class);
            System.out.println(m1.getName());
            System.out.println(m2.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
