package com.oracle.ssh.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.ssh.dao.CartDao;
import com.oracle.ssh.dao.OrderDao;
import com.oracle.ssh.dao.OrderItemDao;
import com.oracle.ssh.dao.UserDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Order;
import com.oracle.ssh.entity.OrderItem;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.OrderService;
import com.oracle.ssh.service.ProductService;


@Service
@Transactional//ע������
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private CartDao cartDao;
	
	//������������
	public void create(User user,List<Cart> cartList){
		Order order=new Order();//��������
		order.setUser(user);
		order.setUsername(user.getUsername());
		order.setUserAddress(user.getAddress());
		order.setCreateTime(new Date());
		order.setStatus(1);
		
		Double total=0.0;//ͳ�ƶ����ܶ�ı���
		for(Cart cart:cartList){//�������ﳵ�б����ɶ�Ӧ�Ķ�����
			OrderItem orderItem=new OrderItem();
			orderItem.setOrder(order);//���ö�Ӧ����
			orderItem.setPrice(cart.getPrice());//���õ���
			orderItem.setProduct(cart.getProduct());//������Ʒ
			orderItem.setQuantity(cart.getQuantity());//������Ʒ����
			order.getOrderItems().add(orderItem);//���������붩����
			total +=cart.getPrice()*cart.getQuantity();//�ѹ��ﳵ���ܶ��ۼӸ�total
			cartDao.delete(cart);//���ɶ������Ҫɾ����Ӧ�Ĺ��ﳵ��
		}
		order.setTotal(total);//���ö����ܶ�
		orderDao.create(order);//�Ѷ������浽���ݿ�
		System.out.println("�Ѷ������ɳɹ���");
	}
	public List<Order>getByUserId(int userId){
		return orderDao.getByUserId(userId);
	}

	}
	
