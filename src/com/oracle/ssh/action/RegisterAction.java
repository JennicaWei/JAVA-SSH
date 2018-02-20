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
	
	private User user;//�û�����
	private String password2;//ȷ������
	
	//����ע��ҳ��
		@Action(value="register",results={
				@Result(name="success",location="register.jsp")})
		public String registerForm(){
			return SUCCESS;
		}
	
	//�û�ע������
	@Action(value="userRegister", results={
			@Result(name="success", location="register_success.jsp"),
			@Result(name="input", location="register.jsp")
	})
	public String register(){
		//�ж��û��Ƿ�Ϊ��
		if(user==null||user.getUsername()==null
					||user.getUsername().equals("")){
			addActionError("�û�������Ϊ�գ�");
			return INPUT;
		}
		if(user.getPassword()==null
				||user.getPassword().equals("")){
			addActionError("���벻��Ϊ�գ�");
			return INPUT;
		}
		if(password2==null||password2.equals("")){
			addActionError("ȷ�����벻��Ϊ�գ�");
			return INPUT;
		}
		//�ж����������Ƿ�һ��
		if(!user.getPassword().equals(password2)){
			addActionError("�������벻һ�£�");
			return "input";
		}	
		//����service�ķ���
		Map<String, Object> result = userService.register(user);
		if((Boolean)result.get("ok")){
			System.out.println("ע��ɹ���");
			return "success";//��ת���ɹ�ҳ��
		}else{
			System.out.println("ע��ʧ�ܣ�");
			addActionError(result.get("error").toString());//��Ӵ�����Ϣ
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
