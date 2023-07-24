package com.chaim.coupons.logic;

import com.chaim.coupons.conts.Const;
import com.chaim.coupons.dal.ICustomerDal;
import com.chaim.coupons.dto.CustomerDto;
import com.chaim.coupons.dto.UserDto;
import com.chaim.coupons.entitys.CustomerEntity;
import com.chaim.coupons.enums.ErrorTypes;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomersLogic {
    private ICustomerDal customerDal;
    private UsersLogic usersLogic;

    @Autowired
    public CustomersLogic(ICustomerDal customerDal,UsersLogic usersLogic) {
        this.customerDal = customerDal;
        this.usersLogic=usersLogic;

    }


    public void addCustomer(CustomerEntity customer) throws ServerException {
        validateCustomer(customer);
        usersLogic.validateUser(customer.getUser());
        usersLogic.existByUserName(customer.getUser().getUserName());
        String hexString= HashUtils.computeSHA256Hash(customer.getUser().getPassword());
        customer.getUser().setPassword(hexString);

        try {
              customerDal.save(customer);
          }catch (Exception e){
              throw new ServerException(ErrorTypes.GENERAL_ERROR,"Failed to create customer " + customer.toString(), e);
          }


    }

    public CustomerDto getCustomer(Long id) throws ServerException {
        CustomerDto customer;
        try {
            customer = customerDal.findByCustomerId(id);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Error in getCustomer(), id = " + id, e);
        }
        return customer;
    }

    public void remove(long id) throws ServerException {
        try {
            customerDal.deleteById(id);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Failed to remove customer " + id, e);
        }


    }

    public void update(CustomerEntity customer) throws ServerException {
        validateCustomer(customer);
        UserDto user=usersLogic.getUser(customer.getUser().getId());
        customer.getUser().setUserName(user.getUserName());
        customer.getUser().setPassword(user.getPassword());
       usersLogic.existByUserNameOtherId(customer.getUser().getUserName(), customer.getId());
        try {
            customerDal.save(customer);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Failed to update customer " + customer.getUser().getId(), e);
        }


    }

    public List<CustomerDto> getCustomersByPage(int pageNumber) throws ServerException {
        List<CustomerDto> customers;
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            customers = customerDal.findCustomers(pageable);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Error in getCustomers", e);
        }

        return customers;
    }

    private void validateCustomer(CustomerEntity customer) throws ServerException {
        validatePhoneNumber(customer.getPhoneNumber());
        validateAddress(customer.getAddress());
    }

    private void validateAddress(String address) throws ServerException {
        if (address.isBlank()) {
            throw new ServerException(ErrorTypes.ADDRESS_IS_NULL, " The address is null " + address);
        }
    }

    private void validatePhoneNumber(String phoneNumber) throws ServerException {
        if (phoneNumber.isBlank()) {
            throw new ServerException(ErrorTypes.PHONE_NUMBER_IS_NULL, "The phone number is null " + phoneNumber);
        }
        if (phoneNumber.length() != 10) {
            throw new ServerException(ErrorTypes.INVALID_PHONE_NUMBER, " The  phone number invalid " + phoneNumber);
        }
    }

}
