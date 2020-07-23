package com.yjk.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjk.dao.UserDao;
import com.yjk.pojo.User;
import com.yjk.pojo.Wan;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getlist() {
		// TODO Auto-generated method stub
		return userDao.getlist();
	}
	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		return userDao.get();
	}
	@Override
	public int delUser(int id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	@Override
	public int upUser(User user) {
		// TODO Auto-generated method stub
		return userDao.upUser(user);
	}
	@Override
	public User getUserId(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserId(id);
	}
	@Override
	public List<Wan> getWan() {
		// TODO Auto-generated method stub
		return userDao.getWan();
	}
	
}
