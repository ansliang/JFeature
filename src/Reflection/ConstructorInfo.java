package Reflection;

import java.lang.reflect.Constructor;

class Class3 extends Class4 {
    public Class3() {
        super();
    }

    public Class3(String s) {

    }
}

class Class4 {
    public Class4() {

    }
}

public class ConstructorInfo {
    public static void main(String[] args) {
        Class<Class3> c = Class3.class;
        Constructor<?>[] cs1 = c.getConstructors();
        for (Constructor<?> cs : cs1) {
            System.out.println(cs.getName());
        }
        System.out.println("---------------------------------");
        try {
            Constructor<?> cs2 = c.getDeclaredConstructor(String.class);
            System.out.println(cs2.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
        try {
            Constructor<?> cs3 = c.getDeclaredConstructor();
            System.out.println(cs3.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
