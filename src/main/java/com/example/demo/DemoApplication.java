package com.example.demo;

import com.example.demo.hints.JacksonRuntimeHints;
import com.example.demo.hints.LiquibaseRuntimeHints;
import com.example.demo.model.Company;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints({LiquibaseRuntimeHints.class, JacksonRuntimeHints.class})
//@RegisterReflectionForBinding(value = Company.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
