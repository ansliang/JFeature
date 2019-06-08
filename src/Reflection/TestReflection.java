package Reflection;

import java.lang.reflect.*;


public class TestReflection {
    Bird<? extends String> b = new Bird<>();

    <V> void m(){
    }

    Bird<String>[] bs = new Bird[10];

    public static void main(String[] args) throws Exception {
        /*Class<TestReflection> c = TestReflection.class;
        Field f1 = c.getDeclaredField("b");
        System.out.println(f1.getType().getName());                         //Reflection.Bird
        System.out.println(f1.getGenericType().getTypeName());              //Reflection.Bird<? extends java.lang.String>
        if(f1.getGenericType() instanceof ParameterizedType) {

            System.out.println(((ParameterizedType)f1.getGenericType())
                    .getActualTypeArguments()[0].getTypeName());            //? extends java.lang.String
        }

        System.out.println("------------------------------");
        Method m = c.getDeclaredMethod("m");
        TypeVariable<Method> t = m.getTypeParameters()[0];
        System.out.println(t.getName());                                    //V

        System.out.println("------------------------------");
        Field f2 = c.getDeclaredField("bs");
        if(f2.getGenericType() instanceof GenericArrayType) {
            System.out.println(((GenericArrayType)f2.getGenericType())
                    .getGenericComponentType().getTypeName());              //Reflection.Bird<java.lang.String>
        }*/
        Bird<String> b1 = new Bird<>();
        b1.m("abc");
        //b1.m(10);

        Class<?> c = b1.getClass();
        Method m2 = c.getDeclaredMethod("m", Object.class);
        m2.invoke(b1, "cde");
        m2.invoke(b1, 20);
    }
}
class Bird<T> {
    void m(T t) {
        System.out.println(t);
    }
}