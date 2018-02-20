package com.oracle.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.ssh.dao.CollectDao;
import com.oracle.ssh.entity.Collect;
import com.oracle.ssh.service.CollectService;

@Service
@Transactional//ע������
public class CollectServiceImpl implements CollectService {

	
	@Autowired
	private CollectDao collectDao;
	@Override
	public void create(Collect collect) {
		collectDao.create(collect);
	}

	@Override
	public void delete(Collect collect) {
		collectDao.delete(collect);
		
	}

	@Override
	public void update(Collect collect) {
		collectDao.update(collect);
	}

	@Override
	public Collect getByIdAndUserId(int id, Integer userId) {
		// TODO �Զ����ɵķ������
		return collectDao.getByIdAndUserId(id, userId);
	}

	@Override
	public Collect getByProductIdUserId(int productId, int userId) {
		// TODO �Զ����ɵķ������
		return collectDao.getByProductIdUserId(productId, userId);
	}

	@Override
	public List<Collect> getByUserId(Integer userId) {
		// TODO �Զ����ɵķ������
		return collectDao.getByUserId(userId);
	}

	public CollectDao getCollectDao() {
		return collectDao;
	}

	public void setCollectDao(CollectDao collectDao) {
		this.collectDao = collectDao;
	}
	
	

}
