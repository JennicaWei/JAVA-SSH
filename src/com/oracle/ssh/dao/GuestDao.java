package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;

/**
 * 
 * �û�dao�ӿ�
 *
 */

public interface GuestDao {
	void create(Guest guest);//��������
	void delete(Guest guest);//ɾ������
	void update(Guest guest);//��������
	
	List<Guest>getAll();//�����в�ѯ�û�����
	Guest getById(int id);

	

}
