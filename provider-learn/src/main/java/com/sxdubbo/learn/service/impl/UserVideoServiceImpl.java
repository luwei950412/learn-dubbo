package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.UserVideoPO;
import com.sxdubbo.learn.repository.UserVideoRepository;
import com.sxdubboapi.learn.domain.UserVideo;
import com.sxdubboapi.learn.service.UserVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:43.
 **/
public class UserVideoServiceImpl implements UserVideoService {

    @Autowired
    public UserVideoRepository userVideoRepository;

    @Override
    public List<UserVideo> findByUserId(Integer userId) {

        List<UserVideo> userVideoList= new ArrayList<UserVideo>();

//        UserPO userPO = new UserPO();
        List<UserVideoPO> userVideoPOList = userVideoRepository.findByUserId(userId);
        for(int i = 0 ; i < userVideoPOList.size() ; i++) {
            UserVideo userVideo = new UserVideo();
            BeanUtils.copyProperties(userVideoList.get(i), userVideo);
            userVideoList.add(userVideo);
            System.out.println(i+"此时的i对应的"+userVideoList.get(i).getProgress());
        }
        return userVideoList;
    }
    @Override
    public List<UserVideo> findByCourseId(Integer courseId){
        List<UserVideo> userVideoList= new ArrayList<UserVideo>();

//        UserPO userPO = new UserPO();
        List<UserVideoPO> userVideoPOList = userVideoRepository.findByCourseId(courseId);

//        BeanUtils.copyProperties(userPOList, userList);
        for(int i = 0 ; i < userVideoPOList.size() ; i++) {
            UserVideo userVideo = new UserVideo();
            BeanUtils.copyProperties(userVideoPOList.get(i), userVideo);
            userVideoList.add(userVideo);
            System.out.println(i+"此时的i对应的视频进度"+userVideoList.get(i).getProgress());
        }
        return userVideoList;
    }

    @Override
    public UserVideo findByVideoId(Integer videoId) {
        UserVideo userVideo = new UserVideo();
        UserVideoPO userVideoPO = new UserVideoPO();
        userVideoPO = userVideoRepository.findByVideoId(videoId);
        if(userVideoPO==null){
            return null;
        }else{
            BeanUtils.copyProperties(userVideoPO, userVideo);
            return userVideo;
        }
    }

    @Override
    public UserVideo saveUserVideo(UserVideo userVideo){
        UserVideoPO userVideoPO = new UserVideoPO();
        UserVideo userVideo1=new UserVideo();
        BeanUtils.copyProperties(userVideo,userVideoPO);
        System.out.println(userVideoPO.getUserId()+"****************"+userVideoPO.getProgress());
        if(userVideoRepository.findByUserIdAndVideoId(userVideoPO.getUserId(),userVideoPO.getVideoId())==null){
            System.out.println("null");
            UserVideoPO userVideoPO1 = userVideoRepository.save(userVideoPO);
            BeanUtils.copyProperties(userVideoPO1,userVideo1);
        }else{
            System.out.println("not null");
            UserVideoPO userVideoPO2 = userVideoRepository.findByUserIdAndVideoId(userVideoPO.getUserId(),userVideoPO.getVideoId());
            userVideoPO.setId(userVideoPO2.getId());
            UserVideoPO userVideoPO3 = userVideoRepository.save(userVideoPO);
            BeanUtils.copyProperties(userVideoPO3,userVideo1);
        }
        return userVideo1;
    }

    @Override
    public UserVideo findByUserIdAndVideoId(Integer userId,Integer videoId){
        if(userVideoRepository.findByUserIdAndVideoId(userId,videoId)==null){
            return null;
        }else{
            UserVideo userVideo=new UserVideo();
            UserVideoPO userVideoPO1=userVideoRepository.findByUserIdAndVideoId(userId,videoId);
            BeanUtils.copyProperties(userVideoPO1,userVideo);
            return userVideo;
        }
    }
    @Override
    public List<UserVideo> findByUserIdAndCourseId(Integer userId,Integer courseId){
        if(userVideoRepository.findByUserIdAndCourseId(userId,courseId)==null){
            return null;
        }else {
            List<UserVideo> userVideoList = new ArrayList<UserVideo>();
            List<UserVideoPO> userVideoPOList = userVideoRepository.findByUserIdAndCourseId(userId, courseId);
            System.out.println("这里是找userId和courseId"+userVideoPOList.size());
            for (int i = 0; i < userVideoPOList.size(); i++) {
                UserVideo userVideo = new UserVideo();
                BeanUtils.copyProperties(userVideoPOList.get(i), userVideo);
                userVideoList.add(userVideo);
//                System.out.println(i+"此时的i对应的用户类别"+userList.get(i).getUserType());
            }
            return userVideoList;
        }
    }

}
