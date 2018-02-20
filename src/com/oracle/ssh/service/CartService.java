package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Cart;

public interface CartService {
	void create(Cart cart);//创建购物车
	void delete(Cart cart);//删除购物车
	void update(Cart cart);//更新购物车
	Cart getByIdAndUserId(int id,Integer userId);//按id和用户id获取购物车
	Cart getByProductIdAndUserId(int productId,int userId);//按商品id
	List<Cart>getByUserId(Integer userId);//按照用户id查询购物车

}
