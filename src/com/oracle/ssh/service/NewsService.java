package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.News;
import com.oracle.ssh.entity.Product;

public interface NewsService {

	
	News getById(int id);
	List<News> getALL();


}
