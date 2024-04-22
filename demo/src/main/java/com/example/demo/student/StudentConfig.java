package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// config file in this case contains the mock data but it could also be used for
//others usecases, eg. lifecyles actions, if we want sth happening at @Before... and so on
@Configuration
public class StudentConfig {
    @Bean //component annotation, necessary to make dependency injections
    //Refers to a Java object managed by Spring framework
    //CommandLineRunner is an interface of Spring. It defines a callback methode which is
    //executed after the Spring Boot application has started.
    //It has a single methode called run(), it can be used to initialize data among others.
    //We can create a bean that implements the interface and annotate it with @configuration or @component
    //Spring boot will detect the bean and invoke its run() at startup.
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5));

            repository.saveAll(
                    List.of(mariam, alex)
            );

        };
    }
}

//@value is another type of annotation, e.g. when working with configuration yaml files
//in testing env or prod env, we can define it with this.
