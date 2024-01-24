package com.example.demo.service;

import com.example.demo.helpers.DataGenerator;
import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final DataGenerator generator;
    private final CompanyRepository companyRepository;

    public Company createCompany(long id){
        var company = generator.createCompany(id);
        return companyRepository.save(company);
    }

    public List<Company> createCompanies(long count){
        var companies = LongStream.range(1, count)
                .mapToObj(generator::createCompany)
                .toList();
        return companyRepository.saveAll(companies);
    }

}
