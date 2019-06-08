package Annotation;

import Reflection.ReflectionDemo1;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Repeatable(Annocation2s.class)
public @interface Annocation2 {
    String[] value() default {"a", "b"};
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Annocation2s{
     Annocation2[] value();
}