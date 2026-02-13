package com.harish.studentapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.harish.studentapp.entity.Student;
import com.harish.studentapp.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
}
