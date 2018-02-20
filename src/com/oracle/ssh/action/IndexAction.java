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
 * ��ҳAction�࣬ͨ����������ݿ��ȡ������ʾ��ҳ��
 */


@Scope(value="prototype")//����������Ϊprototype,ÿ�ζ����µ�ʵ��
@Component
@ParentPackage("custom-default")
public class IndexAction extends ActionSupport {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private NewsService newsService;
	
	//��Ʒ���������б�
	private List<Category>categoryList;
	
	//��Ʒ�б�
	private List<Product>productList;
	
	//����
	private List<News> newsList;
	
	private String keyword;//��Ʒ�ؼ���
	private int categoryId;

	
	//��ҳ
	@Action(value="index",results={
			@Result(name="success",location="index.jsp")})
	public String index(){
		//��ȡ���ж�����Ʒ�����б�
		categoryList=categoryService.getTopCategory();
		
		//��ȡ��Ʒ�б�
		productList=productService.getAll();
		
		//��ȡ�����б�
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
	
	
	//������Ʒ
	@Action(value="search",results={
			@Result(name="success",location="index.jsp")})
	public String search(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String categoryId=request.getParameter("categoryId");//��ȡ��Ʒ����id
		
		
		//��keyword�����ڿ�ʱ����������
		if(keyword!=null&&!keyword.equals("")){
			productList=productService.getByName(keyword);//���ð���Ʒ��������Ʒ�ķ���
		}else if(categoryId!=null&&!categoryId.equals("")){
			productList=productService.getByCategoryId(Integer.parseInt(categoryId));//����Ʒ����id��ѯ��Ʒ
			
		}else{
			
			productList=productService.getAll();//��ѯȫ����Ʒ
			
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

	


