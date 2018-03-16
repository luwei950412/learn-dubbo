package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.QaPO;
import com.sxdubbo.learn.domain.QaReplyPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.domain.VideoPO;
import com.sxdubboapi.learn.domain.Qa;
import com.sxdubboapi.learn.domain.QaReply;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.Video;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Created by fxb on 18-3-8.
 */
public class BeanTransferQa {
    public static List<Qa> transferToQaList(List<QaPO> qaPOList,List<Qa> qaList){
        for(int i=0;i<qaPOList.size();i++){
            Qa qa=new Qa();
            User user=new User();
            Video video=new Video();
            BeanUtils.copyProperties(qaPOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(qaPOList.get(i).getVideoPO(),video);
            BeanUtils.copyProperties(qaPOList.get(i),qa);
            qa.setUser(user);
            qa.setVideo(video);
            qaList.add(qa);
        }
        return qaList;
    }

    public static List<QaReply> transferToQaReplyList(List<QaReplyPO> qaReplyPOList,List<QaReply> qaReplyList){
        for(int i=0;i<qaReplyPOList.size();i++){
            QaReply qaReply=new QaReply();
            User user=new User();
            Qa qa=new Qa();
            BeanUtils.copyProperties(qaReplyPOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(qaReplyPOList.get(i).getQaPO(),qa);
            BeanUtils.copyProperties(qaReplyPOList.get(i),qaReply);
            qaReply.setUser(user);
            qaReply.setQa(qa);
            qaReplyList.add(qaReply);
        }
        return qaReplyList;
    }

    public static QaPO transferToQaPO(Qa qa,QaPO qaPO){
        UserPO userPO=new UserPO();
        VideoPO videoPO=new VideoPO();
        BeanUtils.copyProperties(qa.getUser(),userPO);
        BeanUtils.copyProperties(qa.getVideo(),videoPO);
        BeanUtils.copyProperties(qa,qaPO);
        qaPO.setUserPO(userPO);
        qaPO.setVideoPO(videoPO);
        return qaPO;
    }

    public static Qa transferToQa(QaPO qaPO,Qa qa){
        User user=new User();
        Video video=new Video();
        BeanUtils.copyProperties(qaPO.getUserPO(),user);
        BeanUtils.copyProperties(qaPO.getVideoPO(),video);
        BeanUtils.copyProperties(qaPO,qa);
        qa.setUser(user);
        qa.setVideo(video);
        return qa;

    }

    public static QaReply transferToQaReply(QaReplyPO qaReplyPO,QaReply qaReply){
        Qa qa=new Qa();
        User user=new User();
//        BeanUtils.copyProperties(qaReplyPO.getQaPO(),qa);
        BeanTransferQa.transferToQa(qaReplyPO.getQaPO(),qa);
        BeanUtils.copyProperties(qaReplyPO.getUserPO(),user);
        BeanUtils.copyProperties(qaReplyPO,qaReply);
        qaReply.setQa(qa);
        qaReply.setUser(user);
        return qaReply;
    }

    public static QaReplyPO transferToQaReplyPO(QaReply qaReply,QaReplyPO qaReplyPO){
        UserPO userPO=new UserPO();
        QaPO qaPO=new QaPO();
        BeanUtils.copyProperties(qaReply.getUser(),userPO);
        BeanTransferQa.transferToQaPO(qaReply.getQa(),qaPO);
        BeanUtils.copyProperties(qaReply,qaReplyPO);
        qaReplyPO.setQaPO(qaPO);
        qaReplyPO.setUserPO(userPO);
        return qaReplyPO;

    }
}
