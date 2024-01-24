package com.example.demo.helpers;

import com.example.demo.model.Company;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class DataGenerator {

    private final Faker faker;

    public DataGenerator() {
        this.faker = new Faker();
    }

    public Company createCompany(long id){
        var fakeCompany = faker.company();
        return Company.builder()
                .id(id)
                .name(fakeCompany.name())
                .industry(fakeCompany.industry())
                .profession(fakeCompany.profession())
                .build();
    }
}
