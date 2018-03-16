package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.TestPaperPO;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubboapi.learn.domain.TestPaper;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:15.
 **/
public class BeanTransferTestPaper {

    public static List<TestPaper> transferTestPaperList(List<TestPaperPO> testPaperPOList,List<TestPaper> testPaperList){
        for(int i = 0 ; i < testPaperPOList.size() ; i++) {
            TestPaper testPaper = new TestPaper();
            User user = new User();
            Course course1 = new Course();
            BeanUtils.copyProperties(testPaperPOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(testPaperPOList.get(i).getCoursePO(),course1);
            System.out.println("testpaper");
            BeanUtils.copyProperties(testPaperPOList.get(i), testPaper);
            testPaper.setUser(user);
            testPaper.setCourse(course1);
            testPaperList.add(testPaper);
        }
        return testPaperList;
    }

    public static TestPaperPO transferTestPaper(TestPaper testPaper,TestPaperPO testPaperPO){
        UserPO userPO = new UserPO();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(testPaper.getUser(),userPO);
        BeanUtils.copyProperties(testPaper.getCourse(),coursePO);
        BeanUtils.copyProperties(testPaper, testPaperPO);
        System.out.println("testpaper");
        testPaperPO.setUserPO(userPO);
        testPaperPO.setCoursePO(coursePO);
        return testPaperPO;
    }
    public static TestPaper transferTestPaper(TestPaperPO testPaperPO,TestPaper testPaper){
        User user = new User();
        Course course = new Course();
        BeanUtils.copyProperties(testPaperPO.getUserPO(),user);
        BeanUtils.copyProperties(testPaperPO.getCoursePO(),course);
        BeanUtils.copyProperties(testPaperPO, testPaper);
        System.out.println("testpaper");
        testPaper.setUser(user);
        testPaper.setCourse(course);
        return testPaper;
    }
}
