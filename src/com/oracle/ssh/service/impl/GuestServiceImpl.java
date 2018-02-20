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
@Transactional//ע������
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDao guestDao;
	
	
	@Override
	public void create(Guest guest) {
		// ���ݿⴴ���û�����
		guestDao.create(guest);
	}

	@Override
	public void update(Guest guest) {
		// TODO �Զ����ɵķ������
		guestDao.update(guest);
		
		
		
	}

	@Override
	public void delete(Guest guest) {
		// TODO �Զ����ɵķ������
		guestDao.delete(guest);
	}

	@Override
	public Guest getById(int id) {
		// TODO �Զ����ɵķ������
		return guestDao.getById(id);
	}

	@Override
	public List<Guest> getAll() {
		// TODO �Զ����ɵķ������
		return guestDao.getAll();
	}


	
	
}
