package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.article.bean.ArticleBean;

import utils.DataBaseUtils;

public class ArticleService {
	public static List<Map<String,Object>> getArticleByCategory(String cateName){
		String sql="select id,header,name,content,author,description from t_article where category_id=(select category_id from t_category where category_name=?) and rownum<=3 order by id";
		List<Map<String,Object>> data=DataBaseUtils.queryForList(sql,cateName);
		return data;
	}
	
	public static Map<String,Object> getArticleById(String id){
		String sql="select * from t_article where id=?";
		Map<String, Object> map=null;
		try {
			map = DataBaseUtils.queryForMap(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
}
