package com.oracle.ssh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.ssh.dao.CartDao;
import com.oracle.ssh.dao.CategoryDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.service.CartService;


@Service
@Transactional//注解事物
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	public void create(Cart cart) {
		cartDao.create(cart);	
	}

	public void delete(Cart cart) {
		cartDao.delete(cart);
	}

	public void update(Cart cart) {
		cartDao.update(cart);
	}

	public Cart getByIdAndUserId(int id, Integer userId) {
		return cartDao.getByIdAndUserId(id,userId);
	}

	public List<Cart> getByUserId(Integer userId) {
		return cartDao.getByUserId(userId);
	}

	@Override
	public Cart getByProductIdAndUserId(int productId, int userId) {
		// TODO 自动生成的方法存根
		return cartDao.getByProductIdAndUserId(productId,userId );
	}

}
