package com.meeraj.sms.service;

import com.meeraj.sms.dao.StudentRepository;
import com.meeraj.sms.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student store(Student student){
        return this.studentRepository.save(student);
    }
}
