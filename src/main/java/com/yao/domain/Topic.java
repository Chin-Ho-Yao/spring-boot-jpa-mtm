package com.yao.domain;

import com.yao.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack Yao on 2021/6/22 4:31 下午
 */
@Entity
public class Topic {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @ManyToMany
    private List<Article> articles = new ArrayList<>();


    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

