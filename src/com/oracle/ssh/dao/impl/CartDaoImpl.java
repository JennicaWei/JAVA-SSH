package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.CartDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.User;


@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Cart cart) {
		// TODO �Զ����ɵķ������
		sessionFactory.getCurrentSession().save(cart);
		
	}

	@Override
	public void delete(Cart cart) {
		// TODO �Զ����ɵķ������
		sessionFactory.getCurrentSession().delete(cart);
		
	}

	@Override
	public void update(Cart cart) {
		// TODO �Զ����ɵķ������
		sessionFactory.getCurrentSession().update(cart);
		
	}

	@Override
	public Cart getByIdAndUserId(int id, Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Cart c where c.id=? and c.user.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);//����1��"?"��ֵ
		query.setInteger(1, userId);//����2��"?"��ֵ
		Cart cart = (Cart)query.uniqueResult();//��ȡΨһ�Ľ��
		return cart;
	}

	@Override
	public List<Cart> getByUserId(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Cart c where c.user.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userId);
		return query.list();
	}

	@Override
	public Cart getByProductIdAndUserId(int productId, int userId) {
		// TODO �Զ����ɵķ������
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Cart c where c.product.id=? and c.user.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, productId);
		query.setInteger(1, userId);
		Cart cart = (Cart)query.uniqueResult();//��ȡΨһ�Ľ��
		return cart;
	}

}
