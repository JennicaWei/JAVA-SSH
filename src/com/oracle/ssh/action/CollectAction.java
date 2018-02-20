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
import com.oracle.ssh.entity.Collect;
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.CollectService;
import com.oracle.ssh.service.ProductService;

@Scope(value="prototype")
@Component
@ParentPackage("custom-default")
@InterceptorRefs({@InterceptorRef("myStack")})
public class CollectAction extends ActionSupport{
	@Autowired
	private CollectService collectService;
	@Autowired
	private ProductService productService;
	
	private List<Collect>collectList;
	
	@Action(value="addCollect",results={
			@Result(name="success",location="listCollect",type="redirect")})
	public String add(){
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		User loginUser = (User)session.get("loginUser");
		
		HttpServletRequest request =ServletActionContext.getRequest();
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Product product = productService.getById(productId);
		Collect collect = collectService.getByProductIdUserId(productId, loginUser.getId());
		
		
		if(collect==null){
		collect = new Collect();
		collect.setUser(loginUser);
		collect.setProduct(product); 
		collect.setPrice(product.getPrice());
		collectService.create(collect);
		System.out.println("添加"+product.getName()+"添加成功");
		return "success";
		
		}else{
			collectService.update(collect);
			System.out.println("更新"+product.getName()+"添加到收藏成功");
		}
		return "success";
	}
	
@Action(value="listCollect",results={@Result(name="success",location="collect.jsp")})
	
	public String list(){
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		User loginUser = (User)session.get("loginUser");
		collectList=collectService.getByUserId(loginUser.getId());
		return "success";
		
	}
	@Action(value="deleteCollect",results={
			@Result(name="success",location="listCollect",type="redirect")})
	public String delete(){
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		User loginUser = (User)session.get("loginUser");
		
		HttpServletRequest request =ServletActionContext.getRequest();
		Integer collectId = Integer.parseInt(request.getParameter("id"));
		Collect collect = collectService.getByIdAndUserId(collectId, loginUser.getId());
		collectService.delete(collect); 
		System.out.println("删除收藏"+collect.getProduct().getName()+"成功！");
		return "success";
		
	}

	public List<Collect> getCollectList() {
		return collectList;
	}
	

}
