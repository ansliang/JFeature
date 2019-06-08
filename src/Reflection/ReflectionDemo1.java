package Reflection;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ReflectionDemo1 {

    static void creat1() {
        new User();
    }

    static void creat2() {
        Class<User> c = User.class;
    }

    static void creat3() {
        try {
            Class c = Class.forName("Reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void creat4() {
        try {
            Class c = Class.forName("Reflection.User", false, ReflectionDemo1.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        creat4();

//        Class<String> c = String.class;
//
//        String s = "";
//        Class<?> c1 = s.getClass();
//
//        try {
//            Class<?> c2 = Class.forName("java,lang.String");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        System.out.println(int.class == Integer.TYPE);

    }
}

class User {
    static {
        System.out.println("User init...");
    }
}