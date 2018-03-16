package com.sxdubbo.learn.controller;

import com.sxdubbo.learn.utils.LuceneUtils;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static com.sxdubbo.learn.utils.LuceneUtils.createDocument;
import static org.apache.lucene.util.Version.LUCENE_41;

/**
 * Created by fxb on 18-3-10.
 */
@Controller
@RequestMapping(value = "search")
public class SearchController {
    @Autowired
    public CourseService courseService;
    @Autowired
    public RedisService redisService;
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/course")
    public String search(@RequestParam(value = "words",required = true)String searchText,Model model) throws IOException, ParseException {
        List<Course> courseList=courseService.findAllCourse();
//        Analyzer analyzer = new StandardAnalyzer(LUCENE_41);
//        中文分词器
        Analyzer analyzer=new IKAnalyzer(true);
        Directory idx = new RAMDirectory();
//        Directory idx = new LuceneUtils.MyRAMDirectory();

//        Directory idx=new MMapDirectory(new File("consumer-learn/target/index"));
//      加入逻辑 判断数据库是否有更新 没有则不需要读取数据库
        IndexWriterConfig iwc = new IndexWriterConfig(LUCENE_41,analyzer);
        IndexWriter writer = new IndexWriter(idx, iwc);

        List<String> userNameList=new LinkedList<>();


        for (Course c:courseList){
            writer.addDocument(LuceneUtils.createDocument(Integer.toString(c.getId()),c.getCourseName(),c.getIntroduction(),c.getType()));

        }
        writer.commit();
        writer.close();
//
//        redisService.setObj("idx",idx);
//        idx=(Directory) redisService.getObj("idx");
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(idx));
        String[] fields={"name","introduction","type"};
        TopDocs topdoc =  searcher.search(new MultiFieldQueryParser(LUCENE_41,fields, analyzer).parse(searchText), 50);

        System.out.println("命中个数:"+searcher.search(new MultiFieldQueryParser(LUCENE_41,fields, analyzer).parse(searchText), 50).totalHits);
        System.out.println(searchText);
        ScoreDoc[] hits=  topdoc.scoreDocs;
        List<Course> courseList1=new LinkedList<>();

        if(hits!=null && hits.length>0){
            for(int i = 0; i < hits.length; i++){
                Document hitDoc = searcher.doc(hits[i].doc);
                courseList1.add(courseService.findById(new Integer(hitDoc.get("id"))));

                System.out.println(hitDoc.get("id"));
//                没保存
                System.out.println(hitDoc.get("name"));
                System.out.println(hitDoc.get("type"));
                System.out.println(hitDoc.get("introduction"));
            }

            for (Course c:courseList1){
                userNameList.add(userService.getUserById(c.getUserId()).getUsername());
            }
        }
        System.out.println("courseList1.size()"+courseList1.size());
        System.out.println("userNameList.size()"+userNameList.size());
        model.addAttribute("text",searchText);
        model.addAttribute("searchCourseList",courseList1);
        model.addAttribute("userNameList",userNameList);
        return "front/search/sousuo";

    }

    @RequestMapping(value = "test")
    public  String test(){
        return "front/search/sousuo";
    }
}
