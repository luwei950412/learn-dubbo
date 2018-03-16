package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.UserCoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.UserCourseRepository;
import com.sxdubbo.learn.utils.BeanTransferUserCourse;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.UserCourse;
import com.sxdubboapi.learn.service.UserCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:39.
 **/
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    public UserCourseRepository userCourseRepository;

    @Override
    public List<UserCourse> findByUserId(Integer userId) {

        List<UserCourse> userCourseList = new ArrayList<>();
        List<UserCoursePO> userCoursePOList = userCourseRepository.findByUserPO_Id(userId);
        if(userCoursePOList != null){
            BeanTransferUserCourse.transferUserCourseList(userCoursePOList,userCourseList);
            return userCourseList;
        }else{
            return null;
        }
    }

    @Override
    public List<UserCourse> findByCourseId(Integer courseId){
        List<UserCourse> userCourseList = new ArrayList<>();
        List<UserCoursePO> userCoursePOList = userCourseRepository.findByCoursePO_Id(courseId);
        if(userCoursePOList != null){
            BeanTransferUserCourse.transferUserCourseList(userCoursePOList,userCourseList);
            return userCourseList;
        }else{
            return null;
        }
    }
}
