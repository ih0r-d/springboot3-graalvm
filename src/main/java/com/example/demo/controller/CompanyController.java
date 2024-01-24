package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fakes")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("companies")
    public ResponseEntity<List<Company>> createCompanies(@RequestParam(value = "count", required = false, defaultValue = "0") long countOfCompanies) {
        if (countOfCompanies == 0 || countOfCompanies < 0) {
            var company = companyService.createCompany(1);
            return ResponseEntity.ok(List.of(company));
        }
        var companies = companyService.createCompanies(countOfCompanies);
        return ResponseEntity.ok(companies);
    }
}
