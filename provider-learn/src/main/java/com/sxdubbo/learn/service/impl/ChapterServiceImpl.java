package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.ChapterPO;
import com.sxdubbo.learn.domain.ChapterPO;
import com.sxdubbo.learn.repository.ChapterRepository;
import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.service.ChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-02-01 15:24.
 **/
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    public ChapterRepository chapterRepository;

    @Override
    public List<Chapter> findByCourseId(Integer courseId){
        List<Chapter> chapterList= new ArrayList<Chapter>();

//        UserPO userPO = new UserPO();
        List<ChapterPO> chapterPOList = chapterRepository.findByCourseId(courseId);
        for(int i = 0 ; i < chapterPOList.size() ; i++) {
            Chapter chapter = new Chapter();
            BeanUtils.copyProperties(chapterPOList.get(i), chapter);
            chapterList.add(chapter);
        }
        System.out.println(chapterList.size()+"here is findBycourseId");
        return chapterList;
    }

    @Override
    public Chapter findById(Integer id){
        Chapter chapter = new Chapter();
        ChapterPO chapterPO = chapterRepository.findOne(id);
        BeanUtils.copyProperties(chapterPO, chapter);
        return chapter;
    }

    @Override//此处功能代码不全，删除章节的时候需要把所有的与课程相关的视频信息全部删除
    public void deleteChapter(Integer id){
        Chapter chapter = new Chapter();
        ChapterPO chapterPO = new ChapterPO();
        chapterPO = chapterRepository.findOne(id);
        chapterRepository.delete(chapterPO);
    }

    @Override
    public Chapter addChapter(Chapter chapter){
        Chapter chapter1 = new Chapter();
        ChapterPO chapterPO = new ChapterPO();
        ChapterPO chapterPO1 = new ChapterPO();
        BeanUtils.copyProperties(chapter, chapterPO);
        chapterPO1 = chapterRepository.save(chapterPO);
        BeanUtils.copyProperties(chapterPO1, chapter1);
        return chapter1;
    }

    @Override
    public Chapter updateChapter(Chapter chapter){
        ChapterPO chapterPO = new ChapterPO();
        Chapter chapter1 = new Chapter();
        ChapterPO chapterPO1 = new ChapterPO();
        BeanUtils.copyProperties(chapter, chapterPO);
        chapterPO1 = chapterRepository.save(chapterPO);
        BeanUtils.copyProperties(chapterPO1, chapter1);
        return chapter1;
    }
}
