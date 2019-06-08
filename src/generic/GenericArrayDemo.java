package generic;

public class GenericArrayDemo {
    public static void main(String[] args) {
        //Student<String>[] students = new Student<String>[10];
        Student<?>[] students = new Student<?>[10];
        students[0]  = new Student<>();
    }
}


class Student<T> {
    public Student() {
       // T[] t = new T[10];
    }
}