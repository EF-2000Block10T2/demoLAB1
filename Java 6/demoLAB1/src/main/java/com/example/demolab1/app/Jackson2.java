package com.example.demolab1.app;

import com.example.demolab1.model.Contact;
import com.example.demolab1.model.Student;
import com.example.demolab1.model.Student2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

import java.util.*;

public class Jackson2 {
    public static void main(String[] args) throws Exception {
        demo7();
    }
    public static void demo7() throws Exception{
        Contact contact = new Contact("quang@gmail.com","019181717",null);
        List<String> subjects = Arrays.asList("WEB205", "ENG201");
        Student2 student = new Student2("Nguyen Dang Vinh Quang", true, 8.9, contact, subjects);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
        mapper.writeValue(new File("d:/studentQ2.json"), student);
    }

    public static void demo6() throws Exception {
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("email","hoangbeo@gmail.com");
        contact.put("phone", "01938382372");
        List<String> subjects = Arrays.asList("FAT101","LIGMA102");

        Map<String, Object> student = new HashMap<String,Object>();
        student.put("name","Nguyen Dang Vinh Quang");
        student.put("marks", 8.9);
        student.put("gender", true);
        student.put("contact", contact);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        mapper.writeValue(System.out, student);
        mapper.writeValue(new File("d:/studentQ.json"), student);
    }

    public static void demo5() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Dinh Pham Le Hoang");
        student.put("marks", 9.4);
        student.put("gender", true);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "fatNigger@gmail.com");
        contact.put("phone", "101010101001");
        ArrayNode subjects = student.putArray("subjects");
        subjects.add("LIGMA101");
        subjects.add("RETARD101");
        String json = mapper.writeValueAsString(student);
        mapper.writeValue(System.out, student);
        mapper.writeValue(new File("d:/student.json"), student);
    }

    public static void demo4() throws Exception {
        String json = "D:\\Java 6\\demoLAB1\\src\\main\\resources\\students.json";
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {};
        ObjectMapper mapper = new ObjectMapper();
        List<Student2> students = mapper.readValue(new File(json), type);
        students.forEach(student -> {
            System.out.println(">>Name: " + student.getName());
        });
    }

    public static void demo3() throws Exception {
        String json = "D:\\Java 6\\demoLAB1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(json), Student2.class);

        System.out.println(">>Name: " + student.getName());
        System.out.println(">>Marks: " + student.getMarks());
        System.out.println(">>Gender: " + student.getGender());
        Contact contact = student.getContact();
        System.out.println(">>Email: " + contact.getEmail());
        System.out.println(">>Phone: " + contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(subject -> {
            System.out.println(">>Subject: " + subject);
        });
    }

    public static void demo2() throws Exception {
        String json = "D:\\Java 6\\demoLAB1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(json), List.class);
        students.forEach(student -> {
            System.out.println(">>Name: " + student.get("name"));
            System.out.println(">>Gender: " + student.get("gender"));
            System.out.println(">>Marks: " + student.get("marks"));
            Map<String, Object> contact = (Map<String, Object>) student.get("contact");
            System.out.println(">>Email: " + contact.get("email"));
            System.out.println(">>Phone: " + contact.get("phone"));
            List<String> subjects = (List<String>) student.get("subjects");
            subjects.forEach(subject ->
                    System.out.println(">>Subject: " + subject)
            );
            System.out.println();
        });
    }

    public static void demo1() throws Exception {
        String json = "D:\\Java 6\\demoLAB1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(json), Map.class);

        System.out.println(">>Name: " + student.get("name"));
        System.out.println(">>Gender: " + student.get("gender"));
        System.out.println(">>Marks: " + student.get("marks"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">>Email: " + contact.get("email"));
        System.out.println(">>Phone: " + contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(subject ->
                System.out.println(">>Subject: " + subject)
        );

    }
}

