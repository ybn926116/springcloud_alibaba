package org.hope.hopeorder.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    private Integer id;

	private String userId;

	private String commodityCode;

	private Integer count;

	private Integer money;

	private Timestamp createTime;

	private Timestamp updateTime;
}
