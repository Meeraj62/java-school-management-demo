package com.meeraj.sms.controller;

import com.meeraj.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
