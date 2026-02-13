package com.harish.studentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.harish.studentapp.entity.Student;
import com.harish.studentapp.repository.StudentRepository;

@Controller
public class StudentsPageController {

    @Autowired
    private StudentRepository studentRepository;

    // ✅ Show page
    @GetMapping("/students-page")
    public String studentsPage(Model model) {

        List<Student> students = studentRepository.findAll();

        model.addAttribute("students", students);
        model.addAttribute("student", new Student());

        return "students";
    }

    // ✅ ADD & UPDATE (same method works for both)
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {

        studentRepository.save(student);

        return "redirect:/students-page";
    }

    // ✅ DELETE
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        studentRepository.deleteById(id);

        return "redirect:/students-page";
    }

    // ✅ EDIT (load selected student into form)
    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Integer id, Model model) {

        Student student = studentRepository.findById(id).orElse(null);
        List<Student> students = studentRepository.findAll();

        model.addAttribute("student", student);
        model.addAttribute("students", students);

        return "students";
    }
}
