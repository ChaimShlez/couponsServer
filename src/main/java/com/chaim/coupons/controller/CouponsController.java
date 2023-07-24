package com.chaim.coupons.controller;

import com.chaim.coupons.dto.CouponDto;
import com.chaim.coupons.entitys.CouponEntity;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.logic.CouponsLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/coupons")
public class CouponsController {
    private CouponsLogic couponsLogic;

    @Autowired
    public CouponsController(CouponsLogic couponsLogic) {
        this.couponsLogic = couponsLogic;
    }

    @PostMapping
    public void createCoupon(@RequestBody CouponEntity coupon) throws ServerException {
        this.couponsLogic.createCoupon(coupon);
    }

    @PutMapping
    public void updateCoupon(@RequestBody CouponEntity coupon) throws ServerException {
        this.couponsLogic.update(coupon);

    }

    @GetMapping("{couponId}")
    public CouponDto getCoupon(@PathVariable("couponId") long couponId) throws ServerException {

        CouponDto coupon = this.couponsLogic.getCoupon(couponId);
        return coupon;

    }

    @GetMapping
    public List<CouponDto> getCoupons(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CouponDto> coupons =this.couponsLogic.getAllCoupon(pageNumber);
        return coupons;
    }
    @GetMapping("/limitedCouponInformation")
    public List<CouponDto> getCouponsLimitInformation(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CouponDto> coupons =this.couponsLogic.getAllCouponLimitInformation(pageNumber);
        return coupons;
    }
    @DeleteMapping("{couponId}")
    public void deleteCoupon(@PathVariable("couponId") long id) throws ServerException {
        this.couponsLogic.remove(id);

    }

    @GetMapping("/byPriceRange")
    public List<CouponDto> getCouponsByPriceRangeByPage(@RequestParam("minPrice") int minPrice, @RequestParam("maxPrice") int maxPrice, @RequestParam("pageNumber") int pageNumber) throws ServerException {

        List<CouponDto> coupons =this.couponsLogic.getAllCouponByPriceRange(minPrice, maxPrice, pageNumber);

        return coupons;

    }

    @GetMapping("/byCategoryId")
    public List<CouponDto> getCouponsByCategoryId(@RequestParam("categoryId") int categoryId, @RequestParam("pageNumber") int pageNumber) throws ServerException {

        List<CouponDto> coupons = couponsLogic.getAllCouponByCategoryId(categoryId, pageNumber);

        return coupons;
    }

    @GetMapping("/byCompanyId")
    public List<CouponDto> getCouponsByCompanyId(@RequestParam("companyId") int companyId, @RequestParam("pageNumber") int pageNumber) throws ServerException {

        List<CouponDto> coupons = couponsLogic.getCouponsByCompanyId(companyId, pageNumber);

        return coupons;
    }

}
