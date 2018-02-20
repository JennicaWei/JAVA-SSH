package com.oracle.ssh.service;

import java.util.List;

import com.oracle.ssh.entity.Collect;

public interface CollectService {
	void create(Collect collect);//�����ղ�
	void delete(Collect collect);//ɾ���ղ�
	void update(Collect collect);//�����ղ�
	Collect getByIdAndUserId(int id,Integer userId);//��id���û�id��ȡ�ղ�
	Collect getByProductIdUserId(int productId,int userId);
	List<Collect>getByUserId(Integer userId);//���û�����ѯ�û�

}
