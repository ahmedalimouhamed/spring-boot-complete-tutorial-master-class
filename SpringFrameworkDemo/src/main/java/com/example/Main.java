package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

public class Main {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Doctor doctor = context.getBean(Doctor.class);
        //Staff doctor = (Doctor) context.getBean("doctor");
        //Staff nurse = context.getBean(Nurse.class);
        doctor.assist();
        doctor.setQualification("MBBS");
       /* System.out.println(doctor);
        //System.out.println(doctor.getQualification());
        nurse.assist();

        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);*/
    }
}