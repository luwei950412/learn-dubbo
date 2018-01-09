package com.sxdubbo.learn.service.impl;

import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.UserRepository;



/**
 * created by  luwei
 * 2018-01-04 14:17.
 **/
public class UserServiceImpl implements UserService {

	@Autowired
    public UserRepository userRepository;


//	public UserPO userPO;

	@Override
	public User addUser(User user) {
		UserPO userPO = new UserPO();
		System.out.println(userPO.getUsername()+"++++++++++++"+userPO.getPassword());
		BeanUtils.copyProperties(user, userPO);
		
		userRepository.save(userPO);
		BeanUtils.copyProperties(userPO, user);
		return user;
	}

	@Override
	public User findByUsername(String usernmae) {
		// TODO Auto-generated method stub
//		UserPO userPO = new UserPO();
		User user  = new User();
		UserPO userPO = new UserPO();
		userPO = userRepository.findByUsername(usernmae);
		BeanUtils.copyProperties(userPO,user);
		return user;
	}




}
