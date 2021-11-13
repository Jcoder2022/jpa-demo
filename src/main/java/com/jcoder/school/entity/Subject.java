package com.jcoder.school.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name="student_enrolled",
            joinColumns = @JoinColumn(name= "subject_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")

    )
    private Set<Student> enrolledStudents = new HashSet<Student>();


    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }


    public void enrollStudent(Student student) {
        this.enrolledStudents.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher =teacher;
    }
}
