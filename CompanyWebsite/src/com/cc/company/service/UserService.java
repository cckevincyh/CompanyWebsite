package com.cc.company.service;

import com.cc.company.domain.PageBean;
import com.cc.company.domain.User;

public interface UserService {

	public User getUserByUserName(User user);

	public boolean addUser(User user);

	public PageBean<User> findUserByPage(int pageCode, int pageSize);

	public User getUserById(User user);

	public User updateUser(User updateUser);

	public boolean deleteUser(User user);

	public PageBean<User> queryUser(User user, int pageCode, int pageSize);

	public int regist(User user);

	public User updateUserPwd(User user);

}
