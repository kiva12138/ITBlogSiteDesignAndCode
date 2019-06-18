package com.ITBlog.ITBlogSiteBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * 管理员用户的服务类
 * @author 夜流歌
 *
 */
@Service
public class AdminService {
	private UserService userService;
	private BlogService blogService;
	private CommentService commentService;
	
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	@Autowired
	public AdminService (UserService userService, BlogService blogService, CommentService commentService) {
		this.setUserService(userService);
		this.setBlogService(blogService);
		this.setCommentService(commentService);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 通过管理员增加用户
	 * @param adminId
	 * @param name
	 * @param gender
	 * @param age
	 * @param password
	 * @param phone
	 * @return code 0-Correct 1-SaveError 2-adminId not administrator
	 */
	public int saveUser(long adminId, String name, int gender, int age, String password, long phone) {
		int result = 0;
		int adminType = this.userService.getTypeByUserId(adminId);
		if(adminType == 0) {
			result = this.userService.saveUser(name, gender, age, password, phone);
		}else {
			result = 2;
		}
		
		return result;
	}
	
	/**
	 * 管理员来进行用户的删除操作
	 * @param adminId
	 * @param userId
	 * @return code 0-Correct 2-adminId not administrator
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUser(long adminId, long userId) {
		int result = 0;
		int adminType = this.userService.getTypeByUserId(adminId);
		if(adminType == 0) {
			result = this.userService.deleteUser(userId);
		}else {
			result = 2;
		}
		
		return result;
	}
	
	/**
	 * 管理员来进行关闭账户
	 * @param adminId
	 * @param userId
	 * @return code 0-Correct 1-No User 2-not Administrator
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int closeUserAccount(long adminId, long userId) {
		int result = 0;
		int adminType = this.userService.getTypeByUserId(adminId);
		if(adminType == 0) {
			result = this.userService.closeUserAccount(userId);
		}else {
			result = 2;
		}
		return result;
	}
	
	/**
	 * 管理员修改密码
	 * @param adminId
	 * @param userId
	 * @param password
	 * @return code 0-Correct 1-No User 2-not Administrator
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updatePassword(long adminId, long userId, String password) {
		int result = 0;
		int adminType = this.userService.getTypeByUserId(adminId);
		if(adminType == 0) {
			result = this.userService.updatePassword(userId, password);
		}else {
			result = 2;
		}
		return result;
	}
	
	/**
	 * 未完成 
	 * 
	 * 管理员来删除博客
	 * @param adminId
	 * @param blogId
	 * @return code 0-Correct 1-No Blog 2-not Administrator
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteBlog(long adminId, long blogId) {
		int result = 0;
		int adminType = this.userService.getTypeByUserId(adminId);
		if(adminType == 0) {
			this.blogService.deleteBlog(blogId);
		}else {
			result = 2;
		}
		return result;
	}
	
	/**
	 * 未完成
	 * 
	 * 管理员来删除评论
	 * @param adminId
	 * @return code 0-Correct 1-Error 2-not Administrator
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteComment(long adminId, long commentId) {
		int result = 0;
		int adminType = this.userService.getTypeByUserId(adminId);
		if(adminType == 0) {
			this.commentService.deleteComment(commentId);
		}else {
			result = 2;
		}
		return result;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
}
