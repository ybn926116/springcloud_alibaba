package org.hope.hopeaccount.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Mapper
@Repository
public interface AccountMapper {

    @Select("select money from account where user_id = #{userId}")
    Integer getBalance(@Param("userId") String userId);

    @Update("UPDATE account SET money = money - #{price}, updated_time = #{updatedTime} WHERE user_id = #{userId} AND money >= #{price}")
    int reduceBalance(@Param("userId") String userId,
                      @Param("price")Integer price,
                      @Param("updatedTime") Timestamp updatedTime);
}
