package com.chaim.coupons.dal;

import com.chaim.coupons.dto.CategoryDto;
import com.chaim.coupons.dto.CompanyDto;
import com.chaim.coupons.entitys.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryDal extends CrudRepository<CategoryEntity, Long> {
    @Query("SELECT new com.chaim.coupons.dto.CategoryDto(ca.id,ca.name)" +
             "FROM CategoryEntity ca   where ca.id = :id")
    CategoryDto findById(@Param("id")long id);
    @Query("SELECT new com.chaim.coupons.dto.CategoryDto(ca.id,ca.name)" +
            "FROM CategoryEntity ca ")
    List<CategoryDto> findCategories();
}
