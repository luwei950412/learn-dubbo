package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.User;

public interface UserService {

	
	public User addUser(User user);

    public User findByUsername(String usernmae);
}
