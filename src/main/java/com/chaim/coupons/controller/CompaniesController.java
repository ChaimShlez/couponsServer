package com.chaim.coupons.controller;


import com.chaim.coupons.dto.CompanyDto;
import com.chaim.coupons.entitys.CompanyEntity;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.logic.CompaniesLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    private CompaniesLogic companiesLogic;

    @Autowired
    public CompaniesController(CompaniesLogic companiesLogic) {
        this.companiesLogic = companiesLogic;
    }

    @PostMapping
    public void createCompany(@RequestBody CompanyEntity company) throws ServerException {
        this.companiesLogic.createCompany(company);
    }

    @PutMapping
    public void updateCompany(@RequestBody CompanyEntity company) throws ServerException {
        this.companiesLogic.update(company);

    }

    @GetMapping("{companyId}")
    public CompanyDto getCompany(@PathVariable("companyId") long id) throws ServerException {

        CompanyDto company = this.companiesLogic.getCompany(id);
        return company;

    }

    @GetMapping
    public List<CompanyDto> getCompanies() throws ServerException {

        List<CompanyDto> companies = this.companiesLogic.getCompanies();
        return companies;

    }

    @DeleteMapping("{companyId}")
    public void deleteCompany(@PathVariable("companyId") long id) throws ServerException {
        this.companiesLogic.remove(id);

    }


}

