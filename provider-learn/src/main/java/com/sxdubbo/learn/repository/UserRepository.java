package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2018-01-04 14:21.
 **/
public interface UserRepository extends JpaRepository<UserPO, String>{

    public UserPO findByUsername(String usernmae);
}
