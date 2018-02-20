package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Category;

/**
 * @param args
 */


public interface CategoryDao {

		//获取商品
	List<Category> getTopCategory();

	}


