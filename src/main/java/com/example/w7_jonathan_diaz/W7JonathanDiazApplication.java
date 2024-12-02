package com.example.w7_jonathan_diaz;


import com.example.w7_jonathan_diaz.entity.Student;
import com.example.w7_jonathan_diaz.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class W7JonathanDiazApplication {

	public static void main(String[] args) {
		// Start the Spring Boot application context
		ApplicationContext context = SpringApplication.run(W7JonathanDiazApplication.class, args);

		// Get the StudentService bean
		StudentService studentService = context.getBean(StudentService.class);

		// 1. Add new students
		Student student1 = new Student();
		student1.setName("Alexander Hamilton");
		student1.setAge(20);
		student1.setEmail("alex.ham@gmail.com");
		Student savedStudent1 = studentService.saveStudent(student1);
		System.out.println("Added Student: " + savedStudent1);

		Student student2 = new Student();
		student2.setName("Julian Chau");
		student2.setAge(22);
		student2.setEmail("julian.chau@gmail.com");
		Student savedStudent2 = studentService.saveStudent(student2);
		System.out.println("Added Student: " + savedStudent2);

		Student student3 = new Student();
		student3.setName("Monica Ramirez");
		student3.setAge(22);
		student3.setEmail("moni.ram@gmail.com");
		Student savedStudent3 = studentService.saveStudent(student3);
		System.out.println("Added Student: " + savedStudent3);

		// 2. Retrieve and print all students
		System.out.println("All Students: " + studentService.getAllStudents());

		// 3. Retrieve Monica:
		Integer monica = savedStudent3.getAge();
		System.out.println("What's Monica's Age? " + monica);

		// 4. Retrieve Julian's email:
		String julian = savedStudent2.getEmail();
		System.out.println("What's Julian's Email? " + julian);

		// 4. Retrieve Julian's email:
		Integer student1_ = savedStudent1.getId();
		System.out.println("What's Alexander Hamilton's ID?" + student1_);

		// 5. Update a student
		Student updateStudent = new Student();
		updateStudent.setName("Alexander Hamilton 2.0");
		updateStudent.setAge(21);
		updateStudent.setEmail("alexa.hamil@gmail.com");

		//6. Updating Alexander Hamilton into a new student
		Student updatedStudent = studentService.updateStudent(savedStudent1.getId(), updateStudent);
		System.out.println("Updated Student: " + updatedStudent);

		//7. Deleting Julian Chau
		studentService.deleteStudent(savedStudent2.getId());
		System.out.println("Deleted Student with ID: " + savedStudent2.getId());

		//8. Print all students after deletion
		System.out.println("All Students after Deletion: " + studentService.getAllStudents());
	}
}
