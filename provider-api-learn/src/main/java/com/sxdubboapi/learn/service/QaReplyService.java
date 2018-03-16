package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Qa;
import com.sxdubboapi.learn.domain.QaReply;

import java.util.List;

/**
 * Created by fxb on 18-3-8.
 */
public interface QaReplyService {
    public List<QaReply> findByQa(Qa qa);
//    public QaReply findByQaReplyId(Integer qaReplyId);
//    提供保存QaReply的服务
    public QaReply saveQaReply(QaReply qaReply);
}
