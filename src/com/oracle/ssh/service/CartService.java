package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Cart;

public interface CartService {
	void create(Cart cart);//�������ﳵ
	void delete(Cart cart);//ɾ�����ﳵ
	void update(Cart cart);//���¹��ﳵ
	Cart getByIdAndUserId(int id,Integer userId);//��id���û�id��ȡ���ﳵ
	Cart getByProductIdAndUserId(int productId,int userId);//����Ʒid
	List<Cart>getByUserId(Integer userId);//�����û�id��ѯ���ﳵ

}
