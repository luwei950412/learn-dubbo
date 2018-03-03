package com.sxdubbo.learn.service.impl;

import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.UserService;
import org.apache.zookeeper.Login;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.UserRepository;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;


/**
 * created by  luwei
 * 2018-01-04 14:17.
 **/
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

//    public List<User> userList;


//	public UserPO userPO;

    @Override
    public User addUser(User user) {
        UserPO userPO = new UserPO();
        System.out.println(userPO.getUsername() + "++++++++++++" + userPO.getPassword());
        BeanUtils.copyProperties(user, userPO);

        userRepository.save(userPO);
        BeanUtils.copyProperties(userPO, user);
        return user;
    }

    @Override
    public User findByUsername(String usernmae) {
        // TODO Auto-generated method stub
//		UserPO userPO = new UserPO();
        User user = new User();
        UserPO userPO = new UserPO();
        userPO = userRepository.findByUsername(usernmae);
        if(userPO !=null){
            BeanUtils.copyProperties(userPO, user);
        }else{
            return null;
        }
        return user;
    }

    @Override
    public List<User> findAllUser(){
        List<User> userList= new ArrayList<User>();

//        UserPO userPO = new UserPO();
        List<UserPO> userPOList = userRepository.findAll();

//        BeanUtils.copyProperties(userPOList, userList);
        for(int i = 0 ; i < userPOList.size() ; i++) {
            User user = new User();
            BeanUtils.copyProperties(userPOList.get(i), user);
            userList.add(user);
            System.out.println(i+"此时的i对应的用户类别"+userList.get(i).getUserType());
        }
        return userList;
    }
    @Override
    public User getUserById(Integer userId){
        User user = new User();
        UserPO userPO = new UserPO();
        userPO = userRepository.findById(userId);
        BeanUtils.copyProperties(userPO, user);
        return user;
    }

    @Override
    public User updateUserStatusById(Integer status, Integer id){
        User user = new User();
        UserPO userPO = new UserPO();
        UserPO userPO1 = new UserPO();
        userPO = userRepository.findById(id);
        userPO.setUserStatus(status);
        userPO1 = userRepository.save(userPO);
//        userPO = userRepository.updateUserStatusById(status,id);
        BeanUtils.copyProperties(userPO, user);
        return user;
    }

    @Override
    public void deleteUser(Integer id){
        User user = new User();
        UserPO userPO = new UserPO();
        userPO = userRepository.findById(id);
        userRepository.delete(userPO);
    }


}
