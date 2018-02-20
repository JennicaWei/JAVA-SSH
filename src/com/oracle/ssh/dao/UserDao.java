package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.User;

/**
 * 
 * �û�dao�ӿ�
 *
 */

public interface UserDao {
	void create(User user);//�����û�
	void delete(User user);//ɾ���û�
	void update(User user);//�����û�
	User getById(int id);//��id��ȡ�û�
	User getByUsernameAndPassword(String username,String password);//�����û�������������û�
	List<User>getAll();//��ȡ�����û�
	User getByUsername(String username);//���û�����ѯ�û�
	

}
