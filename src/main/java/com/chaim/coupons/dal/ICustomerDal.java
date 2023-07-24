package com.chaim.coupons.dal;

import com.chaim.coupons.dto.CouponPurchaseDto;
import com.chaim.coupons.dto.CustomerDto;
import com.chaim.coupons.entitys.CustomerEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerDal extends CrudRepository<CustomerEntity, Long> {
    @Query("SELECT new com.chaim.coupons.dto.CustomerDto" +
            "(cu.id,u.userName,u.firstName,u.lastName, cu.address,cu.phoneNumber) "
            + "FROM CustomerEntity cu  INNER JOIN UserEntity u on cu.user.id=u.id   where cu.id = :id")
    CustomerDto findByCustomerId(@Param("id")long id);
    @Query("SELECT new com.chaim.coupons.dto.CustomerDto" +
            "(cu.id,u.userName,u.firstName,u.lastName,cu.address,cu.phoneNumber) "
            + "FROM CustomerEntity cu INNER JOIN UserEntity u on cu.user.id=u.id ")
    List<CustomerDto> findCustomers(Pageable pageable);

}
