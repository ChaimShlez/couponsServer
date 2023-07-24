package com.chaim.coupons.dal;

import com.chaim.coupons.dto.CouponPurchaseDto;
import com.chaim.coupons.dto.CustomerPurchasesDto;
import com.chaim.coupons.entitys.PurchaseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IPurchaseDal extends CrudRepository<PurchaseEntity, Long> {
    @Query("SELECT new com.chaim.coupons.dto.CouponPurchaseDto" +
            "(p.id,c.id,c.name,p.timestamp,p.amount,c.imgUrl) "
            + "FROM PurchaseEntity p INNER JOIN CouponEntity c on p.coupon.id=c.id  where p.id = :id")
    CouponPurchaseDto findPurchaseById(@Param("id")long id);
    @Query("SELECT new com.chaim.coupons.dto.CouponPurchaseDto" +
            "(pu.id,c.id,c.name ,c.description,c.price,c.startDate," +
            "pu.coupon.endDate,pu.timestamp,pu.amount,c.imgUrl,u.firstName,u.lastName,cu.address, cu.phoneNumber) "
            + "FROM PurchaseEntity pu INNER JOIN CouponEntity c on pu.coupon.id=c.id " +
            " INNER JOIN CustomerEntity cu on pu.customer.id=cu.id " +
            "             INNER JOIN UserEntity u on cu.user.id =u.id   where pu.id = :purchaseId")
    CouponPurchaseDto getExtendedOnMyPurchase(@Param("purchaseId")long purchaseId);
    @Query("SELECT new com.chaim.coupons.dto.CouponPurchaseDto" +
            "(pu.id,c.id,c.name,c.description,c.price,c.startDate," +
            "pu.coupon.endDate,pu.timestamp,pu.amount,c.imgUrl,u.firstName,u.lastName,cu.address, cu.phoneNumber) "
            + "FROM PurchaseEntity pu INNER JOIN CouponEntity c on pu.coupon.id=c.id " +
            " INNER JOIN CustomerEntity cu on pu.customer.id=cu.id " +
            " INNER JOIN UserEntity u on cu.user.id =u.id where pu.customer.id = :customerId")
    List<CouponPurchaseDto> extendedOnMyPurchases(@Param("customerId")long customerId, Pageable pageable);
    @Query("SELECT new com.chaim.coupons.dto.CouponPurchaseDto" +
            "(pu.id,c.id,c.name,c.description,c.price,c.startDate," +
            "pu.coupon.endDate,pu.timestamp,pu.amount,c.imgUrl,u.firstName,u.lastName,cu.address, cu.phoneNumber) "
            + "FROM PurchaseEntity pu INNER JOIN CouponEntity c on pu.coupon.id=c.id " +
            " INNER JOIN CustomerEntity cu on pu.customer.id=cu.id " +
            " INNER JOIN UserEntity u on cu.user.id =u.id ")
    List<CouponPurchaseDto> getAllPurchases(Pageable pageable);


    @Query("SELECT new com.chaim.coupons.dto.CouponPurchaseDto" +
            "(p.id,c.id,c.name,p.timestamp,p.amount,c.imgUrl) "
            + "FROM PurchaseEntity p INNER JOIN CouponEntity  c on p.coupon.id=c.id  where p.customer.id = :customerId")
    List<CouponPurchaseDto> findByCustomerId(@Param("customerId")long customerId, Pageable pageable);
    @Query("SELECT new com.chaim.coupons.dto.CustomerPurchasesDto" +
            "(pu.id,u.firstName,u.lastName,cu.address, cu.phoneNumber, co.name , pu.timestamp,pu.amount) "
            + "FROM PurchaseEntity pu INNER JOIN CouponEntity co  on pu.coupon.id=co.id" +
            " INNER JOIN CustomerEntity cu on pu.customer.id=cu.id " +
            " INNER JOIN UserEntity u on cu.user.id =u.id  where co.company.id = :companyId")
    List<CustomerPurchasesDto> findByCompanyId(@Param("companyId")long companyId, Pageable pageable);

}
