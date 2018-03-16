package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.QaPO;
import com.sxdubbo.learn.domain.VideoPO;
import com.sxdubbo.learn.repository.QaRepository;
import com.sxdubbo.learn.utils.BeanTransferQa;
import com.sxdubboapi.learn.domain.Qa;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.QaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fxb on 18-3-8.
 */
public class QaServiceImp implements QaService {
    @Autowired
    private QaRepository qaRepository;

    @Override
    public List<Qa> findByVideo(Video video){

        VideoPO videoPO= new VideoPO();
        BeanUtils.copyProperties(video,videoPO);
        List<QaPO> qaPOList=qaRepository.findByVideoPO(videoPO);
        List<Qa> qaList=new ArrayList<>();
        //        qaPOList----->qaList
        BeanTransferQa.transferToQaList(qaPOList,qaList);
        return qaList;
    }

    @Override
    public Qa findById(Integer id){
        QaPO qaPO=qaRepository.findById(id);
        Qa qa=new Qa();
        BeanTransferQa.transferToQa(qaPO,qa);
        return qa;
    }
    @Override
    public List<Qa> findAllQa(){
        List<Qa> qaList= new ArrayList<Qa>();
        List<QaPO> qaPOList= qaRepository.findAll();
        for(int i = 0 ; i < qaPOList.size() ; i++) {
            Qa qa= new Qa();
            BeanUtils.copyProperties(qaPOList.get(i), qa);
            qaList.add(qa);
        }
        return qaList;
    }
    @Override
    public Qa saveQa(Qa qa){
        QaPO qaPO=new QaPO();
        qaPO=BeanTransferQa.transferToQaPO(qa,qaPO);
        QaPO qaPO1=qaRepository.save(qaPO);
        return qa;
    }
}
