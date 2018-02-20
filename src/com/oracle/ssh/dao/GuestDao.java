package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;

/**
 * 
 * 用户dao接口
 *
 */

public interface GuestDao {
	void create(Guest guest);//创建留言
	void delete(Guest guest);//删除留言
	void update(Guest guest);//更新留言
	
	List<Guest>getAll();//按所有查询用户留言
	Guest getById(int id);

	

}
