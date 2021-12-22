package com.meeraj.sms.controller;

import com.meeraj.sms.model.Student;
import com.meeraj.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/students")
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
    public String store(Student student, Model model){
        try {
            this.studentService.store(student);
        } catch (Exception e) {
            return "redirect:/create";
        }
        model.addAttribute("students", studentService.getAllStudents());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model){
        try{
             model.addAttribute("student",this.studentService.getStudentById(id));
        }catch (Exception e){
            return "index";
        }

        return "students/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute("student") Student student, Model model){
        try {
            Student oldStudent = this.studentService.getStudentById(id);
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setEmail(student.getEmail());

            this.studentService.update(oldStudent);
            model.addAttribute("students", this.studentService.getAllStudents());

        }catch (Exception e){
            return null;
        }
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String destroy(@PathVariable(value = "id") Long id){
        try{
            Student student = this.studentService.getStudentById(id);
            this.studentService.delete(student);
        }catch (Exception e){
            return null;
        }
        return  "redirect:/";
    }
}
