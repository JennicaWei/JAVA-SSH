package com.oracle.ssh.service;

import java.util.Map;

import com.oracle.ssh.entity.User;

/**
 * 
 *�û���ҵ���߼���ӿ�
 *
 */
public interface UserService {
	//��½����
	Map<String,Object> login(String username,String password);
	//ע�᷽��
	Map<String,Object> register(User user);

}
