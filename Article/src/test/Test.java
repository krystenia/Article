package test;

import com.article.bean.ArticleBean;
import com.article.bean.Comment;
import com.article.bean.UserBean;

import service.CommentService;
import utils.TableUtils;

public class Test {
	 public static void main(String[] args) {
	        /*String sql = TableUtils.getCreateTableSQl(Comment.class);
	        System.out.println(sql);*/
		 Comment c=new Comment("10002","fb505825-65ae-4e42-8d90-cd86f321cbc6","此类教程对于前端来学再好不过了，加油！","1003","2017-08-25","2017-08-26",0);
		 CommentService.saveComment(c);
		 
		 /*InputStream inputStream =  Test.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 Properties p = new Properties();
		 try {
		     p.load(inputStream);
		     System.out.println(p);
		 } catch (IOException e) {
		     e.printStackTrace();
		 }*/
		 
		 /*DataBaseUtils.config("jdbc.properties");
		 Connection conn = DataBaseUtils.getConnection();
		 System.out.println(conn);*/
		 
		/* String id = UUID.randomUUID() + "";
		 DataBaseUtils.update("INSERT INTO t_user(id,username,password,sex,create_time,is_delete,address,telephone) "
			        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", id,"张三",123456,0,new java.sql.Timestamp(new Date().getTime()),0,"保密","保密");*/
		 
		/* List list = DataBaseUtils.queryForList("select * from t_user");
		 System.out.println(list);*/
		 
		/*try {
			Map map = DataBaseUtils.queryForMap("select * from t_user where username = '张三'");
			System.out.println(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 UserBean ub=DataBaseUtils.queryForBean("SELECT * FROM t_user where username = ?", UserBean.class, "张三");
		 System.out.println(ub);*/
	    }
}
