package com.oracle.ssh.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
public class LogoutAction extends ActionSupport{
	
	@Action(value="logout",results={
			@Result(name="success",location="index",type="redirect")})
	public String logout(){
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		session.clear();//清空session
		
		return "success";
	}

}
