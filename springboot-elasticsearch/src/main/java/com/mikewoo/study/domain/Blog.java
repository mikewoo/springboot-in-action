package com.mikewoo.study.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 博客文档实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/26 15:39
 */
// indexName ：索引名字（对应类似mysql的数据库名字）
//type:类型（对应类似mysql的表名）
@Document(indexName = "blog", type = "blog") // 标识为一个文档
public class Blog implements Serializable {

    @Id
    private String id;

    private String title;

    private String summary;

    private String content;

    public Blog() {
    }

    public Blog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
