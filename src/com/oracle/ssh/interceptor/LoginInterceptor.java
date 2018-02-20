package com.oracle.ssh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.oracle.ssh.entity.User;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * �Զ����½������
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("�����˵�½������");
		//��ȡAction�������Ķ���
		ActionContext actionContext= invocation.getInvocationContext();
		Map<String, Object>session=actionContext.getSession();//��ȡsession����
		
		//�ж�session����û�е�½�û���ֵ�Ƿ�Ϊnull�����������null˵���û��ѵ�¼����֮����δ��¼
		if(session.get("loginUser")!=null){
			User user=(User)session.get("loginUser");//��ȡ��½�û�����
			System.out.println("�û��ѵ�½...�û���:"+user.getUsername());
			return invocation.invoke();//������������ҳ��
		}else{
			System.out.println("�û�δ��½����ת����½ҳ��");
			actionContext.put("error","�㻹û�е�½");
			return "login";//��ת����½����
		}

	}

}
