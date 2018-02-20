package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.CollectDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Collect;

@Repository
public class CollectDaoImpl implements CollectDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Collect collect) {
		sessionFactory.getCurrentSession().save(collect);
		
	}

	@Override
	public void delete(Collect collect) {
		// TODO 自动生成的方法存根
		sessionFactory.getCurrentSession().delete(collect);
		
	}

	@Override
	public void update(Collect collect) {
		// TODO 自动生成的方法存根
		sessionFactory.getCurrentSession().update(collect);
		
	}

	@Override
	public Collect getByIdAndUserId(int id, Integer userId) {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Collect a where a.id=? and a.user.id=?";
			Query query = session.createQuery(hql);
			query.setInteger(0, id);//给第1个"?"传值
			query.setInteger(1, userId);//给第2个"?"传值
			Collect collect = (Collect)query.uniqueResult();//获取唯一的结果
			return collect;
		}

	@Override
	public List<Collect> getByUserId(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Collect a where a.user.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userId);//给第2个"?"传值
		return query.list();
	}

	@Override
	public Collect getByProductIdUserId(int productId, int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Collect a where a.product.id=? and a.user.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, productId);//给第1个"?"传值
		query.setInteger(1, userId);//给第2个"?"传值
		Collect collect  = (Collect)query.uniqueResult();//获取唯一的结果
		return collect;
	}

	

}
