package com.yao.service;

import com.alibaba.fastjson.JSON;
import com.yao.domain.Article;
import com.yao.domain.ArticleRepository;
import com.yao.domain.Topic;
import com.yao.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

/**
 * Created by Jack Yao on 2021/6/22 4:43 下午
 */

@Service
public class TopicServiceImpl implements TopicService{


    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic findTopic(Long id) {
        Topic topic = topicRepository.findOne(id);
        System.out.println(JSON.toJSONString(topic, true));

        return topic;
    }

    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findOne(topicId);
        Article article = articleRepository.findOne(articleId);
        topic.getArticles().add(article);
        return topic;
    }

    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        /*獲取專題*/
        Topic topic = topicRepository.findOne(topicId);
        /*獲取要取消的文章*/
        Article article = articleRepository.findOne(articleId);
        /*在這專題中拿到文章並取消*/
        topic.getArticles().remove(article);
        /*這些動作要保持在一個事物裡面，提交後就會同步到數據庫*/
        return topic;
    }

    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.delete(id);
    }



}
