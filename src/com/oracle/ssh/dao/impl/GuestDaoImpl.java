package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.CartDao;
import com.oracle.ssh.dao.GuestDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;
import com.oracle.ssh.entity.User;


@Repository   //Spring的注解形式，DAO访问数据库
public class GuestDaoImpl implements GuestDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void create(Guest guest) {
		// TODO 自动生成的方法存根
		sessionFactory.getCurrentSession().save(guest);
	}

	@Override
	public void update(Guest guest) {
		// TODO 自动生成的方法存根
		sessionFactory.getCurrentSession().update(guest);
	}

	@Override
	public void delete(Guest guest) {
		// TODO 自动生成的方法存根
		sessionFactory.getCurrentSession().delete(guest);
	}

	@Override
	public List<Guest> getAll() {
		// TODO 自动生成的方法存根
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Guest";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public Guest getById(int id) {
		// TODO 自动生成的方法存根
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Guest g where g.guest=.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);//给第1个"?"传值
		//返回数据库的留言信息
		return (Guest)query.list();
	}


	
	

	
	

}
