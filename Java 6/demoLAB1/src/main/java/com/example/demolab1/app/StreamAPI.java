package com.example.demolab1.app;

import com.example.demolab1.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demolab1.app.Lambda.list;

public class StreamAPI {
    public static void main(String[] args) {
        demo4();
    }
    private static void demo4() {
        double average = list.stream()
                .mapToDouble(sv-> sv.getMarks())
                .average().getAsDouble();
        System.out.println("AVG:" + average);
        double min_marks = list.stream()
                .mapToDouble(sv-> sv.getMarks())
                .min().getAsDouble();
                System.out.println("min_marks: " + min_marks);
        boolean all_pass = list.stream()
                .allMatch(sv-> sv.getMarks() >= 5);
        System.out.println("all_pass: " + all_pass);
        Student min_sv = list.stream()
                .reduce(list.get(0),(min, sv)->sv.getMarks()<min.getMarks()?sv:min);
        System.out.println("min_sv: " + min_sv.getName());
    }

    private static void demo3() {
        List<Student> result =list.stream()
                .filter(sv->sv.getMarks()>=7)
                .peek(sv-> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());
        result.forEach(sv->{
            System.out.println(">>Name: "+sv.getName());
            System.out.println(">>Marks: "+sv.getMarks());
            System.out.println();
        });
    }
    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> result = list.stream()
                .filter(n->n%2==0)
                .map(n->Math.sqrt(n))
                .peek(d->System.out.println(d))
                .collect(Collectors.toList());
    }

    private static void demo1() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5,6);
        stream1.forEach( n ->{
            System.out.println(n);
        });
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        list.stream().forEach(n -> {
            System.out.println(n);
        });
    }
}
