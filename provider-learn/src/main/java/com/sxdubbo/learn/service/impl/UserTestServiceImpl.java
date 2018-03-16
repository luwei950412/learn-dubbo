package com.sxdubbo.learn.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TestPaperPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.domain.UserTestPO;
import com.sxdubbo.learn.repository.UserTestRepository;
import com.sxdubbo.learn.utils.BeanTransferUserTest;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TestPaper;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.UserTest;
import com.sxdubboapi.learn.service.UserTestService;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:11.
 **/
public class UserTestServiceImpl implements UserTestService{
    @Autowired
    public UserTestRepository userTestRepository;

    @Override
    public List<UserTest> findByCourse(Course course){
        List<UserTest> userTestList= new ArrayList<UserTest>();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(course,coursePO);
        List<UserTestPO> userTestPOList= userTestRepository.findByCoursePO(coursePO);
        BeanTransferUserTest.transferUserTestList(userTestPOList,userTestList);
        return userTestList;
    }
    @Override
    public List<UserTest> findByUser(User user){
        List<UserTest> userTestList= new ArrayList<UserTest>();
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user,userPO);
        List<UserTestPO> userTestPOList= userTestRepository.findByUserPO(userPO);
        BeanTransferUserTest.transferUserTestList(userTestPOList,userTestList);
        return userTestList;
    }

    @Override
    public UserTest findByTest(TestPaper testPaper){
        UserTest userTest = new UserTest();
        TestPaperPO testPaperPO = new TestPaperPO();
        BeanUtils.copyProperties(testPaper,testPaperPO);
        UserTestPO userTestPO = userTestRepository.findByTestPaperPO(testPaperPO);
//        BeanUtils.copyProperties(userTestPO, userTest);
        BeanTransferUserTest.transferUserTest(userTestPO,userTest);
        return userTest;
    }

    @Override
    public UserTest findByCourseAndUser(Course course,User user){
        UserTest userTest = new UserTest();
        CoursePO coursePO = new CoursePO();
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(course,coursePO);
        BeanUtils.copyProperties(user,userPO);
        UserTestPO userTestPO = userTestRepository.findByCoursePOAndUserPO(coursePO,userPO);

        if(userTestPO != null){
            BeanTransferUserTest.transferUserTest(userTestPO,userTest);
            System.out.println(userTest.getId()+"&&&&&&&&&&&&&");
            return userTest;
        }else{
            return null;
        }
    }

    @Override
    public UserTest findById(Integer id){
        UserTest userTest = new UserTest();
        UserTestPO userTestPO = userTestRepository.findOne(id);
        BeanTransferUserTest.transferUserTest(userTestPO,userTest);
        return userTest;
    }

    @Override
    public UserTest addUserTest(UserTest userTest){
//        UserTest userTest1= new UserTest();

        UserTestPO userTestPO= new UserTestPO();
//        CoursePO coursePO1 = new CoursePO();
        BeanTransferUserTest.transferUserTest(userTest,userTestPO);
        userTestRepository.save(userTestPO);
//        BeanUtils.copyProperties(coursePO1, course1);
        return userTest;
    }

    @Override
    public void deleteUserTest(Integer userTestId){
        userTestRepository.delete(userTestId);
    }
}
