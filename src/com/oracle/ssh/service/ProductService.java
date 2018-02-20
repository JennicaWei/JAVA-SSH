package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Category;
import com.oracle.ssh.entity.Product;

public interface ProductService {
	
	Product getById(int id);//按id获取商品
	List<Product>getAll();//获取所有用户
	List<Product> getByName(String name);
	List<Product> getByCategoryId(int categoryId);//按商品分类id查询商品



}
