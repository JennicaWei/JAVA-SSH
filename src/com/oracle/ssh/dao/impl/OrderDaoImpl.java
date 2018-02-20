package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.OrderDao;
import com.oracle.ssh.dao.UserDao;
import com.oracle.ssh.entity.Order;
import com.oracle.ssh.entity.User;


@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Order order) {
		sessionFactory.getCurrentSession().save(order);
		
	}

	@Override
	public void update(Order order) {
		sessionFactory.getCurrentSession().update(order);
		
	}

	@Override
	public Order getById(int id) {
		return (Order)sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public List<Order> getByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order o where o.user.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userId);//给第1个"?"传值
		return query.list();
	}
	
	
	
	

}
