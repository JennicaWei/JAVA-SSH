package com.oracle.ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.entity.Category;
import com.oracle.ssh.entity.News;
import com.oracle.ssh.entity.Product;
import com.oracle.ssh.service.CategoryService;
import com.oracle.ssh.service.NewsService;
import com.oracle.ssh.service.ProductService;

/**
 * 首页Action类，通过此类从数据库获取数据显示到页面
 */


@Scope(value="prototype")//配置作用域为prototype,每次都是新的实列
@Component
@ParentPackage("custom-default")
public class IndexAction extends ActionSupport {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private NewsService newsService;
	
	//商品顶级分类列表
	private List<Category>categoryList;
	
	//商品列表
	private List<Product>productList;
	
	//新闻
	private List<News> newsList;
	
	private String keyword;//商品关键字
	private int categoryId;

	
	//首页
	@Action(value="index",results={
			@Result(name="success",location="index.jsp")})
	public String index(){
		//获取所有顶级商品分类列表
		categoryList=categoryService.getTopCategory();
		
		//获取商品列表
		productList=productService.getAll();
		
		//获取新闻列表
		newsList=newsService.getALL();
		
		return "success";
	}
	
	
	@Action(value="NewsList",results={@Result(name="success",location="index.jsp")})
	public String news(){
		
		categoryList=categoryService.getTopCategory();	
		
		productList= productService.getAll();
		
		newsList=newsService.getALL();
		
		return "success";
	}
	
	
	//搜索商品
	@Action(value="search",results={
			@Result(name="success",location="index.jsp")})
	public String search(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String categoryId=request.getParameter("categoryId");//获取商品分类id
		
		
		//当keyword不等于空时，进行搜索
		if(keyword!=null&&!keyword.equals("")){
			productList=productService.getByName(keyword);//调用按商品名查找商品的方法
		}else if(categoryId!=null&&!categoryId.equals("")){
			productList=productService.getByCategoryId(Integer.parseInt(categoryId));//按商品分类id查询商品
			
		}else{
			
			productList=productService.getAll();//查询全部商品
			
		}
		categoryList=categoryService.getTopCategory();
		return "success";
		
	}
	
	
	public List<Category> getCategoryList(){
		return categoryList;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public List<News> getNewsList() {
		return newsList;
	}


	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
	
	}

	


