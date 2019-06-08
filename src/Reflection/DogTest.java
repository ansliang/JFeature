package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DogTest {
    /*public static void main(String[] args) {
        Class<Dog> c = Dog.class;
        try {
            Dog dog = c.newInstance();    //创建一个实例（调用的是无参构造方法）
        } catch (InstantiationException e) {//实例化异常，当没有无参构造方法可以被调用时有异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {//非法访问异常，当无参构造方法为private时
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("Reflection.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Dog dog = (Dog) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        Class<?> c = Dog.class;
        try {
            Constructor<?> constructor = c.getConstructor(String.class);
            try {
                Dog dog = (Dog)constructor.newInstance("MyDog");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("Reflection.Dog");
            Dog dog = (Dog) c.newInstance();
            Method m1 = c.getDeclaredMethod("m1");
            m1.invoke(dog);
            Method m2 = c.getDeclaredMethod("m2", String.class);
            m2.invoke(dog, "Test");

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("Reflection.Dog");
            Constructor<?> constructor = c.getDeclaredConstructor(String.class);
            Dog dog = (Dog) constructor.newInstance("ADog");

            Field f = c.getDeclaredField("name");
            f.setAccessible(true);                      //表示可访问private
            System.out.println(f.get(dog));             //ADog, 第一个参数是实例名，如果是基本数据类型就用getInt()之类的方法
            f.set(dog, "BDog");                         //设置属性的值，无法访问private, 可以在声明f后调用setAccessible()函数表示可访问之后就可以对private进行set\get操作
            System.out.println(f.get(dog));             //BDog
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

