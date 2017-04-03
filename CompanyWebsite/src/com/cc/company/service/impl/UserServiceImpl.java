package com.cc.company.service.impl;

import com.cc.company.dao.UserDao;
import com.cc.company.domain.PageBean;
import com.cc.company.domain.User;
import com.cc.company.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByUserName(User user) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserName(user);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public PageBean<User> findUserByPage(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.findUserByPage(pageCode, pageSize);
	}

	@Override
	public User getUserById(User user) {
		// TODO Auto-generated method stub
		return userDao.getUserById(user);
	}

	@Override
	public User updateUser(User updateUser) {
		// TODO Auto-generated method stub
		return userDao.updateUser(updateUser);
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	@Override
	public PageBean<User> queryUser(User user, int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.queryUser(user, pageCode, pageSize);
	}

	@Override
	public int regist(User user) {
		// 注册用户
		if(userDao.addUser(user)){
			return 1;
		}else{
			return 0;
		}
	}

}
