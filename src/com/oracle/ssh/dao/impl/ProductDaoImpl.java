package com.oracle.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.ssh.dao.ProductDao;
import com.oracle.ssh.entity.Product;

/**
 * 用户Dao的实现类
 */
@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Product getById(int id) {
		Product Product = (Product)sessionFactory.getCurrentSession().get(Product.class, id);
		return Product;
	}



	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public List<Product> getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product p where p.name like ?";//模糊查询
		Query query = session.createQuery(hql);
		query.setString(0,"%"+name+"%");//给第1个"?"传值
		return query.list();
	}



	@Override
	public List<Product> getByCategoryId(int categoryId) {
		// TODO 自动生成的方法存根
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product p where p.category.id=?";//模糊查询
		Query query = session.createQuery(hql);
		query.setInteger(0,categoryId);//给第1个"?"传值
		return query.list();
	}
}
