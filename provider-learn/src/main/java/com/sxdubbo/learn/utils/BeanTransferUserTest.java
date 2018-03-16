package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TestPaperPO;
import com.sxdubbo.learn.domain.UserTestPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TestPaper;
import com.sxdubboapi.learn.domain.UserTest;
import com.sxdubboapi.learn.domain.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:15.
 **/
public class BeanTransferUserTest {

    public static List<UserTest> transferUserTestList(List<UserTestPO> userTestPOList,List<UserTest> userTestList){
        for(int i = 0 ; i < userTestPOList.size() ; i++) {
            UserTest userTest = new UserTest();
            User user = new User();
            Course course = new Course();
            TestPaper testPaper = new TestPaper();
            BeanUtils.copyProperties(userTestPOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(userTestPOList.get(i).getCoursePO(),course);
            BeanUtils.copyProperties(userTestPOList.get(i).getTestPaperPO(),testPaper);
            System.out.println("testpaper");
            BeanUtils.copyProperties(userTestPOList.get(i), userTest);
            userTest.setUser(user);
            userTest.setCourse(course);
            userTest.setTestPaper(testPaper);
            userTestList.add(userTest);
        }
        return userTestList;
    }

    public static UserTestPO transferUserTest(UserTest userTest,UserTestPO userTestPO){
        UserPO userPO = new UserPO();
        CoursePO coursePO = new CoursePO();
        TestPaperPO testPaperPO = new TestPaperPO();
        BeanUtils.copyProperties(userTest.getUser(),userPO);
        BeanUtils.copyProperties(userTest.getCourse(),coursePO);
        BeanUtils.copyProperties(userTest.getTestPaper(),testPaperPO);
        BeanUtils.copyProperties(userTest, userTestPO);
        System.out.println("testpaper");
        userTestPO.setUserPO(userPO);
        userTestPO.setTestPaperPO(testPaperPO);
        userTestPO.setCoursePO(coursePO);
        return userTestPO;
    }
    public static UserTest transferUserTest(UserTestPO userTestPO,UserTest userTest){
        User user = new User();
        Course course = new Course();
        TestPaper testPaper = new TestPaper();
        BeanUtils.copyProperties(userTestPO.getUserPO(),user);
        BeanUtils.copyProperties(userTestPO.getCoursePO(),course);
        BeanUtils.copyProperties(userTestPO.getTestPaperPO(),testPaper);
        BeanUtils.copyProperties(userTestPO, userTest);
        System.out.println("testpaper");
        userTest.setUser(user);
        userTest.setTestPaper(testPaper);
        userTest.setCourse(course);
        return userTest;
    }
}
