package com.chaim.coupons.logic;

import com.chaim.coupons.conts.Const;
import com.chaim.coupons.dal.ICompanyDal;
import com.chaim.coupons.dto.CompanyDto;
import com.chaim.coupons.entitys.CompanyEntity;
import com.chaim.coupons.enums.ErrorTypes;
import com.chaim.coupons.exceptions.ServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompaniesLogic {
    private ICompanyDal companyDal;


    @Autowired
    public CompaniesLogic(ICompanyDal companyDal) {
        this.companyDal = companyDal;

    }


    public void createCompany(CompanyEntity company) throws ServerException {
        validateCompany(company);
        if (companyDal.existsByName(company.getName())){
            throw new ServerException(ErrorTypes.COMPANY_NAME_ALREADY_EXIST, company.getName());
        }
        try{
            companyDal.save(company);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Failed to create company " + company.toString() , e );
        }


    }



    public void remove(long id) throws ServerException {
        try{
            companyDal.deleteById(id);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Failed to remove company " + id , e );
        }


    }

    public void update(CompanyEntity company) throws ServerException {
        validateCompany(company);
        if(companyDal.existByCompanyNameOtherId(company.getName(), company.getId())) {
            throw new ServerException(ErrorTypes.COMPANY_NAME_ALREADY_EXIST, company.getName());
        }
        try{
            companyDal.save(company);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Failed to update company " + company.getId() , e );
        }
    }

    public CompanyDto getCompany(long id) throws ServerException {
        CompanyDto company;
        try{
            company = companyDal.findByCompanyId(id);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,  "Error in getCompany(), id = " + id , e );
        }
        return company;

    }

    public List<CompanyDto> getCompanies() throws ServerException {
        List<CompanyDto>companies;

        try {
            companies = companyDal.findCompanies();
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Error in getCompanies" , e );
        }
        return companies;
    }

    private void validateCompany(CompanyEntity company) throws ServerException {
        validateCompanyName(company.getName());
        validateAddress(company.getAddress());
        validatePhoneNumber(company.getPhoneNumber());
    }

    private void validateAddress(String address) throws ServerException {
        if (address == null) {
            throw new ServerException(ErrorTypes.ADDRESS_IS_NULL, address);
        }
        if (address.isEmpty()) {
            throw new ServerException(ErrorTypes.INVALID_ADDRESS, " The address invalid ");
        }

    }

    private void validatePhoneNumber(String phoneNumber) throws ServerException {
        if (phoneNumber.isBlank()) {
            throw new ServerException(ErrorTypes.PHONE_NUMBER_IS_NULL, phoneNumber);
        }
        if (phoneNumber.length() != 10) {
            throw new ServerException(ErrorTypes.INVALID_PHONE_NUMBER, "The phone number  invalid " + phoneNumber);
        }

    }

    private void validateCompanyName(String name) throws ServerException {
        if (name.isBlank()) {
            throw new ServerException(ErrorTypes.COMPANY_NAME_IS_NULL, " The company is null " + name);
        }

    }


}
