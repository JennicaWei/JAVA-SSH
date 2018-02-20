package com.oracle.ssh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.ssh.dao.CategoryDao;
import com.oracle.ssh.entity.Category;
import com.oracle.ssh.service.CategoryService;


@Service
@Transactional//注解事物

public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getTopCategory() {
		// TODO 自动生成的方法存根
		return categoryDao.getTopCategory();
	}


}
