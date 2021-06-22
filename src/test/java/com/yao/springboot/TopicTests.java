package com.yao.springboot;


import com.alibaba.fastjson.JSON;
import com.yao.domain.Topic;
import com.yao.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack Yao on 2021/6/22 5:43 下午
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTests {

    @Autowired
    private TopicService topicService;

    @Test
    public void saveTopic(){
        Topic topic = new Topic();
        topic.setName("藝術");
        topicService.saveTopic(topic);
    }

    @Test
    public void updateTopic(){
        Topic topic = topicService.findTopic(1L);
        topic.setName("文學");
        topicService.saveTopic(topic);

    }

    @Test
    public void includeArticle(){
        topicService.includeArticle(1L,1L);
    }

    @Test
    public void fndTopic(){
        Topic topic = topicService.findTopic(1L);
    }

    @Test
    public void unIncludeArticle(){
         topicService.unIncludeArticle(1L,1L);
    }

    @Test
    public void deleteTopic(){
        topicService.deleteTopic(1L);
        /*會刪除topic表的資料還有topic與article關聯表的資料*/
    }

}
