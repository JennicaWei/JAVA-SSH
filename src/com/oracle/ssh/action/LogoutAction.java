package com.oracle.ssh.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope(value="prototype")//����������Ϊprototype,ÿ�ζ����µ�ʵ��
@Component
public class LogoutAction extends ActionSupport{
	
	@Action(value="logout",results={
			@Result(name="success",location="index",type="redirect")})
	public String logout(){
		ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
		Map<String, Object>session=context.getSession();//��ȡsession����
		session.clear();//���session
		
		return "success";
	}

}
