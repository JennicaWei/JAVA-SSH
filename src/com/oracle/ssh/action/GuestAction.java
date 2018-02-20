package com.oracle.ssh.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.util.HibernateUtil;
import com.oracle.ssh.entity.Cart;
import com.oracle.ssh.entity.Guest;
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.GuestService;
import com.oracle.ssh.service.ProductService;




@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
@ParentPackage("custom-default")
@InterceptorRefs({@InterceptorRef("myStack")})//配置拦截器
public class GuestAction extends ActionSupport{
	
	@Autowired
	private GuestService guestService;
	private List<Guest>guestAllList;
	
	
	@Action(value="guest",results={
			@Result(name="success" ,location="guest_book.jsp")})
	public String guest(){
		guestAllList=guestService.getAll();
		return "success";
	}
		//创建留言
	@Action(value="addGuest",results={@Result(name="success",location="guest",type="redirect")})
	public String addGuest(){
		HttpServletRequest request=ServletActionContext.getRequest();//获取request
		String guestName=request.getParameter("guestName");//获取商品分类id
		String guestTitle=request.getParameter("guestTitle");
		String guestContent=request.getParameter("guestContent");
		
		//留言保存到数据库
		Guest guest=new Guest();

		guest.setName(guestName);//添加昵称到留言板
		guest.setTitle(guestTitle);
		guest.setMessage(guestContent);
		guest.setGuestTime(new Date());
		
		//创建留言
		guestService.create(guest);
		
		return "success";
		
	}

	public GuestService getGuestService() {
		return guestService;
	}

	public List<Guest> getGuestAllList() {
		return guestAllList;
	}

}
	


