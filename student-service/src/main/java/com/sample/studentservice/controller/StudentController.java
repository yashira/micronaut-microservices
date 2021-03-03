package com.sample.studentservice.controller;

import com.sample.studentservice.bean.Student;
import com.sample.studentservice.repository.StudentRepository;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@Controller("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Inject
    StudentRepository studentRepository;

    @Post
    public Student add(@Body Student student) {
        LOGGER.info("Student add: {}", student);
        return studentRepository.add(student);
    }

    @Get
    public List<Student> findAll() {
        LOGGER.info("Students find");
        return studentRepository.findAll();
    }

    @Get("/{id}")
    public Student findById(Long id) {
        LOGGER.info("Student find: id={}", id);
        return studentRepository.findById(id);
    }
}