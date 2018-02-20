package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Order;

/**
 * 
 * 订单接口
 *
 */

public interface OrderDao {
	
	void create(Order order);
	void update(Order order);
	Order getById(int id);
	//按用户id查询订单
	List<Order>getByUserId(int userId);

}
