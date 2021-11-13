package com.jcoder.school.repository;

import com.jcoder.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByName(String name);
}
