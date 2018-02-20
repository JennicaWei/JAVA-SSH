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

@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
@ParentPackage("custom-default")//拦截器包
@InterceptorRefs({@InterceptorRef("myStack")})//配置拦截器
public class OrderAction extends ActionSupport{
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	private List<Order> orderList;//订单列表
	
	@Action(value="createOrder",results={@Result(name="success",location="listOrder",type="redirect")})
	public String create(){
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		User loginUser=(User)session.get("loginUser");//获取当前登陆用户
		//获取当前登陆用户的购物车列表
		List<Cart>cartList=new ArrayList<Cart>();
		
		HttpServletRequest request=ServletActionContext.getRequest();//获取request
		Enumeration<String>parameterNames=request.getParameterNames();//获取请求的所有参数名称
		while (parameterNames.hasMoreElements()){
			String name=parameterNames.nextElement();//获取遍历到的参数名：pro2
			Integer productId=Integer.parseInt(name.substring("pro".length()));//分割参数名获取商品id
			Integer quantity=Integer.parseInt(request.getParameter(name));//获取商品数量
			Cart cart=cartService.getByProductIdAndUserId(productId, loginUser.getId());
			cart.setQuantity(quantity);//更新数量
			cartList.add(cart);//添加购物车项到list
		}
		//创建订单
		orderService.create(loginUser, cartList);
		return "success";
	}
	@Action(value="listOrder",results={@Result(name="success",location="order.jsp")})
	public String list(){
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		User loginUser=(User)session.get("loginUser");//获取当前登陆用户
		//获取当前登陆用户的订单列表
		orderList=orderService.getByUserId(loginUser.getId());
		return "success";

}
	public List<Order> getOrderList() {
		return orderList;
	}
	
}
