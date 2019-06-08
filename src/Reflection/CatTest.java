package Reflection;

import java.lang.reflect.Array;

public class CatTest {
    public static void main(String[] args) {
        Class<Cat> c = Cat.class;
        Cat[] cats = (Cat[])Array.newInstance(Cat.class, 5);
        System.out.println(cats.getClass().isArray());          //true
        System.out.println(cats.getClass().getComponentType()); //class Redlection.Cat
    }
}
