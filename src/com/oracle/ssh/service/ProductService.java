package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Category;
import com.oracle.ssh.entity.Product;

public interface ProductService {
	
	Product getById(int id);//��id��ȡ��Ʒ
	List<Product>getAll();//��ȡ�����û�
	List<Product> getByName(String name);
	List<Product> getByCategoryId(int categoryId);//����Ʒ����id��ѯ��Ʒ



}
