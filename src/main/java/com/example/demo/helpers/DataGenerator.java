package com.example.demo.helpers;

import com.example.demo.model.Company;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DataGenerator {

    private static final String[] COMPANY_NAMES = {"ABC Corporation", "XYZ Enterprises", "Smith & Co", "Johnson Ltd", "Green Innovations"};
    private static final String[] INDUSTRIES = {"Technology", "Finance", "Healthcare", "Retail", "Manufacturing"};
    private static final String[] PROFESSIONS = {"Software Engineer", "Financial Analyst", "Doctor", "Retail Manager", "Mechanical Engineer"};

    private final Random random;

    public DataGenerator() {
        this.random = new Random();
    }

    public Company createCompany(long id){
        String name = getRandomCompanyName();
        String industry = getRandomIndustry();
        String profession = getRandomProfession();

        return Company.builder()
                .id(id)
                .name(name)
                .industry(industry)
                .profession(profession)
                .build();
    }

    private String getRandomCompanyName() {
        return COMPANY_NAMES[random.nextInt(COMPANY_NAMES.length)];
    }

    private String getRandomIndustry() {
        return INDUSTRIES[random.nextInt(INDUSTRIES.length)];
    }

    private String getRandomProfession() {
        return PROFESSIONS[random.nextInt(PROFESSIONS.length)];
    }
}