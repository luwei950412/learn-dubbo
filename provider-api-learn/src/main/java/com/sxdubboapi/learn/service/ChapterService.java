package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Chapter;

import java.util.List;

/**
 * created by  luwei
 * 2018-02-01 15:29.
 **/
public interface ChapterService {

    public List<Chapter> findByCourseId(Integer courseId);
    public Chapter findById(Integer id);

    public void deleteChapter(Integer id);
    public Chapter addChapter(Chapter chapter);
    public Chapter updateChapter(Chapter chapter);
}
