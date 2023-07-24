package com.chaim.coupons.logic;

import com.chaim.coupons.conts.Const;
import com.chaim.coupons.dal.ICouponDal;
import com.chaim.coupons.dto.CouponDto;
import com.chaim.coupons.entitys.CouponEntity;
import com.chaim.coupons.enums.ErrorTypes;
import com.chaim.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class CouponsLogic {
    private ICouponDal couponsDal;


    @Autowired
    public CouponsLogic(ICouponDal couponsDal) {
        this.couponsDal = couponsDal;

    }

    public void createCoupon(CouponEntity coupon) throws ServerException {
        validateCoupon(coupon);
        if (couponsDal.existsByName(coupon.getName())){
            throw new ServerException(ErrorTypes.COUPON_NAME_ALREADY_EXIST, coupon.getName());
        }
        try{
            couponsDal.save(coupon);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"failed to create coupon " + coupon.toString(), e);
        }



    }

    public void remove(Long id) throws ServerException {
        try{
            couponsDal.deleteById(id);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR," The couponId " + id, e);
        }


    }

    public void update(CouponEntity coupon) throws ServerException {
        validateCoupon(coupon);
        try {
            couponsDal.save(coupon);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Failed to update coupons " + coupon.getId(), e);
        }


    }

    public CouponDto getCoupon(long id) throws ServerException {
        CouponDto coupon;
        try {
            coupon=couponsDal.findByCouponId(id);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR," The  couponId " + id, e);
        }

        return  coupon;
    }

    public List<CouponDto> getAllCoupon(int pageNumber) throws ServerException {
        List<CouponDto>coupons;
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            coupons =couponsDal.findCoupons(pageable);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR," The  coupons", e);
        }
        return coupons;
    }
    public List<CouponDto> getAllCouponLimitInformation(int pageNumber) throws ServerException {
        List<CouponDto>coupons;
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            coupons =couponsDal.findCouponsLimitInformation(pageable);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR," The  coupons", e);
        }
        return coupons;
    }

    public List<CouponDto> getAllCouponByCategoryId(int categoryId, int pageNumber) throws ServerException {
        List<CouponDto>coupons;
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            coupons =couponsDal.findCouponsByCategoryId(categoryId,pageable);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR," The category_id " + categoryId, e);
        }

        return coupons;
    }

    public List<CouponDto> getAllCouponByPriceRange(int minPrice, int maxPrice, int pageNumber) throws ServerException {
        List<CouponDto>coupons;
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            coupons =couponsDal.findCouponsByPriceRange(minPrice,maxPrice,pageable);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Error in getCoupons() = ", e);
        }

        return coupons;
    }

    public void deleteExpireCoupon(Date date) throws ServerException {
        try {
            couponsDal.deleteByEndDateBefore(date);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Failed to delete coupon by date of coupon  ", e);
        }


    }

    public List<CouponDto> getCouponsByCompanyId(long companyId, int pageNumber) throws ServerException {
        List<CouponDto>coupons;
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            coupons =couponsDal.findCouponsByCompanyId(companyId, pageable);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, " The companyId " + companyId, e);
        }

        return coupons;
    }


    private void validateCoupon(CouponEntity coupon) throws ServerException {
        validatePrice(coupon.getPrice());
        validateStartDate(coupon.getStartDate(), coupon.getEndDate());
    }

    private void validateStartDate(Date startDate, Date endDate) throws ServerException {
        if (startDate.after(endDate)) {
            throw new ServerException(ErrorTypes.INVALID_START_DATE, " The start date " + startDate);
        }

    }

    private void validatePrice(float price) throws ServerException {
        if (price <= 0) {
            throw new ServerException(ErrorTypes.INVALID_PRICE, "The price invalid " + price);
        }
    }
}
