package com.oracle.ssh.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.ssh.entity.News;
import com.oracle.ssh.service.NewsService;

@Scope(value="prototype")
@Component
public class NewsAction extends ActionSupport{

	@Autowired
	private NewsService newsService;
	
	private int id;
	private News news;
	//新闻
	private List<News> newsList;
	
	@Action(value="newsDetail",results={@Result(name="success",location="news.jsp")})	
	public String detail(){
		news = newsService.getById(id);
		//获取新闻列表
		newsList=newsService.getALL();
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
