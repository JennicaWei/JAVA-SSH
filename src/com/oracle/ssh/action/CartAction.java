package com.oracle.ssh.action;

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
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.CartService;
import com.oracle.ssh.service.ProductService;




@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
@ParentPackage("custom-default")
@InterceptorRefs({@InterceptorRef("myStack")})//配置拦截器
public class CartAction extends ActionSupport{
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	private List<Cart> cartList;//购物车列表
	
	//商品添加到购物车
	
	@Action(value="addCart",results={@Result(name="success",location="listCart",type="redirect")})
	public String add(){
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		User loginUser=(User)session.get("loginUser");//获取当前登陆用户
		
		HttpServletRequest request=ServletActionContext.getRequest();//获取request
		Integer productId=Integer.parseInt(request.getParameter("productId"));//获取参数商品id
		Product product=productService.getById(productId);
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));//获取参数商品数量
		
		//按商品id和用户id查找商品
		Cart cart=cartService.getByProductIdAndUserId(productId, loginUser.getId());
		//如果cart等于null，说明购物车没有添加此产品
		if(cart==null){
			cart=new Cart();
			cart.setUser(loginUser);//添加用户
			cart.setProduct(product);//添加商品到购物车
			cart.setQuantity(quantity);
			cart.setPrice(product.getPrice());
			cartService.create(cart);//把购物车保存到数据库
			System.out.println("添加"+product.getName()+"到购物车成功");
		}else{
			cart.setQuantity(cart.getQuantity()+quantity);//
			cartService.update(cart);//更新购物车
			System.out.println("更新"+product.getName()+"到购物车成功");
			
		}
		
		return "success";
	}
	
	//查看购物车列表
	@Action(value="listCart",results={@Result(name="success",location="cart.jsp")})
	public String list(){
		System.out.println("11111");
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		User loginUser=(User)session.get("loginUser");//获取当前登陆用户
		
		cartList=cartService.getByUserId(loginUser.getId());//获取当前登陆用户的购物车列表
		System.out.println("22222");
		return "success";
	}
	
	@Action(value="deleteCart",results={@Result(name="success",location="listCart",type="redirect")})
	public String delete(){
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		User loginUser=(User)session.get("loginUser");//获取当前登陆用户
		
		HttpServletRequest request=ServletActionContext.getRequest();//获取request
		Integer cartId=Integer.parseInt(request.getParameter("id"));//获取要删除的购物车项的id
		Cart cart=cartService.getByIdAndUserId(cartId, loginUser.getId());//获取当前用户的购物车项
		cartService.delete(cart);//删除购物车项
		System.out.println("删除购物车"+cart.getProduct().getName()+"成功");
		
		return "success";
		
	}

	public List<Cart> getCartList() {
		return cartList;
	}

}
