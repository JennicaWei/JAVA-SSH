package com.oracle.ssh.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.UserService;

@Scope(value="prototype")
@Component
@ParentPackage("custom-default")
public class RegisterAction extends ActionSupport{

	@Autowired
	private UserService userService;
	
	private User user;//用户对象
	private String password2;//确认密码
	
	//请求注册页面
		@Action(value="register",results={
				@Result(name="success",location="register.jsp")})
		public String registerForm(){
			return SUCCESS;
		}
	
	//用户注册请求
	@Action(value="userRegister", results={
			@Result(name="success", location="register_success.jsp"),
			@Result(name="input", location="register.jsp")
	})
	public String register(){
		//判断用户是否为空
		if(user==null||user.getUsername()==null
					||user.getUsername().equals("")){
			addActionError("用户名不能为空！");
			return INPUT;
		}
		if(user.getPassword()==null
				||user.getPassword().equals("")){
			addActionError("密码不能为空！");
			return INPUT;
		}
		if(password2==null||password2.equals("")){
			addActionError("确认密码不能为空！");
			return INPUT;
		}
		//判断两个密码是否一致
		if(!user.getPassword().equals(password2)){
			addActionError("两次密码不一致！");
			return "input";
		}	
		//调用service的方法
		Map<String, Object> result = userService.register(user);
		if((Boolean)result.get("ok")){
			System.out.println("注册成功！");
			return "success";//跳转到成功页面
		}else{
			System.out.println("注册失败！");
			addActionError(result.get("error").toString());//添加错误信息
			return "input";
		}
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
