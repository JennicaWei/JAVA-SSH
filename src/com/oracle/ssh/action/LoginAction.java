package com.oracle.ssh.action;


import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.service.UserService;


/**
 * 
 * 用户登陆Action类
 *
 */
@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
@ParentPackage("custom-default")
public class LoginAction extends ActionSupport{
	@Autowired
	private UserService userService;
	private String username;//用户名
	private String password;//密码
	
	//请求登陆页面
	@Action(value="login",results={
			@Result(name="success",location="login.jsp")})
	public String loginForm(){
		System.out.println("11111111111111111111111111");//测试用
		return "success";
	}
	
	//用户登陆请求
	@Action(value="userlogin",results={
		@Result(name="success",location="index",type="redirect"),
		@Result(name="input",location="login.jsp"),
	})
	public String login(){
		//判断用户名与密码是否为空
		if(username.equals("")||password.equals("")||username==null||password==null){
			
			addActionError("用户名或密码不能为空");
			System.out.println("登录失败！");
			return "input";//登陆失败，返回登陆页面
		}
		
		/*//假设用户是admit，密码是123456，才认为是登陆成功，其他都不成功
		if(username.equals("admin")&&password.equals("123456")){
			System.out.println("登陆成功");
			return "success";//返回成功页面
		}*/
		
		
		Map<String,Object> result=userService.login(username, password);
		//判断result的OK是否为true
		if((Boolean)result.get("ok")){
			System.out.println("登陆成功");
			ActionContext context=ActionContext.getContext();//获取Action的上下文对象
			Map<String, Object>session=context.getSession();//获取session对象
			session.put("loginUser",result.get("user"));//把当前登陆成功的用户，保存到httpsession中
			return "success";//返回成功页面
		}else{
			addActionError("用户名或密码错误");
		System.out.println("登陆失败");
		}
		return "input";//登陆失败，返回登陆页面
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}

