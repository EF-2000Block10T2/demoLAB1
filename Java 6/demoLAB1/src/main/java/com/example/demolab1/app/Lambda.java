package com.example.demolab1.app;

import com.example.demolab1.model.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
    static List<Student> list = Arrays.asList(
            new Student("Truong Anh Duc", true, 9.0),
            new Student("Huynh Thi Bao Tran",false,9.2),
            new Student("Pham Tan Tai",true,9.5),
            new Student("Failed student",true,3.5)

    );
    public static void main(String[] args) {
        demo4();
    }
    private static void demo4() {
        Demo4Inter o = x -> System.out.println(x);;
        o.m1(2025);
    }
    private static void demo() {
        Collections.sort(list,(sv1, sv2)-> -sv1.getMarks().compareTo(sv2.getMarks()));
        list.forEach(sv -> {
            System.out.println(">>Name:"+sv.getName());
            System.out.println(">>Marks: "+sv.getMarks());
            System.out.println();
        });
    }

}
@FunctionalInterface
interface Demo4Inter{
    void m1(int x);
    default void m2() {}
    public static void m3() {}
}