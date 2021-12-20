package com.meeraj.sms.dao;

import com.meeraj.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
