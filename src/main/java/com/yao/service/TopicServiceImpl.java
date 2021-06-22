package com.yao.service;

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
        return topicRepository.findOne(id);
    }

    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findOne(topicId);
        Article article = articleRepository.findOne(articleId);
        topic.getArticles().add(article);
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findOne(topicId);
        Article article = articleRepository.findOne(articleId);
        topic.getArticles().add(article);
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.delete(id);
    }
}
