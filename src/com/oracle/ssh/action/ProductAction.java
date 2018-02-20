package com.oracle.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.entity.Category;
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.service.CategoryService;
import com.oracle.ssh.service.ProductService;


@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
@ParentPackage("custom-default")
public class ProductAction extends ActionSupport{
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	//商品顶级分类列表
		private List<Category>categoryList;
	private int id;
	private Product product;
	
	
	
	@Action(value="product",results={@Result(name="success",location="product.jsp")})
	public String detail(){
		//获取所有顶级商品分类
		categoryList=categoryService.getTopCategory();
		
		product=productService.getById(id);
		//最近浏览
		ActionContext context=ActionContext.getContext();//获取Action的上下文对象
		Map<String, Object>session=context.getSession();//获取session对象
		//定义product与productList
		List<Product> productList;
		if(session.get("ProducBrowtList")!=null){
				
			productList=(List<Product>)session.get("ProducBrowtList");
		}else{
			productList=new ArrayList<Product>();
		}
		if (productList.size()<=4){
			int i;
			for(i=0;i<productList.size();i++){
				Product p=productList.get(i);
				if(p.getId()==product.getId()){
					break;
					
				}
			}
			if(i==productList.size()){
				productList.add(product);
			}
		}else{
			productList.remove(product);
		}
		session.put("ProducBrowtList",productList);
		
		return "success";
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}


	public List<Category> getCategoryList() {
		return categoryList;
	}

	

}
