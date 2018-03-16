package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.User;

import java.util.List;

public interface UserService {

	
	public User addUser(User user);

    public User findByUsername(String usernmae);
    public List<User> findByUserType(Integer userType);

    public List<User> findAllUser();

    public User getUserById(Integer userId);

    public User updateUserStatusById(Integer status, Integer id);

    public void deleteUser(Integer id);
}
