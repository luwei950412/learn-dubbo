package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.QaPO;
import com.sxdubbo.learn.domain.QaReplyPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fxb on 18-3-8.
 */
public interface QaReplyRepository extends JpaRepository<QaReplyPO,Integer> {
    public List<QaReplyPO> findByQaPO(QaPO qaPO);
//    public QaReplyPO findByReply_id(Integer replyId);

    public QaReplyPO save(QaReplyPO qaReplyPO);
}
