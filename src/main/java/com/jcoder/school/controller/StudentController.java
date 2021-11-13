package com.jcoder.school.controller;

import com.jcoder.school.entity.Student;
import com.jcoder.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
