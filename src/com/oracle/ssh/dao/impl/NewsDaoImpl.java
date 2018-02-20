package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.NewsDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.News;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private NewsDao newsDao;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from News";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public News getById(int id) {
		News news = (News) sessionFactory.getCurrentSession().get(News.class,id);
		return news;

	}
}
