package com.article.bean;

import java.util.Date;

import annotation.Column;
import annotation.Table;
@Table (tableName = "t_article")
public class ArticleBean {
	@Column(field = "id" , type = "varchar(100)" , primaryKey = true)
    private String id; //主键
    
    @Column(field = "header" , type = "varchar(100)")
    private String header; //标题
    
    @Column(field = "name" , type = "varchar(60)")
    private String name; //文章名称
    
    @Column(field = "content" , type = "text")
    private String content; //文章内容
     
    @Column(field = "author" , type = "varchar(30)")
    private String author; //作者
    
    @Column(field = "description" , type = "varchar(100)")
    private String description; //概要
    
    @Column(field = "is_published" , type = "int(1)")
    private Integer isPublished; //是否发布 0 未发布 1 发布
    
    @Column(field = "is_delete" , type = "int(1)")
    private Integer isDelete;      //是否删除   0 未删除 1 已删除
    
    @Column(field = "create_time" , type = "datetime")
    private Date createTime;//创建时间
    
    @Column(field = "update_time" , type = "timestamp" , defaultNull = false)
    private Date updateTime;//最后更新时间
    
    @Column(field = "user_id" , type = "varchar(100)" , defaultNull = false)
    private String userId;//作者id
    
    @Column(field = "category_id" , type = "int(2)" , defaultNull = false)
    private Integer categoryId;//分类ID

}
