package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Collect;

public interface CollectDao {
	
	void create(Collect collect);//创建购物车
	void delete(Collect collect);//删除购物车
	void update(Collect collect);//更新购物车
	Collect getByIdAndUserId(int id,Integer userId);//按id和用户id获取购物车
	Collect getByProductIdUserId(int productId,int userId);
	List<Collect>getByUserId(Integer userId);//按用户名查询用户

}
