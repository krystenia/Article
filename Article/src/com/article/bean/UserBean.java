package com.article.bean;

import annotation.Column;
import annotation.Table;

@Table(tableName = "t_user")
public class UserBean {
	@Column(type = "varchar(50)" ,field = "id" ,primaryKey = true ,defaultNull = false)
	public String id;        //主键，采用UUID

	@Column(type = "VARCHAR(20)", field = "username")
	public String username;  //用户名

	@Column(type = "VARCHAR(20)", field = "password")
	public String password;  //密码

	@Column(type = "VARCHAR(60)", field = "headerPic")
	public String headerPic; //头像

	@Column(type = "VARCHAR(60)", field = "email")
	public String email;     //电子邮箱

	@Column(type = "VARCHAR(2)", field = "sex")
	public Integer sex;      //性别 0男 1女 3保密

	@Column(type = "datetime", field = "create_time")
	public String createTime;//创建时间

	@Column(type = "timestamp", field = "update_time")
	public String updateTime;//最后更新时间

	@Column(type = "int(1)", field = "is_delete")
	public Integer isDelete; // 删除状态  0未删除  1删除

	@Column(type = "VARCHAR(200)", field = "address")
	public String address;   //地址

	@Column(type = "VARCHAR(15)", field = "telephone")
	public String telephone; //电话

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", headerPic=" + headerPic
				+ ", email=" + email + ", sex=" + sex + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", isDelete=" + isDelete + ", address=" + address + ", telephone=" + telephone + "]";
	}
}
