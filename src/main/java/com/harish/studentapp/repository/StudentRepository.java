package com.harish.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.studentapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainingIgnoreCase(String name);
}
