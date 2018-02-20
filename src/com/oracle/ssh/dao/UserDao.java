package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.User;

/**
 * 
 * 用户dao接口
 *
 */

public interface UserDao {
	void create(User user);//创建用户
	void delete(User user);//删除用户
	void update(User user);//更新用户
	User getById(int id);//按id获取用户
	User getByUsernameAndPassword(String username,String password);//按照用户名和密码查找用户
	List<User>getAll();//获取所有用户
	User getByUsername(String username);//按用户名查询用户
	

}
