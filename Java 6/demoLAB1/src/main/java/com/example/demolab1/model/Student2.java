package com.example.demolab1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    String name;
    Boolean gender = false;
    Double marks = 0.0;
    Contact contact;
    List<String> subjects;
}
