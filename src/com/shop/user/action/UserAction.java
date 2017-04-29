package com.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.user.model.User;
import com.shop.user.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user = new User();
	public User getModel(){
		return user;
	}
	private UserService userService;
	
	
	/**
	 * 跳转到注册页面的执行方法
	 */
	public String register() throws Exception{
		return "regisPage";
	}
	
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * 
	 * @throws IOException
	 */
	public String findByName()throws Exception{
		User exituser = userService.findByusnameifexit(this.user.getUsername());
		//获取response对象，向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exituser!=null){
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
			
		}
		else{
			response.getWriter().println("<font color='blue'>用户名可用</font>");

		}
		
		return NONE;
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
