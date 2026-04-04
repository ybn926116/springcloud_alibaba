package org.hope.hopeorder.mapper;

import org.apache.ibatis.annotations.*;
import org.hope.hopeorder.entity.Order;

import java.util.List;

@Mapper
public interface OrderMapper {



    @Select("SELECT * FROM order WHERE user_id = #{userId}")
    List<Order> getOrderByUserId(@Param("userId") String userId);

    @Insert("INSERT INTO `order` (user_id, commodity_code,count,money,create_time,update_time) VALUES (#{userId}, #{commodityCode},#{count},#{money},#{createTime},#{updateTime})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int saveOrder(Order order);
}
