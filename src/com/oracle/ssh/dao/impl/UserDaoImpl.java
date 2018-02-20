package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.UserDao;
import com.oracle.ssh.entity.User;

/**
 * 用户Dao的实现类
 */
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public User getById(int id) {
		User user = (User)sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public User getByUsernameAndPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User u where u.username=? and u.password=?";
		Query query = session.createQuery(hql);
		query.setString(0, username);//给第1个"?"传值
		query.setString(1, password);//给第2个"?"传值
		User user = (User)query.uniqueResult();//获取唯一的结果
		return user;
	}

	@Override
	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public User getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User u where u.username=?";
		Query query = session.createQuery(hql);
		query.setString(0, username);//给第1个"?"传值
		User user = (User)query.uniqueResult();//获取唯一的结果
		return user;
	}
}
