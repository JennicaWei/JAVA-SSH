package com.oracle.ssh.dao;

import java.util.List;

import com.oracle.ssh.entity.Collect;

public interface CollectDao {
	
	void create(Collect collect);//�������ﳵ
	void delete(Collect collect);//ɾ�����ﳵ
	void update(Collect collect);//���¹��ﳵ
	Collect getByIdAndUserId(int id,Integer userId);//��id���û�id��ȡ���ﳵ
	Collect getByProductIdUserId(int productId,int userId);
	List<Collect>getByUserId(Integer userId);//���û�����ѯ�û�

}
