package com.meeraj.sms;

import com.meeraj.sms.dao.StudentRepository;
import com.meeraj.sms.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementSystemApplication.class, args);
    }

    private StudentRepository studentRepository;
    public SchoolManagementSystemApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student(1,"Meeraj","Adhikari","atifmeeraj62@gmail.com");
//        this.studentRepository.save(student1);
//
//        Student student2 = new Student(2, "Kushraj", "Rimal", "kushraj1204@gmail.com");
//        this.studentRepository.save(student2);
//
//        Student student3 = new Student(3, "Atif", "Aslam", "atif62@gmail.com");
//        this.studentRepository.save(student3);
    }
}
