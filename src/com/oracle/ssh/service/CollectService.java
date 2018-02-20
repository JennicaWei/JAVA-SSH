package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Collect;

public interface CollectService {
	void create(Collect collect);//创建收藏
	void delete(Collect collect);//删除收藏
	void update(Collect collect);//更新收藏
	Collect getByIdAndUserId(int id,Integer userId);//按id和用户id获取收藏
	Collect getByProductIdUserId(int productId,int userId);
	List<Collect>getByUserId(Integer userId);//按用户名查询用户

}
