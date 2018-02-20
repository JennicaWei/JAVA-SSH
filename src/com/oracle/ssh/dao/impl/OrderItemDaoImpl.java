package com.oracle.ssh.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.OrderItemDao;
import com.oracle.ssh.entity.OrderItem;
import com.oracle.ssh.service.ProductService;

@Repository
public class OrderItemDaoImpl implements OrderItemDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(OrderItem orderItem) {
		sessionFactory.getCurrentSession().save(orderItem);
		
	}
	

}
