package com.meeraj.sms.service;

import com.meeraj.sms.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAllStudents();

    Student store(Student student);

    Student getStudentById(Long id);

    Student update(Student student);

    void delete(Student student);
}
