package com.chaim.coupons.dal;

import com.chaim.coupons.dto.CouponDto;
import com.chaim.coupons.entitys.CouponEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ICouponDal extends CrudRepository<CouponEntity, Long> {
    @Query("SELECT new com.chaim.coupons.dto.CouponDto" +
            "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,cou.imgUrl,co.id,co.name,ca.id,ca.name) "
            + "FROM CouponEntity cou INNER JOIN CompanyEntity co on cou.company.id=co.id INNER JOIN " +
            "CategoryEntity ca on cou.category.id =ca.id  where cou.id= :id")
    CouponDto findByCouponId(@Param("id") long id);

    @Query("SELECT new com.chaim.coupons.dto.CouponDto" +
            "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,cou.imgUrl,co.id,co.name,ca.id,ca.name) "
            + "FROM CouponEntity cou INNER JOIN CompanyEntity co on cou.company.id=co.id INNER JOIN" +
            " CategoryEntity ca on cou.category.id =ca.id ")
    List<CouponDto> findCoupons(Pageable pageable);
    @Query("SELECT new com.chaim.coupons.dto.CouponDto" +
            "(cou.id,cou.name,cou.price,cou.imgUrl,cou.endDate) "
            + "FROM CouponEntity cou " )

    List<CouponDto> findCouponsLimitInformation(Pageable pageable);
    @Query("SELECT new com.chaim.coupons.dto.CouponDto" +
            "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,cou.imgUrl,co.id,co.name,ca.id,ca.name) "
            + "FROM CouponEntity cou INNER JOIN CompanyEntity co on cou.company.id=co.id INNER JOIN" +
            " CategoryEntity ca on cou.category.id =ca.id where cou.category.id = :categoryId")
    List<CouponDto> findCouponsByCategoryId(@Param("categoryId") long categoryId, Pageable pageable);

    @Query("SELECT new com.chaim.coupons.dto.CouponDto" +
            "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,cou.imgUrl,co.id,co.name,ca.id,ca.name) "
            + "FROM CouponEntity cou INNER JOIN CompanyEntity co on cou.company.id=co.id INNER JOIN" +
            " CategoryEntity ca on cou.category.id =ca.id where price BETWEEN :minPrice AND :maxPrice")
    List<CouponDto> findCouponsByPriceRange(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice, Pageable pageable);

    @Query("SELECT new com.chaim.coupons.dto.CouponDto" +
            "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,cou.imgUrl,co.id,co.name,ca.id,ca.name) "
            + "FROM CouponEntity cou INNER JOIN CompanyEntity co on cou.company.id=co.id INNER JOIN" +
            " CategoryEntity ca on cou.category.id =ca.id  where cou.company.id = :companyId")
    List<CouponDto> findCouponsByCompanyId(@Param("companyId") long companyId, Pageable pageable);
       //
    @Transactional
    void deleteByEndDateBefore(@Param("endDate")Date endDate);

    boolean existsByName(@Param("name")String name);
}
