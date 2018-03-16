package com.sxdubbo.learn.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.store.RAMDirectory;

import java.io.Serializable;

/**
 * Created by fxb on 18-3-10.
 */
public class LuceneUtils {
    public static Document createDocument(String id,String name, String introduction, String type) {
        Document doc = new Document();
        doc.add(new Field("id",id, TextField.TYPE_STORED));
        doc.add(new Field("introduction", introduction, TextField.TYPE_NOT_STORED));
        doc.add(new Field("name", name, TextField.TYPE_NOT_STORED));
        doc.add(new Field("type",type, TextField.TYPE_NOT_STORED));
        return doc;
    }



}
