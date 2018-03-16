package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.QaPO;
import com.sxdubbo.learn.domain.QaReplyPO;
import com.sxdubbo.learn.repository.QaReplyRepository;
import com.sxdubbo.learn.utils.BeanTransferQa;
import com.sxdubboapi.learn.domain.Qa;
import com.sxdubboapi.learn.domain.QaReply;
import com.sxdubboapi.learn.service.QaReplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxb on 18-3-8.
 */
public class QaReplyServiceImp implements QaReplyService {
    @Autowired
    private QaReplyRepository qaReplyRepository;

    @Override
    public List<QaReply> findByQa(Qa qa){
        List<QaReply> qaReplyList=new ArrayList<>();
        QaPO qaPO=new QaPO();
        BeanUtils.copyProperties(qa,qaPO);
        List<QaReplyPO> qaReplyPOList=qaReplyRepository.findByQaPO(qaPO);
        BeanTransferQa.transferToQaReplyList(qaReplyPOList,qaReplyList);

        return qaReplyList;
    }
//    @Override
//    public QaReply findByQaReplyId(Integer qaReplyId){
//        QaReply qaReply=new QaReply();
//        QaReplyPO qaReplyPO=qaReplyRepository.findByReply_id(qaReplyId);
//        BeanTransferQa.transferToQaReply(qaReplyPO,qaReply);
//        return qaReply;
//    }


//    保存一个回复信息
    @Override
    public QaReply saveQaReply(QaReply qaReply){
        QaReplyPO qaReplyPO=new QaReplyPO();
        qaReplyPO=BeanTransferQa.transferToQaReplyPO(qaReply,qaReplyPO);
        QaReplyPO qaReplyPO1=qaReplyRepository.save(qaReplyPO);
        return qaReply;
    }

}
