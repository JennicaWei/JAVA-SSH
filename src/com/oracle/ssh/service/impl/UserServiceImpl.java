package com.oracle.ssh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.ssh.dao.UserDao;
import com.oracle.ssh.entity.User;
import com.oracle.ssh.service.UserService;

/**
 * �û���ҵ���߼���ʵ����
 */
@Service
@Transactional//ע������
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		//���û���������Ϊ������������getByUsernameAndPassword()
		User user = userDao.getByUsernameAndPassword(username, password);
		//���user��Ϊnull��¼�ɹ�
		if(user!=null){
			result.put("ok", true);
			result.put("user", user);
			result.put("msg", "��¼�ɹ���");
		}else{
			result.put("ok", false);
			result.put("error", "��¼ʧ�ܣ��û��������벻��ȷ��");
		}
		return result;//���ؽ��
	}
	@Override
	public Map<String, Object> register(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		//�ж��û����Ƿ��ѱ�ʹ��
		User user2 = userDao.getByUsername(user.getUsername());//���û������ע���û��������ݿ����
		//���user2����null��˵���û�������ע�ᣬ��֮�����û����ѱ�ʹ��
		if(user2!=null){
			result.put("ok", false);
			result.put("error", "�û����ѱ�ע�ᣡ");
		}else{
			//�û�������ʹ�þ��������ע��
			userDao.create(user);//��user���浽���ݿ�
			result.put("ok", true);
		}
		return result;
	}
}
