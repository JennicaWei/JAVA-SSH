package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;

public interface GuestService {
	void create(Guest guest);//��������
	void delete(Guest guest);//��������
	void update(Guest guest);//��������
	
	Guest getById(int id);
	List<Guest>getAll();

	
}
