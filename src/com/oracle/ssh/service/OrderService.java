package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Order;
import com.oracle.ssh.entity.User;

public interface OrderService {
	
	//创建订单
	void create(User user,List<Cart> cartList);
	//获取制定用户id的订单列表
	List<Order> getByUserId(int userId);

}
