package Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRun {
    public static void main(String[] args) {
        Class<TestAnnocation> c = TestAnnocation.class;
        Method[] ms = c.getDeclaredMethods();
        for (Method method : ms) {
            if (method.isAnnotationPresent(Test.class)) { //表示如果该方法是由Test注解修饰的,还有其他用途可以看method的其他方法
                Test t = method.getAnnotation(Test.class);
                int num = t.num();
                if (num < 10) {
                    continue;
                }
                try {
                    method.invoke(c.newInstance()); //只输出Hello Add ,Hello Div由于num<10 contunue了,Hello Del由于没有注解Test所以在if判断为false
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
