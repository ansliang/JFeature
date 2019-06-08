package Reflection;

import java.io.Serializable;
import java.lang.reflect.Modifier;

 final class Person extends Thread implements Serializable {

}

public class ClassInfo {
    public static void main(String[] args) {
        Class<Person> c = Person.class;
        System.out.println(c.getName());                //Reflection.Person
        System.out.println(c.getSimpleName());          //Person
        System.out.println(c.getPackage().getName());   //Reflection
        System.out.println(c.isInterface());            //false
        Class<?> sc = c.getSuperclass();
        System.out.println(sc.getName());               //java.lang.Thread
        Class<?>[] si = c.getInterfaces();              //得到接口数组
        for (Class<?> class1 : si) {
            System.out.println(class1.getName());       //java.io.Serializable
        }
        int mod = c.getModifiers();                     //得到修饰符所对应的int
        System.out.println(Modifier.toString(mod));     //final, 转换为修饰符
        int mod1 = Integer.class.getModifiers();
        System.out.println(Modifier.toString(mod1));    //public final

        System.out.println(c.toGenericString());        //final class Reflection.Person
    }
}
