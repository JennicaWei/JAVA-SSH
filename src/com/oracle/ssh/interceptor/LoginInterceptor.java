package com.oracle.ssh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.oracle.ssh.entity.User;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 自定义登陆拦截器
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("触发了登陆拦截器");
		//获取Action的上下文对象
		ActionContext actionContext= invocation.getInvocationContext();
		Map<String, Object>session=actionContext.getSession();//获取session对象
		
		//判断session中有没有登陆用户的值是否为null，如果不等于null说明用户已登录，反之就是未登录
		if(session.get("loginUser")!=null){
			User user=(User)session.get("loginUser");//获取登陆用户对象
			System.out.println("用户已登陆...用户名:"+user.getUsername());
			return invocation.invoke();//继续正常访问页面
		}else{
			System.out.println("用户未登陆，跳转到登陆页面");
			actionContext.put("error","你还没有登陆");
			return "login";//跳转到登陆请求
		}

	}

}
