package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Order;

/**
 * 
 * �����ӿ�
 *
 */

public interface OrderDao {
	
	void create(Order order);
	void update(Order order);
	Order getById(int id);
	//���û�id��ѯ����
	List<Order>getByUserId(int userId);

}
