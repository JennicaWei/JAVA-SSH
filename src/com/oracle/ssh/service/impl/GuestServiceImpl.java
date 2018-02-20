package com.oracle.ssh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.ssh.dao.CartDao;
import com.oracle.ssh.dao.CategoryDao;
import com.oracle.ssh.dao.GuestDao;
import com.oracle.ssh.dao.ProductDao;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;
import com.oracle.ssh.service.CartService;
import com.oracle.ssh.service.GuestService;


@Service
@Transactional//注解事物
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDao guestDao;
	
	
	@Override
	public void create(Guest guest) {
		// 数据库创建用户留言
		guestDao.create(guest);
	}

	@Override
	public void update(Guest guest) {
		// TODO 自动生成的方法存根
		guestDao.update(guest);
		
		
		
	}

	@Override
	public void delete(Guest guest) {
		// TODO 自动生成的方法存根
		guestDao.delete(guest);
	}

	@Override
	public Guest getById(int id) {
		// TODO 自动生成的方法存根
		return guestDao.getById(id);
	}

	@Override
	public List<Guest> getAll() {
		// TODO 自动生成的方法存根
		return guestDao.getAll();
	}


	
	
}
