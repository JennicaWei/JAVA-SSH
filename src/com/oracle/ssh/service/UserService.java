package com.oracle.ssh.service;

import java.util.Map;

import com.oracle.ssh.entity.User;

/**
 * 
 *用户的业务逻辑层接口
 *
 */
public interface UserService {
	//登陆方法
	Map<String,Object> login(String username,String password);
	//注册方法
	Map<String,Object> register(User user);

}
