package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Flying {
    void m1();

    int m2(int i);
}

class Swan implements Flying {
    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public int m2(int i) {
        System.out.println("m2");
        return i;
    }
}

class LogInvocationHandler implements InvocationHandler {
    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method before...");
        Object result = method.invoke(target, args);
        System.out.println("Method after...");
        return result;
    }
}

public class TestProxy {
    public static void main(String[] args) {
        Swan swan = new Swan();
        //创建一个与代理对象相关联的InvacationHandle
        InvocationHandler myHandle = new LogInvocationHandler(swan);
        //创建一个代理对象b，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Flying b = (Flying) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), swan.getClass().getInterfaces(), myHandle);
        b.m1();
        int r = b.m2(20);
        System.out.println(r);
    }
}
