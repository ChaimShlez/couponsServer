package com.chaim.coupons.dal;

import com.chaim.coupons.dto.CompanyDto;
import com.chaim.coupons.entitys.CompanyEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompanyDal extends CrudRepository<CompanyEntity, Long> {
    @Query("SELECT new com.chaim.coupons.dto.CompanyDto" +
            "(co.id,co.name,co.address,co.phoneNumber) "
            + "FROM CompanyEntity co   where co.id = :id")
    CompanyDto findByCompanyId(@Param("id")long id);
    @Query("SELECT new com.chaim.coupons.dto.CompanyDto" +
            "(co.id,co.name,co.address,co.phoneNumber) "
            + "FROM CompanyEntity co ")
    List<CompanyDto> findCompanies();
    boolean existsByName(@Param("name")String name);

    @Query("SELECT count (c.name)>0 from CompanyEntity c where c. name = :name and c.id!= :id")
    boolean existByCompanyNameOtherId(@Param("name") String name,@Param("id") long id);
}
