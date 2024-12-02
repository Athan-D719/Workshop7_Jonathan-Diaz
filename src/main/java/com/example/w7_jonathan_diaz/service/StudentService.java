package com.example.w7_jonathan_diaz.service;

import com.example.w7_jonathan_diaz.entity.Student;
import com.example.w7_jonathan_diaz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Save a new student
    public Student saveStudent(Student student) {
        // Perform validation (optional but recommended)
        validateStudent(student);
        return studentRepository.save(student);
    }

    // Update an existing student
    public Student updateStudent(Integer id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge()); // Ensure all fields are updated
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    // Delete a student by ID
    public void deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    // Validate student fields (optional utility method)
    private void validateStudent(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Student email cannot be null or empty");
        }
        if (student.getAge() == null || student.getAge() <= 0) {
            throw new IllegalArgumentException("Student age must be a positive number");
        }
    }
}
