package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-04 14:21.
 **/
public interface UserRepository extends JpaRepository<UserPO, Long> {

    public UserPO findByUsername(String usernmae);

    public UserPO findById(Integer id);


}
