package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Product;
import com.oracle.ssh.entity.Product;

/**
 * 
 * ��Ʒdao�ӿ�
 *
 */

public interface ProductDao {

	Product getById(int id);//��id��ȡ��Ʒ
	List<Product>getAll();//��ȡ�����û�
	List<Product> getByName(String name);
	List<Product> getByCategoryId(int categoryId);//����Ʒ����id��ѯ��Ʒ
	

}
