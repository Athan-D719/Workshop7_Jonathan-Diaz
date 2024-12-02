package com.example.w7_jonathan_diaz.repository;
import com.example.w7_jonathan_diaz.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
}
