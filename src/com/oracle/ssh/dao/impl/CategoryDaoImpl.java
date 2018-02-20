package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.CategoryDao;
import com.oracle.ssh.entity.Category;


@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Category> getTopCategory(){
		//
		Session session=sessionFactory.getCurrentSession();
		String hql="from Category c where c.parent is null";
		
		Query query=session.createQuery(hql);
		return query.list();
		
	}

}
