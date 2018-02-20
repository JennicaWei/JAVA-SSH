package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.News;


	public interface NewsDao {
		News getById(int id);
		List<News>getAll();

	}


