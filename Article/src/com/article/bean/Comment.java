package com.article.bean;

import annotation.Column;
import annotation.Table;

@Table(tableName = "t_comment")
public class Comment {
	@Column(type = "varchar(100)", field = "id", primaryKey = true, defaultNull = false)
	public String id; // 主键，采用UUID

	@Column(type = "VARCHAR(100)", field = "user_id")
	public String userId; // 评论者的ID

	@Column(type = "VARCHAR(600)", field = "content")
	public String content; // 评论内容

	@Column(type = "VARCHAR(100)", field = "article_id")
	public String articleId; // 文章ID

	@Column(type = "datetime", field = "create_time")
	public String createTime;// 创建时间

	@Column(type = "timestamp", field = "update_time")
	public String updateTime;// 最后更新时间
	
	@Column(type = "int", field = "is_delete")
	public Integer isDelete; // 删除状态 0未删除 1删除

	public Comment() {

	}

	public Comment(String id, String userId, String content, String articleId, String createTime, String updateTime,
			Integer isDelete) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.articleId = articleId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
	}

}
