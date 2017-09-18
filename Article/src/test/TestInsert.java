package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;

import service.CommentService;
import utils.DataBaseUtils;

public class TestInsert {
	/*@Test
	public void insert() {
		String sql = "INSERT INTO t_article(id,header,name,content,author,"
	            + "description,is_published,is_delete,create_time,update_time"
	            + ",user_id,category_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
	String id = UUID.randomUUID().toString(); //主键
	String header = "Java Web实用技术";
	String name  = "如何将MyEclipse项目导入eclipse";
	String content = "我们经常会在网上下载一些开源项目，或者从别的地方迁移一些项目进来，但经常会发现导入后各种报错。这是初学java肯定会遇到的问题，本文对一些常见的处理方案做一个总结。（本文将MyEclipse项目导入eclipse的过程为例，其他情况也可参考这个流程）";
	String author = "Jack";
	String description = "解决项目导入的冲突问题...";
	int isPublished = 1 ;
	int isDelete = 0;
	Date create=Date.valueOf("2017-08-26");
	Date update=Date.valueOf(LocalDate.now());
	String userId = "319600c3-550a-4f9f-80cf-deebe2376528";
	int categoryId = 2;
	DataBaseUtils.update(sql, id,header,name,content,author,description,isPublished,isDelete,create,update,userId,categoryId);
		System.out.println("新增成功！");
	}*/
//	@Test
//	public void insert(){
//		DataBaseUtils.update("insert into t_category values (?,?)", 1,"连载小说");
//		DataBaseUtils.update("insert into t_category values (?,?)", 2,"编程技术");
//		DataBaseUtils.update("insert into t_category values (?,?)", 3,"生活娱乐");
//	}
	
}
