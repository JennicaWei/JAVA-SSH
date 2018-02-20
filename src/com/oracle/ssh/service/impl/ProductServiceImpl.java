package com.oracle.ssh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.ssh.dao.CategoryDao;
import com.oracle.ssh.dao.ProductDao;
import com.oracle.ssh.entity.Category;
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.service.ProductService;

@Service
@Transactional//ע������
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product getById(int id){
		return productDao.getById(id);
	}

	@Override
	public List<Product> getAll() {
		// TODO �Զ����ɵķ������
		return productDao.getAll();
	}

	@Override
	public List<Product> getByName(String name) {
		// TODO �Զ����ɵķ������
		return productDao.getByName(name);
	}

	@Override
	public List<Product> getByCategoryId(int categoryId) {
		// TODO �Զ����ɵķ������
		return  productDao.getByCategoryId(categoryId);
	}
}
