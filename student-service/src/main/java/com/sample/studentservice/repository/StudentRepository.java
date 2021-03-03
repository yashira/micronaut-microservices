package com.sample.studentservice.repository;

import com.sample.studentservice.bean.Student;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public Student add(Student student) {
        student.setId((long) students.size() + 1);
        students.add(student);
        return student;
    }

    public Student findById(Long id) {
        Optional<Student> student = students.stream().filter(x -> x.getId().equals(id)).findFirst();
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    public List<Student> findAll() {
        return students;
    }
}
