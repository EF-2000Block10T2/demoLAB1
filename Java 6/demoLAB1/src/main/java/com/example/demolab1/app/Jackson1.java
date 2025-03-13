package com.example.demolab1.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Jackson1 {
    public static void main(String[] args) throws Exception {
        demo2();
    }
    private static void demo2() throws Exception {
        String json = "D:\\Java 6\\demoLAB1\\src\\main\\resources\\students.json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(json) );
        students.iterator().forEachRemaining(student -> {
            System.out.println(">>Name: " + student.get("name").asText());
            System.out.println(">>Gender: " + student.get("gender").asBoolean());
            System.out.println(">>Marks: " + student.get("marks").asDouble());
            System.out.println(">>Email: " + student.get("contact").get("email").asText());
            System.out.println(">>Phone: " + student.get("contact").get("phone").asText());

            student.get("subjects").forEach(subject ->
                    System.out.println(">>Subject: " + subject.asText())
            );
            System.out.println();
        });
    }
    private static void demo1() throws Exception {
        String json = "D:\\Java 6\\demoLAB1\\src\\main\\resources\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(json) );

        System.out.println(">>Name: " + student.get("name").asText());
        System.out.println(">>Gender: " + student.get("gender").asBoolean());
        System.out.println(">>Marks: " + student.get("marks").asDouble());
        System.out.println(">>Email: " + student.get("contact").get("email").asText());
        System.out.println(">>Phone: " + student.get("contact").get("phone").asText());

        student.get("subjects").forEach(subject ->
                System.out.println(">>Subject: " + subject.asText())
        );
    }

}
