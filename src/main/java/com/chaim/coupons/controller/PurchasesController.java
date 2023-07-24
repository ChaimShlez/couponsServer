package com.chaim.coupons.controller;

import com.chaim.coupons.dto.CouponPurchaseDto;
import com.chaim.coupons.dto.CustomerPurchasesDto;
import com.chaim.coupons.entitys.PurchaseEntity;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.logic.PurchasesLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private PurchasesLogic purchasesLogic;

    @Autowired
    public PurchasesController(PurchasesLogic purchasesLogic) {
        this.purchasesLogic = purchasesLogic;
    }

    @PostMapping
    public void createPurchase(@RequestHeader String authorization, @RequestBody PurchaseEntity purchase) throws ServerException {
        Calendar today = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jerusalem"));

        Date date = today.getTime();
        purchase.setTimestamp(date);
        this.purchasesLogic.addPurchases(purchase,authorization);
    }

    @DeleteMapping("{purchaseId}")
    public void deletePurchase(@PathVariable("purchaseId") long id) throws ServerException {
        this.purchasesLogic.remove(id);

    }

    @GetMapping("{purchaseId}")
    public CouponPurchaseDto getPurchase(@PathVariable("purchaseId") int id) throws ServerException {
        CouponPurchaseDto couponPurchaseDto = this.purchasesLogic.getPurchase(id);
        return couponPurchaseDto;
    }
    @GetMapping("/getExtendedOnPurchase")
    public CouponPurchaseDto getExtendedNyPurchase(@RequestParam("purchaseId") long purchaseId )throws ServerException {
        CouponPurchaseDto couponPurchaseDto = purchasesLogic.getExtendedOnPurchase(purchaseId);
        return couponPurchaseDto;

    }
    @GetMapping("/getMyPurchases")
    public  List<CouponPurchaseDto> getMyPurchases(@RequestParam("customerId") int customerId, @RequestParam("pageNumber") int pageNumber) throws ServerException {
       List<CouponPurchaseDto> couponPurchaseDto = purchasesLogic.getPurchasesByCustomerId(customerId, pageNumber);
        return couponPurchaseDto;

    }
    @GetMapping("/getExtendedPurchases")
    public  List<CouponPurchaseDto> getExtendedMyPurchases(@RequestParam("customerId")int customerId, @RequestParam("pageNumber") int pageNumber)throws ServerException {
        List <CouponPurchaseDto> couponPurchaseDto = purchasesLogic.getExtendedOnPurchases(customerId,pageNumber);
        return couponPurchaseDto;

    }
    @GetMapping
    public  List<CouponPurchaseDto> getAllPurchases( @RequestParam("pageNumber") int pageNumber)throws ServerException {
        List <CouponPurchaseDto> couponPurchaseDto = purchasesLogic.getAllPurchases(pageNumber);
        return couponPurchaseDto;

    }

    @GetMapping("/getPurchaseByCompanyId")
    public  List<CustomerPurchasesDto> getPurchasesByCompanyIdByPageNumber(@RequestParam("companyId") long companyId, @RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CustomerPurchasesDto>customerPurchasesDto=purchasesLogic.getAllPurchasesByCompanyId(companyId, pageNumber);
        return customerPurchasesDto;
    }


}
