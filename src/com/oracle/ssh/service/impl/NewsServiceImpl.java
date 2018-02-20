package com.oracle.ssh.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.ssh.dao.NewsDao;
import com.oracle.ssh.entity.News;
import com.oracle.ssh.service.NewsService;


@Service
@Transactional//ע������
public class NewsServiceImpl implements NewsService{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private NewsDao newsDao;
	
	public NewsDao getNewsDao(){
		return newsDao;
	}
	public void setNewsDao(NewsDao newsDao){
		this.newsDao=newsDao;
	}
	@Override
	public List<News> getALL() {
		// TODO �Զ����ɵķ������
		return newsDao.getAll();
	}
	@Override
	public News getById(int id) {
		// TODO �Զ����ɵķ������
		return newsDao.getById(id);
	}

}
