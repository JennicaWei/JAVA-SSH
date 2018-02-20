package com.oracle.ssh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.ssh.dao.UserDao;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.UserService;

/**
 * 用户的业务逻辑层实现类
 */
@Service
@Transactional//注解事务
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		//把用户和密码作为参数调动方法getByUsernameAndPassword()
		User user = userDao.getByUsernameAndPassword(username, password);
		//如果user不为null登录成功
		if(user!=null){
			result.put("ok", true);
			result.put("user", user);
			result.put("msg", "登录成功！");
		}else{
			result.put("ok", false);
			result.put("error", "登录失败！用户名或密码不正确！");
		}
		return result;//返回结果
	}
	@Override
	public Map<String, Object> register(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		//判断用户名是否已被使用
		User user2 = userDao.getByUsername(user.getUsername());//按用户输入的注册用户名到数据库查找
		//如果user2等于null，说明用户名可以注册，反之就是用户名已被使用
		if(user2!=null){
			result.put("ok", false);
			result.put("error", "用户名已被注册！");
		}else{
			//用户名可以使用就正常完成注册
			userDao.create(user);//把user保存到数据库
			result.put("ok", true);
		}
		return result;
	}
}
