package Annotation;

public @interface Version {
    int big();  //这是一个属性，返回值是int, 属性名为big

    int small();

    String name();

    Class c();

    Season s();     //枚举

    Annocation1 a();//注解

    int[] nums();   //数组，只能是一维数组

    Season[] ss();
}

enum Season {
    SPRING, SUMMER
}
