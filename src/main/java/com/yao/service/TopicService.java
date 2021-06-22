package com.yao.service;

import com.yao.domain.Topic;

/**
 * Created by Jack Yao on 2021/6/22 4:43 下午
 */
public interface TopicService {
    Topic saveTopic(Topic topic);
    Topic updateTopic(Topic topic);
    Topic findTopic(Long id);
    /*收錄文章*/
    Topic includeArticle(Long topicId,Long articleId);
    Topic unIncludeArticle(Long topicId, Long articleId);

    void deleteTopic(Long id);
}
