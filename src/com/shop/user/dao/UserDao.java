package com.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.shop.user.model.User;

public class UserDao extends HibernateDaoSupport{

	
	// 按名次查询是否有该用户:
	public User findByusnameifexit(String username){
		String sql="from User where username=?";
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) this.getHibernateTemplate().find(sql, username);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	
		
	}

}
