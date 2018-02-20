package com.oracle.ssh.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Order;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.CartService;
import com.oracle.ssh.service.OrderService;

@Scope(value="prototype")//����������Ϊprototype,ÿ�ζ����µ�ʵ��
@Component
@ParentPackage("custom-default")//��������
@InterceptorRefs({@InterceptorRef("myStack")})//����������
public class OrderAction extends ActionSupport{
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	private List<Order> orderList;//�����б�
	
	@Action(value="createOrder",results={@Result(name="success",location="listOrder",type="redirect")})
	public String create(){
		ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
		Map<String, Object>session=context.getSession();//��ȡsession����
		User loginUser=(User)session.get("loginUser");//��ȡ��ǰ��½�û�
		//��ȡ��ǰ��½�û��Ĺ��ﳵ�б�
		List<Cart>cartList=new ArrayList<Cart>();
		
		HttpServletRequest request=ServletActionContext.getRequest();//��ȡrequest
		Enumeration<String>parameterNames=request.getParameterNames();//��ȡ��������в�������
		while (parameterNames.hasMoreElements()){
			String name=parameterNames.nextElement();//��ȡ�������Ĳ�������pro2
			Integer productId=Integer.parseInt(name.substring("pro".length()));//�ָ��������ȡ��Ʒid
			Integer quantity=Integer.parseInt(request.getParameter(name));//��ȡ��Ʒ����
			Cart cart=cartService.getByProductIdAndUserId(productId, loginUser.getId());
			cart.setQuantity(quantity);//��������
			cartList.add(cart);//��ӹ��ﳵ�list
		}
		//��������
		orderService.create(loginUser, cartList);
		return "success";
	}
	@Action(value="listOrder",results={@Result(name="success",location="order.jsp")})
	public String list(){
		ActionContext context=ActionContext.getContext();//��ȡAction�������Ķ���
		Map<String, Object>session=context.getSession();//��ȡsession����
		User loginUser=(User)session.get("loginUser");//��ȡ��ǰ��½�û�
		//��ȡ��ǰ��½�û��Ķ����б�
		orderList=orderService.getByUserId(loginUser.getId());
		return "success";

}
	public List<Order> getOrderList() {
		return orderList;
	}
	
}
