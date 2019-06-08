### JAVA面向对象编程

#### 可变长度参数

```java
int getNum(int num, int... nums)
```

可变长度参数必须在方法声明参数的最后

调用：

- 不传任何参数
- 传入一个参数
- 传入若干参数，以逗号分隔
- 传入一个数组

#### 命令行参数

在JVM调用`main`方法时，传入到该方法中的参数

#### 基本数据类型与引用数据类型

基本数据类型都存放在虚拟机栈中, 对象引用、`returnAddress`也存放在栈中；对象实例、数组存放在堆中

例如：

```java
int i = 10;
```



这个i 就存放在栈中

```java
User use1 = new User();

User use2 = use1;
```

`use1`是一个对象引用，存放在栈中，`new User()`是一个对象，存放在堆中, `use1`保存的是所指向对象的地址，第二个语句是把`use1`的存放的地址复制给`use2`，故`use2`也指向`use1`指向的对象实例。

#### 方法的传参方式

```java
public class Test {
    private int num = 1;

    public void test1(int i) {
        i++;
        System.out.println("i=" + i);
    }

    public void test2(Test t) {
        t.num = 100;
        System.out.println("t.num=" + t.num);
    }

    public void test3(String s) {
        s += "abc";
        System.out.println("s=" + s);
    }

    public static void main(String[] args) {
        Test t = new Test();
        int i = 10;
        String s = "123";

        t.test1(i);
        t.test2(t);
        t.test3(s);

        System.out.println("i=" + i + " t.num=" + t.num + " s=" + s);

    }
}
```

out:

```i=11
i=11
t.num=100
s=123abc
i=10 t.num=100 s=123
```

特别注意：`String`类型也是引用，但是在`test3`函数调用时函数内输出的是一个新的字符串（字符串特点，修改字符串是产生一个新的字符串），这个新的字符串是在函数内生成的，在调用`t.test3(s)`时指向的仍然是字符串s.

#### 包装类

包装类是为了解决基本数据类型无法面向对象编程所提供的

| 基本数据类型 | 包装类型  |
| ------------ | --------- |
| byte         | Byte      |
| boolean      | Boolean   |
| short        | Short     |
| char         | Character |
| int          | Integer   |
| long         | Long      |
| float        | Float     |
| double       | Double    |

##### 包装类引用场景

1. 集合类泛型只能是包装类

   ```java
   //编译报错
   List<int> list1 = new ArrayList<>();
   
   //正常
   List<Integer> list2 = new ArrayList<>();
   ```

   

2. 成员变量不能有默认值

   ```java
   private int status;
   ```

   基本数据类型的成员变量都有默认值，而使用包装类则其默认值为`Null`，没有默认值影响

3. 方法参数允许定义空值

   ```java
   private static void test1(int status){
       System.out.println(status);
   }
   ```

   以上代码`int`必须传一个数字过来，不能传`null`，有些时候希望能传递`null`

##### 包装类的赋值

1. 构造方法

   ```java
   Integer i = new Integer(1);
   ```

   

2. `valueOf()`

   ```java
   Integer i = Integer.valueOf(1);
   ```

两种方法的区别：

- `new`关键字总是会创建一个新的对象，`valueOf()`方法会缓存范围在`-128`到`127`之间的整数型数值（byte, short, int, long)

- 构造方法除了`Character`类，其他包装类都提供了两种构造方法

  ```java
  Integer i1 = new Integer(100);
  Integer i2 = new Integer("100");
          
  Character c = new Character('a');
  ```

  除了`Character`类的包装类构造方法参数都可以是值或者字符串，而`Character`类只能是字符，`Boolean`类用字符串赋值时，除了`true`其他的字符串都表示`false`

  ```java
  Integer i1 = Integer.valueOf(100);
  Integer i2 = Integer.valueOf("100");
  Integer i3 = Integer.valueOf("100", 8);   
  ```

  `valueOf()`除了数值和字符串之外还能改变进制，`i3`就表示8进制的100即64。

##### 数字包装类

Byte，Short， Integer，Long，Float，Double

- `xxxValue()`，返回保存指定的 `String` 的值的 `Integer` 对象

  ```java
  Integer i1 = Integer.valueOf(100);
  int num = i1.intValue();
  System.out.println(num);//100
  ```

- `parsexxx()`，将字符串参数作为有符号的十进制整数进行解析

  ```java
  int num = Integer.parseInt("123");
  System.out.println(num);//123
  ```

  `parseInt()`和`valueOf()`的区别：`parseInt`方法返回的是int基本类型，`valueOf`方法返回的是Integer的包装类型。`valueOf`方法实际上是调用了`parseInt`方法，也就是说，如果我们仅仅只需要得到字符串类型字符数值对应的整数数值，那我们大可不必调用`valueOf`，因为这样得到整形数值后还有一个装箱的操作。

- 上面两个函数都可以有第二个参数表示进制

- 包括常量，表示这些数字的范围

  `MAX_VALUE`  `MIN_VALUE`  `SIZE`

  ```java
  System.out.println(Integer.SIZE); //32
  System.out.println(Integer.MAX_VALUE);//21447483647
  System.out.println(Integer.MIN_VALUE);//-2147483648
  ```

  

##### 字符包装类

```java
Character.isDigit(char ch)			//确定指定字符是否是数字
Character.isLetter(char ch)			//确定指定字符是否是字母
Character.isLetterOrDigit(char ch)	//确定指定字符是否是字母或数字
Character.isLowerCase(char ch)		//确定指定字符是否是小写字母
Character.isUpperCase(char ch)		//确定指定字符是否是大写字母
Character.toLowerCase(char ch)		//转换为小写
Character.toUpperCase(char ch)		//转换为大写
Character.toString(char ch)			//返回String对象
```

##### 布尔包装类

```java
Boolean b1 = Boolean.FALSE;
Boolean b2 = Boolean.TRUE;
System.out.println(b1.booleanValue()+" " +b2.booleanValue());
```

##### 自动装箱、自动拆箱

装箱：基本数据类型转换成对应的包装类

拆箱：包装类能转换为对应的基本数据类型

**该转换是在编译时发生的。**

```java
public static void autoConvTest() {
	Integer in = 1;  //Integer in = new Integer(1);
	System.out.println(in); //use toString() method
    
    in = in + 5;
    System.out.println(in);
}
```

在例子中`in = in + 5`实际上经历了自动拆箱后再自动装箱：

- 由于引用数据类型`in`不能同基本类型运算，首先`in + 1`拆箱==>`in.intValue() + 1`
- 自动装箱`in = 6`

```java
Integer in = null;
in = in + 1;
```

这一段程序会报错空指针异常。在这种情况下不要将`null`赋给`in`，而是把`0`赋给`in`

#### 方法重载调用

重载方法的参数分别是几本书类型和对应的包装类，调用规则：

- 如果实参是基本数据类型
  - 先找带有该类型参数的方法，找不到则扩大范围继续找
  - 前面的步骤找不到，则找带有装箱之后的包装类型参数的方法

- 如果实参是包装类型
  - 先找带有该包装类型的方法，如果没有匹配，不会扩大范围，而是按照父子类的规则传参
  - 如果上面的匹配不到，则将包装类拆箱来匹配参数或扩大范围

```java
public class Test {

    public void test(int i) {
        System.out.println("int");
    }

    public void test(double d) {
        System.out.println("double");
    }

    public void test(Integer i) {
        System.out.println("Integer");
    }

    public void test(Double d) {
        System.out.println("Double");
    }

    public void test(Object o) {
        System.out.println("Object");
    }
    
    public void test(int... ids) {
        System.out.println("...")
    }

    public static void main(String[] args) {
        Test t = new Test();
        Integer i = Integer.parseInt("10");
        t.test(10);
        t.test(i);
    }
}
```

调用顺序是：

```
t.test(10): int -> double -> Integer -> Object -> ...
t.test(i): Integer -> Object -> int -> double -> ...
```

注意：基本数据类型可以由`int `转换成`double`，但是包装类不能由`Integer`转为`Double`

#### This关键字

指向当前类的实例

两种用法：

- 在普通方法里通过`this.`的方式调用类的方法与数据等

  ```java
  private int num = 100;
  public void setNum(int num) {
      this.num = num;
  }
      
  public void setNum(){
      setNum(50);  //this.setNum(50)
  }
  ```

- 在构造方法里使用`this()`找到相应形式的构造方法

  ```java
  public Test() {
      this(100); //调用Test(int num)
  }
      
  public Test(int num) {
       this.num = num;
  }
  ```

注意：`this`关键字不能在`static`方法里使用，因为`this`指向的是当前实例的值，而`static`是针对类的

#### 继承

继承是从已有的类（父类或超类）中派生出新的类（子类），子类会自动拥有父类的属性和方法，并且子类可以扩展新的努力

#### 类的初始化顺序

单个类的初始化顺序:

1. 静态成员变量，静态代码块（与顺序有关）
2. 实例成员变量，代码块（与顺序有关）
3. 构造方法

父类与子类的初始化顺序：

1. 父类静态成员变量，静态代码块
2. 子类静态成员变量，静态代码块
3. 父类实例成员变量，代码块
4. 父类构造方法
5. 子类实例成员变量，代码块
6. 子类构造方法

#### 访问控制修饰符

| 修饰符    | 控制范围                 |
| --------- | ------------------------ |
| public    | 所有代码都可以访问       |
| protected | 本包及其子类代码可以访问 |
| 默认      | 本包代码可以访问         |
| private   | 本类代码可以访问         |

`protected`注意点：当父类与子类在不同包时，可以在子类中通过子类的对象访问父类的`protected`变量

```java
package birdpack;  
 
public class Bird {  
    protected int nFeathers;  
}
```

```java
package duckpack;  
 
import birdpack.Bird;  
 
public class Duck2 extends Bird {  
    public void constructor(int newDuck2) {  
        Duck2 d2 = new Duck2();  
        //在子类中通过子类的对象访问父类中的protected变量  
        d2.nFeathers = newDuck2;  
    }  
}
```



子类中用父类对象反而不能访问父类中的`protected`变量

```java
package duckpack;  
 
import birdpack.Bird;  
 
public class Duck3 extends Bird {  
    public void constructor(int newDuck3) {  
        Bird b = new Bird();  
        //子类中用父类对象反而不能访问父类中的protected变量  
        //b.nFeathers = newDuck3;  
    }  
} 
```

子类中用另外一个子类的对象也不能访问父类中的`protected`

```java
package duckpack;  
 
import birdpack.Bird;  
 
public class Swan extends Bird {  
    public void constructor(int swan) {  
            Duck1 d1 = new Duck1();  
            //子类中用另外一个子类的对象也不能访问父类中的protected变量  
            //d1.nFeathers = swan;  
    }  
}
```

**虽然在java中，父类中protected权限的成员变量可以被子类访问，但是还是有条件的**

1.在子类中直接使用父类的protected变量是可以的，父类的protected权限的成员变量可以被子类继承

2.在子类中通过子类的对象访问父类的protected成员是可以的

3.在其他包的子类中使用父类的对象访问父类的protected成员反而是不行的

4.在子类中使用父类的其他子类的对象访问父类的protected成员也是不行的

#### 方法重写

子类会继承父类的方法，如果子类需要对父类中某方法的默认逻辑进行修改，则可以在子类中对该方法进行修改，即是重写

语法规则：

- 在继承关系的子类中
- 方法名相同
- 参数相同
- 不能缩小访问权限
- 不能抛出比父类方法更多或范围更大的异常
- 子类方法的返回值与父类相同或是其子类
- 父类的静态方法不能重写
- 父类的非静态方法不能重写为静态方法
- 私有方法不能继承因而也无法重写

编译器检查重写准确性的方法：@Override

```java
public class Parent {
    int getName() {
        System.out.println("Parent's name.");
    }
}

public class Son extends Parent {
    @Override
    int getName(){
        System.out.println("Son's name.");
    }
}
```

#### Super关键字

- 指向父类的实例

- 使用场景

  - 在一般的实例方法中使用

  - 在构造方法中使用

    ```java
    public class Parent {
        public Parent(int n) {
            System.out.println("Parent构造方法");
        }
    }
    
    public class Son extends Parent {
        public Son() {
            super(100);
            System.out.println("Son构造方法");
        }
    }
    ```

    ##### super 与 this

    `this`是调用重载的本类的构造方法

    `super`是调用父类的构造方法

    `this` 和 `super`都必须是构造函数的第一条语句

#### Final关键字

- 修饰变量：该变量实际是常量，一旦初始化了就不可修改

  ```java
  class FinalDemo {
      final static int NUM = 10; //不可变常量，且在定义时就要赋值
      void test() {
          final int num;
          num = 20;   //在这里变量可以先定义，再赋值
          //num = 30; 但还是不可改变
      }
  }
  ```

- 修饰方法：在子类不可重写（但可以重载，因为相当于另外一个函数）

- 修饰类：表示该类不可被继承

- 修饰引用：不可指向新的引用，但引用的值可以改变

#### 向上转型与向下转型

向上转型(upcasting)：将子类的实例赋值给父类类型的变量

```java
Parent son = new Son();
```

```java
public class Son extends Parent {
    public Son() {
        super();
        System.out.println("Son构造方法");
    }
    
    public static void test(Parent p) {
        System.out.println("Test method.");
    }
    
    public static void main(String[] args) {
        Son son1 = new Son();
        Parent parent1 = new Parent();
        Parent son2 = new Son(); //向上转型，son2指向一个Parent实例

        test(son1); //Son对象转为Parent对象
        test(son2);
        test(parent1);
        test(new Parent());
        test(new Son());
    }
}
```



向下转型(downcasting)：将父类的实例赋值给子类类型的变量，需要使用强制类型转换，否则可能抛出`java.lang.ClassCastException`

```java
public class Son extends Parent {
    public Son() {
        super();
        System.out.println("Son构造方法");
    }
    public static void test(Son s) {
        System.out.println("Test method.");
    }

    public static void main(String[] args) {
        Son son1 = new Son();
        Parent parent1 = new Parent();
        Son parent2 = (Son)new Parent(); //向下转型，parent2指向一个Son实例，需要强制转换类型，但在运行时会被JVM发现报错
        test(son1);
        test((Son)parent1);//类型强制转换，同出错
        test(parent2);
        test((Son)new Parent());//类型强制转换，同出错
        test(new Son());
    }
}
```

**结果会抛出异常`java.lang.ClassCastException`，因为在JVM运行时发现不能由`Parent`转为`Son`**

如何解决这个问题呢？

##### instanceof关键字

- 该关键字判断一个变量的数据类型是否是某类型或其子类型，这样能确保向下转型时不会出错
- 同时会做编译时和运行时的检查
- **null**不属于任何类型

```java
Parent p = new Parent();
Son s = new Son();
System.out.println(p instanceof  Son);		//false
System.out.println(p instanceof  Parent);	//true
System.out.println(s instanceof  Son);		//false
System.out.println(s instanceof  Parent);	//true
```

##### 实现向下转型的具体方法

```java
Parent p1 = new Son();
Parent p2 = new Parent();
Son s = (Son)p1; //这一步是成功的向下转型
s = (Son)p2;	 //这一步是抛出异常的
```

从上例可以看出，只有这个实例在构造时就是子类，但是是用一个父类对象引用时，这个父类对象才能向下转型为子类对象

#### 绑定（用于继承时的调用）

绑定（Binding）是一个做出决定的过程，该决定需要确定在程序运行时，哪个方法或属性被访问。

分两个阶段：

- 编译时：早期绑定，静态绑定
- 运行时：晚期绑定，动态绑定

##### 编译时绑定

由编译器在编译时就已经决定调用哪个方法或属性

用于：

- 所有类型的属性：静态或非静态
- static方法
- 非static的final方法

##### 运行时绑定

由JVM在运行时才决定调用哪个方法或属性

用于：

- 非static，非final方法

理论上来讲有一点性能的损失（运行时要判断），但与其好处相比基本可以忽略，因为它可以帮我们实现多态

```java
public class Test {
    public static void main(String[] args) {
        Class1 c1 = new Class2();
        System.out.println(c1.num);  //100  编译时绑定
        c1.print();                  //Class1 static print. 编译时绑定，静态非final就找父类
        c1.print1();                 //Class2 print.    运行时绑定，new谁就找谁
        //c1.print2();                 错误，Class1没有print2()方法
    }
}

class Class1 {
    int num = 100;
    static void print() {
        System.out.println("Class1 static print.");
    }

    public void print1() {
        System.out.println("Class1 print.");
    }


}

class Class2 extends Class1 {
    int num = 200;
    static void print() {
        System.out.println("Class2 static print.");
    }

    @Override
    public void print1() {
        System.out.println("Class2 print.");
    }

    public void print2(){
    }
}
```

#### Object类

所有的类，包括数组都是直接或间接继承自Object类

提供了9个方法：

- Object实现了的且不允许子类重写的
  - `getClass()` `notify()` `notifyAll()` `wait()`
- Object实现了的且允许子类重写的
  - `toString()` `equals()` `hashCode()` `clone()` `finalize()` 

##### `toString()`重写

- 自动调用`toString()`方法的场景：

  - 字符串拼接（此时会自动调用`toString()`）

    ```java
    Dog dog = new Dog();
    String s = dog + "";	//Dog{name='null', age=0}
    ```

    

  - 控制台输出（直接输出一个对象的时候）

- 默认实现输出格式

  - 全限定类名@哈希码的16进制

- 重写`toString()`以输出更有意义的信息

```java
Dog dog = new Dog();

System.out.println(dog);	//Dog@1b6d3586，toString()默认输出
System.out.println(dog);	//Dog{name='Nike', age=3}，重写toString()后输出
```

##### `equals()`重写

- 当类有逻辑上的等同意义而不仅是对象意义上的等同
- 以下情况不要重写
  - 每个类实例本质是唯一的
  - 不关心类是否提供了“逻辑意义上的等同“测试
  - 父类已经重写了equals，该方法也适合子类

`==`和`默认equals()`是一样的，比较基本数据类型是比较值，比较引用数据类型是判断指向的是不是同一个实例

需要重写`equals()`的情况（例）：

```java
public class Test {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Tom");
        user1.setAge(21);

        User user2 = new User();
        user2.setName("Tom");
        user2.setAge(21);

        System.out.println(user1.equals(user2));
    }
}

class User {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


```

##### `hashCode()`重写

- 默认实现是返回对象在内存中的地址转换之后的整数
- 重写规则
  - 两个对象使用`equals`比较相等的话，则其`hashCode`返回值也相等，反过来不一定
  - 同一个对象`hashCode`方法在一个程序中调用多次，应该返回系统的值

**`hashCode()`和`equals()`在重写时是要一起重写的**

#### 抽象类

有时父类只知道子类有哪些方法。但是不知道子类的具体实现，就可以在父类中只声明该方法而不实现，该方法就称为抽象方法，这个类就是抽象类

```java
public abstract class AbstractClass{
    public abstract void method();
}
```

##### 抽象类的特征

- 抽象类不能被实例化，即使该抽象类不包含抽象方法也不行
- 抽象类可包含属性，方法（具体和抽象），构造方法，初始化块等
- 抽象类不一定有抽象方法，但抽象方法一定在抽象类中
- 抽象类不能用`final`修饰
- 可以有构造方法，但不可全部是`private`的
- 构造方法、静态方法、私有方法不可为抽象方法

##### 继承抽象类

- 子类使用`extends`继承抽象类
- 如果子类是具体类则需要实现所有的抽象方法，如果子类是抽象类则不一定

##### 抽象类的作用

- 从语义上看，抽象类作为子类的模板，避免了子类设计的随意性
- 从OOP的角度看，将类设计为抽象类，为系统提供多态实现，也会提高系统的可扩展性

#### 接口

可以用接口来表示只有抽象方法的抽象类

接口是一种约定，体现在接口名称和注释上，方法的实现方式要通过注释来约定

##### 接口成员

###### 属性

- 接口中所有的**属性**都是`public static final`修饰的

  - public: 使接口的实现类可以使用这个常量
  - static：static修饰就表示它属于类的，随的类的加载而存在的，如果是非static的话，就表示属于对象的，只有建立对象时才有它，而接口是不能建立对象的，所以接口的常量必须定义为static
  - final：final修饰就是保证接口定义的常量不能被实现类去修改，如果没有final的话，由子类随意去修改的话，接口建立这个常量就没有意义了

- 常量可以是基本数据类，也可以是引用数据类

  ```java
  public interface Swimable {
      int NUM = 10; //public static final
      public void swim();
      public static void print() {
          System.out.println("Only static method.");//只有静态方法才能在接口内有方法体
      }
  }
  ```

###### 方法

- 抽象方法
- 静态方法
- 默认方法

##### 继承接口

接口可以使用`extends`关键字继承另一个接口

可以继承：

- 抽象方法和默认方法
- 常量属性
- 嵌套类型

**不能继承静态方法**

##### 实现接口

- 实现接口的具体类需要使用`implements`关键字实现接口，并重写接口中所有的抽象方法
- 实现接口的抽象类可以重写接口中的部分抽象方法
- 一个类可以实现多个接口
- 接口可以作为数据类型用来声明变量

```java
public interface Swimable {		//接口Swimable
    int NUM = 10; //public static final
    public void swim();
    public boolean canSwim();
    public static void print() {
        System.out.println("Only static method.");
    }
}

interface Flyable {		//接口Flyable
    public void fly();
    public boolean canfly();
}

abstract class Fish implements Swimable { //是抽象类，可以只实现部分抽象方法
    @Override
    public void swim() {
        System.out.println("Fish can swim.");
    }
}

class Dog implements Swimable {		//不是抽象类，必须实现全部抽象方法
    @Override
    public void swim() {
        System.out.println("Dog can't swim.");
    }
    @Override
    public boolean canSwim() {
        return false;
    }
}

class Duck implements Swimable, Flyable {		//实现多个接口
    @Override
    public void swim(){}
    @Override
    public boolean canSwim(){}
    @Override
    public void fly(){}
    @Override
    public boolean canFly(){}
}
```

```java
public class Test {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
        
        Swimable duck1 = new Duck(); //接口可以作为数据类型用来声明变量，但是Duck()实现了多个接口时，声明的哪个接口，就用哪个接口的方法
        duck1.swim();
    }
}
```

##### 接口的静态方法

可以在接口中声明静态方法，实现一些处理逻辑

该方法不会被实现类或子接口继承

```java
public interface Flyable {
    public static void print() {
        System.out.println("Hello Flyable.")
    }
}
```

```java
public Class Test {
    public static void main(String[] args) {
        Flyable.print();
    }
}
```

##### 接口的默认方法

- 默认方法对所有实现了该接口的类都提供了默认实现
- 可以有多个默认方法
- 不能是静态
- 可以重写默认方法

```java
interface Flyable {
    default void show() { //默认方法，必须声明为default
        System.out.println("Show.")
    }
}

class Bird implements Flyable {
    
}
```

```java
public Class Test {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        bird.show();
    }
}
```

##### 解决冲突

- 当父类与接口有相同的方法时，父类方法优先（默认方法不能与Object中的方法相同）
- 当多个接口有相同方法名但不同参数的默认方法时，按照方法重载的规则调用
- 当多个接口有完全相同的默认方法时，子类必须重写该方法

```java
public interface Flyable {
    default void show() {
        System.out.println("Flyable show.");
    }
}
```

```java
public interface Swimable {
    default void show() {
        System.out.println("Swimable show.");
    }
}
```

```java
public class Bird {
    public void show() {
        System.out.println("Bird show.");
    }
}
```

```java
public class Duck extends Bird implements Flyable {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.show();	//Bird show.
    }
}
```

```java
public class Duck1 implements Flyable, Swimable {
    @Override
    public void show() { //两个接口有完全相同的默认方法，就要重写该方法
        System.out.println("Duck show.");
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.show();
    }
}
```

##### 标记接口

- 没有任何成员的接口
- 自身没有声明成员，也没有从父接口中继承成员
- 用于标记一个类在特定环境中具有特定的意义
- `JDK`中的标记接口：
  - `java.lang.Clone`
  - `java.io.Serializable`
  - `java.rmi.Remote`

##### 函数式接口

- 函数式接口是指只有一个抽象方法的接口（可以有多个默认方法和静态方法）
- 可以使用可选的`@FunctionalInterface`注解来表示`
- 与`Lambda`表达式关系密切

#### 多态

同一个引用类型，使用不同的实例而执行不同操作

使用父类或接口引用子类的实例

Java实现多态方式：

- 方法级别上：
  - 方法重载
  - 方法重写
- 类级别上：
  - 继承
  - 接口

```java
public abstract class Shape {
    public abstract int getArea();
    public abstract int getCircle();
}
```

```java
public class ShapeUtil {
    public static int[] getAreaAndCircle(Shape shape) {
        int[] r = new int[2];
        r[0] = shape.getArea();
        r[1] = shape.getCircle();
        return r;
    }
}
```

```java
public class Rec extends Shape {
    private int length;
    private int width;
    public Rec(int length, int width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public int getArea() {
        return length * width;
    }
    @Override
    public int getCircle() {
        return (length+width) * 2;
    }
}
```

```java
public class Square extends Shape {
    private int length;
    public Square(int length) {
        this.length = length;
    }
    @Override
    public int getArea() {
        return length * length;
    }
    @Override
    public int getCircle() {
        return 4 * length;
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Shape square = new Square(20);
        int[] s = ShapeUtil.getAreaAndCircle(square);
        System.out.println(s[0] + " " + s[1]);	//400 80

        Shape rec = new Rec(10, 20);
        int[] r = ShapeUtil.getAreaAndCircle(rec);
        System.out.println(r[0] + " " + r[1]);	//200 60
    }
}
```

##### 多态的好处

- 提高程序的可复用性
- 程序更有扩展性

#### 内部类

- 可以将一个类的定义放在另一个类的定义内部，这就是内部类
- 可以是在类中，方法中甚至表达式中
- 内部类允许把一些逻辑相关的类组织在一起，并控制位于内部的类的可见性

##### 内部类的分类

- 成员内部类
- 局部内部类
- 匿名内部类

###### 成员内部类

- 不使用`static`修饰的类
- 能访问外层类的所有变量和方法
- 创建语法：`OuterClass.InnerClass inner = new OuterClass().new InnerClass();`
- 内部类中访问外部类的变量使用`OuterClass.this.member`

```java
public class OuterClass {
    private int age = 10;
    private int num = 20;
    public void demo() {
        System.out.println("Outer demo.");
    }

    public class InnerClass{
        private int num;
        public InnerClass(){
            System.out.println("InnerClass 构造函数");
        }
        public void test(){
            System.out.println("Inner test.");
            System.out.println(age);		//可以直接调用外层类的成员
            System.out.println(OuterClass.this.num);//内层外层成员名相同时访问外层类的成员
            demo();	//与变量相同
        }
    }
}
```

```java
public class InnerTest {
    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        inner.test();
    }
}
/**
InnerClass 构造函数
Inner test.
10
20
Outer demo.
*/
```

###### 局部内部类

- 定义在方法或任意的作用域内的内部类
- 不能声明为`public, protected, private, static`

```java
public class OuterClass2 {
    public void test() {
        class InnerClass {
            public void demo() {
                System.out.println("InnerClass demo.");
            }
        }
    }
}
```

###### 匿名内部类

- 没有名字和构造方法的类
- 没有`class, extends, implements`关键字
- 隐式继承一个父类或实现一个接口

```java
public interface Flyable {
    public void fly();
}
```

```java
public class FlyUtil {
    public void test(Flyable flyable) {
        System.out.println("FlyUtil test.");
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        FlyUtil util = new FlyUtil();
        util.test(new Flyable() {  //test调用的即是一个匿名内部类
            @Override
            public void fly() {
                System.out.println("FlyTest fly.");
            }
        });//注意这个分号
    }
}
```

###### 静态成员类

- 也称为嵌套类，使用`static`修饰的类
- 声明在接口和枚举中的类自动就是`public static`修饰
- 创建该类的实例无需创建外部类的实例
- 只能访问外层的静态变量和静态方法
- 创建语法：`OuterClass.InnerClass inner = new OuterClass.InnerClass();`

```java
public class OuterClass {
    private int age = 20;
    private static int num = 10;
    static class InnerClass {
        public void test() {
            //System.out.println(age);不能访问非静态成员
            System.out.println(num);
        }
    }
    
    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.test(); //10
    }
}
```



##### 内部类的几个注意点

- 静态上下文中声明的内部类只能访问外部类的静态属性和方法

  ```java
  public class OuterClass {
      private static int num = 10;
      private int age = 20;
      public static void test() {//这个内部类是在静态方法里声明的，所以只能访问外部类的静态属性和方法
          class InnerClass {
              public void test(){
                  System.out.println(num);//静态属性可以访问
                  System.out.println(age);//非静态属性不能访问
              }
          }
      }
  }
  ```

  

- 内部类中不能声明静态变量和方法

##### 内部类的继承

内部类能继承另一个内部类，其外部类，顶级类（即其他文件的普通类）

```java
public class OuterClass {
    class InnerClass1 {      
    }
    class InnerClass2 extends InnerClass1 {	//继承另一个内部类       
    }
    class InnerClass3 extends OuterClass {	//继承外部类        
    }
    class InnerClass4 extends Test{			//继承顶级类
    }
}
```

```java
public class OuterClass2 {//内部类继承一个不是其外部类的内部类的时候
    class InnerClass extends OuterClass.InnerClass1{//InnerClass在调用其构造方法的时候会去调用父类的构造方法，但是由于InnerClass1是OuterClass的内部类，InnerClass1在调用构造方法的时候会实例化OuterClass，所以必须重写InnerClass的构造方法，显式调用oc.super()
        public InnerClass(OuterClass oc) {
            oc.super();
        }
    }
    
    public static void main(String[] args) {
        OuterClass2.InnerClass inner = new OuterClass2().new InnerClass(new OuterClass2);
    }
}
```

##### 内部类编译后的文件名

- 内部类以外层类的名字，加上**$**（dollor），再加上内部类的名字
- 若是匿名内部类，会产生一个数字作为标识符

##### 接口成员中的嵌套类型

接口中可以声明类和接口，默认修饰符是`public static`

```java
public interface MyInterface {
    class Class1 {
    }
    
    interface Interface1 {
        public void test();
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        MyInterface.Class1 class1 = new MyInterface.Class1();

        MyInterface.Interface1 interface1 = new MyInterface.Interface1() {
            @Override
            public void test() {
                System.out.println(" ");
            }
        };
    }
}

```

##### 回调

- 回调机制可以使用匿名内部类实现
- 在`Swing`和`JavaFX`中使用非常广泛

```java
public interface Callable {
    void call();
}
```

```java
public class Register {
    private Callable c;

    public void register(Callable c) {
        this.c = c;
    }

    public void callBack() {
        c.call();
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Register register = new Register();
        register.register(new Callable() {
            @Override
            public void call() {
                System.out.println("call..");
            }
        });
        register.callBack();
    }
}
```

##### 内部类的好处

- 内部类可以访问该类定义的所在作用域中的数据，包括私有数据
- 内部类可以对同一个包中的其他类隐藏起来
- 当想定义一个回调方法又不想写大量代码时，使用匿名内部类比较便捷

