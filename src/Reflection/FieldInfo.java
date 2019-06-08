package Reflection;

import java.lang.reflect.Field;

interface Interface1 {
    int NUM = 10; //接口里属性默认都是 public static final
}

class Class1 {
    int num1;
    public String name;
}

class MyClass extends Class1 implements Interface1 {
    int num2;
    public int num3;
    private int num4;
}

public class FieldInfo {
    public static void main(String[] args) {
        Class<MyClass> c = MyClass.class;
        Field[] fields1 = c.getFields();
        for (Field field : fields1) {
            System.out.println(field.getName());        //num3,NUM,name 得到的是所有的public属性
        }
        System.out.println("---------------------------------");
        Field[] fields2 = c.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field.getName());        //num2,num3,num4 得到的是这个类里面声明的属性
        }
        System.out.println("---------------------------------");
        try {
            Field f1 = c.getField("num3");
            System.out.println(f1.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------");
        try {
            Field f2 = c.getDeclaredField("num2");
            System.out.println(f2.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
