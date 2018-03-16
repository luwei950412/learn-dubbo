package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.*;
import com.sxdubboapi.learn.domain.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:15.
 **/
public class BeanTransferUserCourse {

    public static List<UserCourse> transferUserCourseList(List<UserCoursePO> userCoursePOList,List<UserCourse> userCourseList){
        for(int i = 0 ; i < userCoursePOList.size() ; i++) {
            UserCourse userCourse = new UserCourse();
            User user = new User();
            Course course = new Course();
            Video video = new Video();
            BeanUtils.copyProperties(userCoursePOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(userCoursePOList.get(i).getCoursePO(),course);
            BeanUtils.copyProperties(userCoursePOList.get(i).getVideoPO(),video);
            System.out.println("");
            BeanUtils.copyProperties(userCoursePOList.get(i), userCourse);
            userCourse.setUser(user);
            userCourse.setCourse(course);
            userCourse.setVideo(video);
            userCourseList.add(userCourse);
        }
        return userCourseList;
    }

    public static UserCoursePO transferUserCourse(UserCourse userCourse,UserCoursePO userCoursePO){
        UserPO userPO = new UserPO();
        CoursePO coursePO = new CoursePO();
        VideoPO videoPO = new VideoPO();
        BeanUtils.copyProperties(userCourse.getUser(),userPO);
        BeanUtils.copyProperties(userCourse.getCourse(),coursePO);
        BeanUtils.copyProperties(userCourse.getVideo(),videoPO);
        BeanUtils.copyProperties(userCourse, userCoursePO);
        System.out.println("testpaper");
        userCoursePO.setUserPO(userPO);
        userCoursePO.setVideoPO(videoPO);
        userCoursePO.setCoursePO(coursePO);
        return userCoursePO;
    }
    public static UserCourse transferUserCourse(UserCoursePO userCoursePO,UserCourse userCourse){
        User user = new User();
        Course course = new Course();
        Video video= new Video();
        BeanUtils.copyProperties(userCoursePO.getUserPO(),user);
        BeanUtils.copyProperties(userCoursePO.getCoursePO(),course);
        BeanUtils.copyProperties(userCoursePO.getVideoPO(),video);
        BeanUtils.copyProperties(userCoursePO, userCourse);
        System.out.println("testpaper");
        userCourse.setUser(user);
        userCourse.setVideo(video);
        userCourse.setCourse(course);
        return userCourse;
    }
}
