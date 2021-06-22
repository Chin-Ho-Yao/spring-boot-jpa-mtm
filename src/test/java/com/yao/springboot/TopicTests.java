package com.yao.springboot;


import com.yao.domain.Topic;
import com.yao.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
