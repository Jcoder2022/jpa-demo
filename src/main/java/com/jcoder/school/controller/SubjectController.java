package com.jcoder.school.controller;

import com.jcoder.school.entity.Student;
import com.jcoder.school.entity.Subject;
import com.jcoder.school.entity.Teacher;
import com.jcoder.school.repository.StudentRepository;
import com.jcoder.school.repository.SubjectRepository;
import com.jcoder.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;



    @GetMapping
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrolledStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){

       Optional<Subject> subject = subjectRepository.findById(subjectId);
        Optional<Student> student = studentRepository.findById(studentId);
       subject.get().enrollStudent(student.get());
       return subjectRepository.save(subject.get());
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId){

        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }

}
