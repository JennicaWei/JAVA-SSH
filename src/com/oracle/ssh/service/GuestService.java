package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;

public interface GuestService {
	void create(Guest guest);//创建留言
	void delete(Guest guest);//创建留言
	void update(Guest guest);//更新留言
	
	Guest getById(int id);
	List<Guest>getAll();

	
}
