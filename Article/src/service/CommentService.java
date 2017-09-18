package service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import com.article.bean.Comment;

import utils.DataBaseUtils;

public class CommentService {
	
	public static void saveComment(Comment c){
		if(c==null){
			return;
		}
		if(c.articleId==null||c.userId==null){
			return;
		}
		String sql="insert into t_comment values (?,?,?,?,?,?,?)";
		Timestamp create=new Timestamp(Long.parseLong(c.createTime));
		Timestamp update=new Timestamp(Long.parseLong(c.updateTime));
		DataBaseUtils.update(sql, c.id,c.userId,c.content,c.articleId,create,update,c.isDelete);
		System.out.println("保存成功！");
	}
	
	public static List<Map<String,Object>> getCommentsById(String articleId){
		String sql="select id,user_Id,content,create_time,update_time from t_comment where article_id=? order by update_time asc";
		List<Map<String,Object>> data=DataBaseUtils.queryForList(sql, articleId);
		return data;
	}

}
