package com.saugat.springsecuritydemo.controller;

import com.saugat.springsecuritydemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    private final List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student(1, "Saugat", "Java"),
            new Student(2, "Risha", "Python"),
            new Student(3, "Sauwan", "JavaScript")
    ));

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        System.out.println("Request: " + request.getAttribute("_csrf"));
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("students")
    public List<Student> getStudentList(){
        return studentList;
    }

    @PostMapping("students")
    public Student addStudent(@RequestBody Student student){
        studentList.add(student);
        return student;
    }
}
