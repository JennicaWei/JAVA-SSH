package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Order;
import com.oracle.ssh.entity.User;

public interface OrderService {
	
	//��������
	void create(User user,List<Cart> cartList);
	//��ȡ�ƶ��û�id�Ķ����б�
	List<Order> getByUserId(int userId);

}
