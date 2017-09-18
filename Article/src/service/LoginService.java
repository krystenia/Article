package service;

import com.article.bean.UserBean;

import utils.DataBaseUtils;

public class LoginService {
	public static UserBean getUser(String username){
		String sql="select * from t_user where username = ?";
		UserBean ub=DataBaseUtils.queryForBean(sql, UserBean.class, username);
		return ub;
	}
}
