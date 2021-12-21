package com.meeraj.sms.controller;

import com.meeraj.sms.model.Student;
import com.meeraj.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "students/create";
    }

    @PostMapping("/store")
    public String store(@RequestBody Student student, Model model){
        try {
            this.studentService.store(student);
        } catch (Exception e) {
            return "index";
        }
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
}
