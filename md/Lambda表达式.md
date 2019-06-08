#### Lambda表达式

- 没有名称的代码块，有形式参数列表和实现体

- 可以作为方法的参数或赋值给变量

- 自身没有类型，编译器根据环境推断其类型

- 例如：

  `(int x) -> x+1`

  `(int x, int y) -> {int max = x>y?x:y; return max;}`

##### 语法

- `（<参数列表>）-> {<实现体>}`
- 与方法的不同：
  - 不能有名字
  - 没有返回值类型，其类型由编译器根据使用环境推断
  - 没有throws语句，由编译器根据使用环境推断
  - 不能声明类型参数，即不可是泛型的
  - **可以将其赋值给一个合适的函数式接口变量**

```java
interface Divable1 {
    int div(int num1, int num2);
}

interface Divable2 {
    String div(String num1, int num2);
}

interface Divable3 {
    int div(int num);
}

interface Divable4 {
    int div();
}

interface Divable5 {
    int div(final int num1, final int num2);
}

public class TestLambda {
    public static void main(String[] args) {

        Divable1 d1 = (int num1, int num2) -> {
            return num1 + num2;
        };
        Divable2 d2 = (num1, num2) -> {	//类型由编译器根据使用环境推断,这里是String,String
            return num1 + num2;
        };
        Divable3 d3 = num -> { //只有一个参数时可以省略括号
            return num;
        };
        Divable4 d4 = () -> { //无参时只有一个括号
            return 0;
        };
        Divable5 d5 = (final int num1, final int num2) -> { //参数有修饰符的要加上修饰符
            return num1 + num2;
        };
    }
}
```

##### 目标类型

- Lambda表达式实际是一个函数式接口类型
- 但是并不知道到底是哪个函数式接口类型
- 只有在使用时，编译器会根据使用环境推断出被期望的类型，即为目标类型
- 意味着同样的Lambda表达式在不同上下文你可以拥有不同的类型

###### 目标类型的推断

- `T t = <Lambda表达式>;`

- 规则：

  - T必须是函数式接口

  - Lambda表达式的参数数量和类型与T中的抽象方法声明一致

  - Lambda表达式的实现体返回值类型与T中方法返回值类型一致

  - Lambda表达式的实现体中抛出的任何受检异常都要与T中的抽象方法声明的异常一致，若抽象方法中没有异常声明会出现编译错误

    ```java
    @FunctionalInterface
    interface Interface1 {
        void m(int num1, int num2);
    }
    
    @FunctionalInterface
    interface Interface2 {
        int m(int num1, int num2);
    }
    
    @FunctionalInterface
    interface Interface3 {
        void m() throws IOException;
    }
    
    public class TargetType {
        public static void main(String[] args) {
            Interface1 i1 = (num1, num2) -> System.out.println(num1 + num2);
            Interface2 i2 = (num1, num2) -> {
                return num1 + num2;
            };
            Interface3 i3 = () -> {
                System.in.read(); //这里的异常在函数式接口的方法声明那里throws，或者就在此处try-catch
            };
        }
    }
    ```

##### 使用场景

- 赋值

  `Interface1 i1 = (num1, num2) -> System.out.println(num1 + num2);`

- 方法调用

  ```java
  interface Interface1 {
      void m(int n1, int n2);
  }
  
  interface Interface2 {
      void m(String n1, String n2);
  }
  ```

  ```java
  static void m(Interface1 i){}
  static void m(Interface2 i){}
  public static void main(String[] args) {
      Interface1 i1 = (num1, num2) -> System.out.println(num1 + num2);
      //对于方法重载的三种调用方式
      m(i1);//先赋值再传入
      m((Interface1)(num1, num2) -> System.out.println(num1 + num2));//使用强制类型转换
      m((int num1, int num2) -> System.out.println(num1 + num2));//明确Lambda表达式的参数类型
  }
  ```

- 返回值

  ```java
  static Interface1 test() {
      return (num1, num2) -> System.out.println(num1 + num2);
  }
  ```

- 转换

##### 泛型函数式接口

- Lambda表达式可以赋值给泛型函数式接口类型的变量
- 但不能赋值给带有泛型方法的非泛型函数式接口类型的变量，要使用方法引用或匿名内部类

```java
public interface FuncInterface<T> {
    T m(T t);
}

interface FuncInterface1 {
    <T> T m(T t);
}

class TestFunInterface {
    void test() {
        FuncInterface<String> f1 = t -> t + "abc";
        //FuncInterface1 f2 = t -> t + "abc";
    }
}
```

##### 交集类型

- 使用&将多个类型连接起来就成了交集类型
- 一般是将标记接口和函数式接口进行连接

```java
interface MarkeInterface {
}

MarkeInterface mi = (MarkeInterface & FuncInterface) t -> t + "abc";
```

##### 方法引用

- 方法引用时使用已经存在方法创建Lambda表达式的简化方式
- 可以使代码更易读，更简明

###### 语法

- `<限定>::<方法名>`

  | 语法                           | 描述                           |
  | ------------------------------ | ------------------------------ |
  | TypeName::staticMethod         | 引用类，接口或枚举中的静态方法 |
  | objectRef::instanceMethod      | 特定对象的实例方法             |
  | ClassName::instanceMethod      | 类的任意对象的实例方法         |
  | TypeNmae.super::instanceMethod | 特定对象的超类的实例方法       |
  | ClassName::new                 | 类的构造方法                   |
  | ArrayTypeName::new             | 数组的构造方法                 |

  ```java
  ToInt<String> t1 = Integer::parseInt;
  System.out.println(t1.convert("123"));  //123
  
  Supplier<Integer> s1 = "Jack"::length;
  System.out.println(s1.get());              //4
  
  Consumer<String> s2 = System.out::print;
  
  Function<String, Integer> f1 = String::length;
  System.out.println(f1.apply("Rose and Jack"));  //13
  ```

- `ToIntFunction<String> lengthFunction = String::length;`

  该方法不会立即运行，会在目标类型调用时运行

##### 词法作用域

- Lambda表达式没有定义自己的作用域
- 他存在于外围作用域中，称为词法作用域