package com.example.spring.data.jpa.tutorial.repository;

import com.example.spring.data.jpa.tutorial.entity.Guardian;
import com.example.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("test@gmail.com")
                .firstName("test")
                .lastName("test")
                //.guardianName("guardian_name")
                //.guardianEmail("guardian@gmail.com")
                //.guardianMobile("055055055")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetails(){
        Guardian guardian = Guardian.builder()
                .name("guardian_name")
                .email("guardian@gmail.com")
                .mobile("055055055")
                .build();

        Student student = Student.builder()
                .firstName("chouaib")
                .lastName("meliani")
                .emailId("meliani@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("chouaib");
        System.out.println("students = "+students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ch");
        System.out.println("students = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("guardian_name");
        System.out.println("students = "+students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("meliani@gmail.com");
        System.out.println("student = "+studentFirstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("meliani@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("meliani@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("ahmed ahmed", "meliani@gmail.com");
    }
}