package com.chaim.coupons.dal;

import com.chaim.coupons.dto.SuccessfulLoginData;
import com.chaim.coupons.dto.UserDto;
import com.chaim.coupons.entitys.UserEntity;
import com.chaim.coupons.enums.UserType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IUserDal extends CrudRepository<UserEntity, Long> {
   // UserEntity  findByName(String name);





    List<UserEntity> findAll(Pageable paging);
    boolean existsByUserName (@Param("userName")String userName);

    @Query("SELECT count (u.userName)>0 from UserEntity u where u. userName = :userName and u.id!= :id")
    boolean isUserNameOccupiedByOtherId(@Param("userName") String userName, @Param("id") long id);
    @Query("SELECT new com.chaim.coupons.dto.SuccessfulLoginData(u.id,u.type,u.firstName,u.lastName,u.company.id)" +
            "FROM UserEntity u where u.userName= :userName AND u.password = :password")
    SuccessfulLoginData login(@Param("userName")String userName,@Param("password")String password);

    List<UserEntity> findByType(UserType userType,Pageable paging);
}
