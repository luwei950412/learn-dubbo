package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TestPaperPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.TestPaperRepository;
import com.sxdubbo.learn.utils.BeanTransferTestPaper;
import com.sxdubbo.learn.utils.BeanTransferUserTest;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TestPaper;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.TestPaperService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:08.
 **/
public class TestPaperServiceImpl implements TestPaperService{

    @Autowired
    public TestPaperRepository testPaperRepository;

    @Override
    public List<TestPaper> findByCourse(Course course){
        List<TestPaper> testPaperList= new ArrayList<TestPaper>();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(course,coursePO);
        List<TestPaperPO> testPaperPOList= testPaperRepository.findByCoursePO(coursePO);
        BeanTransferTestPaper.transferTestPaperList(testPaperPOList,testPaperList);
        return testPaperList;
    }
    @Override
    public List<TestPaper> findByUser(User user){
        List<TestPaper> testPaperList= new ArrayList<TestPaper>();
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user,userPO);
        List<TestPaperPO> testPaperPOList= testPaperRepository.findByUserPO(userPO);
        BeanTransferTestPaper.transferTestPaperList(testPaperPOList,testPaperList);
        return testPaperList;
    }

    @Override
    public TestPaper findById(Integer id){
        TestPaper testPaper = new TestPaper();
        TestPaperPO testPaperPO = testPaperRepository.findOne(id);
        BeanTransferTestPaper.transferTestPaper(testPaperPO,testPaper);
        return testPaper;
    }

    @Override
    public List<TestPaper> findAllQuestion(){
        List<TestPaper> testPaperList= new ArrayList<TestPaper>();
        List<TestPaperPO> testPaperPOList= testPaperRepository.findAll();
        BeanTransferTestPaper.transferTestPaperList(testPaperPOList,testPaperList);
        return testPaperList;
    }


    @Override
    @Transactional
    public TestPaper addTestPaper(TestPaper testPaper){
        TestPaperPO testPaperPO= new TestPaperPO();
        BeanTransferTestPaper.transferTestPaper(testPaper,testPaperPO);
        testPaperRepository.save(testPaperPO);
        return testPaper;
    }

    @Override
    public void deleteTestPaper(Integer testPaperId){
        testPaperRepository.delete(testPaperId);
    }
}
