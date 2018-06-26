package com.mikewoo.study.repository;

import com.mikewoo.study.domain.Blog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Blog Repository 测试用例
 *
 * @auther Phantom Gui
 * @date 2018/6/26 15:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(BlogRepositoryTest.class);

    @Autowired
    private BlogRepository repository;

    @Before
    public void initRepositoryData() {
        // 清除测试数据
        repository.deleteAll();

        // 插入测试数据
        repository.save(new Blog("elasticsearch基础",
                "Elasticsearch是一个基于Apache Lucene(TM)的开源搜索引擎",
                "ElasticSearch是一个基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。"));
        repository.save(new Blog("Spring Boot集成ElasticSearch",
                "Elastic Search是一个开源的，分布式，实时搜索和分析引擎",
                "Spring Boot为Elasticsearch及Spring Data Elasticsearch提供的基于它的抽象提供了基本的配置。Spring Boot提供了一个用于聚集依赖的spring-boot-starter-data-elasticsearch 'StarterPOM'。"));
        repository.save(new Blog("全文搜索引擎 Elasticsearch 入门教程",
                "全文搜索属于最常见的需求，开源的 Elasticsearch （以下简称 Elastic）是目前全文搜索引擎的首选。",
                "全文搜索属于最常见的需求，开源的 Elasticsearch （以下简称 Elastic）是目前全文搜索引擎的首选。它可以快速地储存、搜索和分析海量数据。维基百科、Stack Overflow、Github 都采用它。"));

    }

    @Test
    public void findDistinctByTitleContainingOrSummaryContainingOrContentContaining() {
        String title = "elasticsearch";
        String summary = "搜索引擎";
        String content = "全文搜索";
        Pageable pageable = PageRequest.of(0, 1);
        Page<Blog> blogPage = repository.findDistinctByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        LOG.info("size: {}", blogPage.getSize());
        LOG.info("================");
        for (Blog blog :
                blogPage.getContent()) {
            LOG.info("blog: {}", blog);
        }
    }
}