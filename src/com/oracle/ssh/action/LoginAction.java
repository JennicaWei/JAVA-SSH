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
 * �û���½Action��
 *
 */
@Scope(value="prototype")//����������Ϊprototype,ÿ�ζ����µ�ʵ��
@Component
@ParentPackage("custom-default")
public class LoginAction extends ActionSupport{
	@Autowired
	private UserService userService;
	private String username;//�û���
	private String password;//����
	
	//�����½ҳ��
	@Action(value="login",results={
			@Result(name="success",location="login.jsp")})
	public String loginForm(){
		System.out.println("11111111111111111111111111");//������
		return "success";
	}
	
	//�û���½����
	@Action(value="userlogin",results={
		@Result(name="success",location="index",type="redirect"),
		@Result(name="input",location="login.jsp"),
	})
	public String login(){
		//�ж��û����������Ƿ�Ϊ��
		if(username.equals("")||password.equals("")||username==null||password==null){
			
			addActionError("�û��������벻��Ϊ��");
			System.out.println("��¼ʧ�ܣ�");
			return "input";//��½ʧ�ܣ����ص�½ҳ��
		}
		
		/*//�����û���admit��������123456������Ϊ�ǵ�½�ɹ������������ɹ�
		if(username.equals("admin")&&password.equals("123456")){
			System.out.println("��½�ɹ�");
			return "success";//���سɹ�ҳ��
		}*/
		
		
		Map<String,Object> result=userService.login(username, password);
		//�ж�result��OK�Ƿ�Ϊtrue
		if((Boolean)result.get("ok")){
			System.out.println("��½�ɹ�");
			ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
			Map<String, Object>session=context.getSession();//��ȡsession����
			session.put("loginUser",result.get("user"));//�ѵ�ǰ��½�ɹ����û������浽httpsession��
			return "success";//���سɹ�ҳ��
		}else{
			addActionError("�û������������");
		System.out.println("��½ʧ��");
		}
		return "input";//��½ʧ�ܣ����ص�½ҳ��
		
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

