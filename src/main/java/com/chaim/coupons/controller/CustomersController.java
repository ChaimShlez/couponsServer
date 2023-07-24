package com.chaim.coupons.controller;

import com.chaim.coupons.dto.CustomerDto;
import com.chaim.coupons.entitys.CustomerEntity;
import com.chaim.coupons.enums.UserType;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.logic.CustomersLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    private CustomersLogic customersLogic;

    @Autowired
    public CustomersController(CustomersLogic customersLogic) {
        this.customersLogic = customersLogic;
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerEntity customer) throws ServerException {
        customer.getUser().setType(UserType.CUSTOMER);
        this.customersLogic.addCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerEntity customer) throws ServerException {
        customer.getUser().setType(UserType.CUSTOMER);
        this.customersLogic.update(customer);
    }

    @GetMapping("{customerId}")
    public CustomerDto getCustomer(@PathVariable("customerId") long id) throws ServerException {

        CustomerDto customer = this.customersLogic.getCustomer(id);
        return customer;

    }

    @GetMapping
    public Iterable<CustomerDto> getCustomers(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CustomerDto> customers = this.customersLogic.getCustomersByPage(pageNumber);
        return customers;


    }

    @DeleteMapping("{customerId}")
    public void deleteCoupon(@PathVariable("customerId")long id) throws ServerException {
        this.customersLogic.remove(id);
    }
}