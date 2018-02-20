package com.oracle.ssh.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.ssh.dao.CartDao;
import com.oracle.ssh.dao.OrderDao;
import com.oracle.ssh.dao.OrderItemDao;
import com.oracle.ssh.dao.UserDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Order;
import com.oracle.ssh.entity.OrderItem;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.OrderService;
import com.oracle.ssh.service.ProductService;


@Service
@Transactional//注解事物
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private CartDao cartDao;
	
	//创建订单方法
	public void create(User user,List<Cart> cartList){
		Order order=new Order();//创建订单
		order.setUser(user);
		order.setUsername(user.getUsername());
		order.setUserAddress(user.getAddress());
		order.setCreateTime(new Date());
		order.setStatus(1);
		
		Double total=0.0;//统计订单总额的变量
		for(Cart cart:cartList){//遍历购物车列表，生成对应的订单项
			OrderItem orderItem=new OrderItem();
			orderItem.setOrder(order);//设置对应订单
			orderItem.setPrice(cart.getPrice());//设置单价
			orderItem.setProduct(cart.getProduct());//设置商品
			orderItem.setQuantity(cart.getQuantity());//设置商品数量
			order.getOrderItems().add(orderItem);//关联订单与订单项
			total +=cart.getPrice()*cart.getQuantity();//把购物车项总额累加给total
			cartDao.delete(cart);//生成订单项后要删除对应的购物车项
		}
		order.setTotal(total);//设置订单总额
		orderDao.create(order);//把订单保存到数据库
		System.out.println("把订单生成成功！");
	}
	public List<Order>getByUserId(int userId){
		return orderDao.getByUserId(userId);
	}

	}
	
