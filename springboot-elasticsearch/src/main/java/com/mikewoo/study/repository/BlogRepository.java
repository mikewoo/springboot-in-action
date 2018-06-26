package com.mikewoo.study.repository;

import com.mikewoo.study.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Blog Repository 接口
 *
 * @auther Phantom Gui
 * @date 2018/6/26 15:46
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {

    /**
     * 分页查询博客信息（去重）
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<Blog> findDistinctByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
