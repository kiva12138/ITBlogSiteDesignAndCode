package com.ITBlog.ITBlogSiteBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITBlog.ITBlogSiteBackEnd.Response.AdminResponse;
import com.ITBlog.ITBlogSiteBackEnd.Service.AdminService;

/**
 * 管理员的控制类
 * @author 夜流歌
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.setAdminService(adminService);
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * 管理员增加用户的接口
	 * @param adminId
	 * @param name
	 * @param gender
	 * @param age
	 * @param password
	 * @param phone
	 * @return AdminResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError 3-Not Administrator.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value="/adduser", method = RequestMethod.POST)
	public AdminResponse saveUser(@RequestParam long adminId,
								@RequestParam String name,
								@RequestParam int gender, 
								@RequestParam int age, 
								@RequestParam String password, 
								@RequestParam long phone) {
		AdminResponse adminResponse = new AdminResponse();
		if(name == null || password == null) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}else {
			name = name.trim();
			password = password.trim();
		}
		
		// Judge Empty Values
		if(adminId == 0 || name == "" || (gender != 1 && gender != 2) || age == 0 || password == "" || phone == 0) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		
		// Save To Service
		int code = this.adminService.saveUser(adminId, name, gender, age, password, phone);
		if(code == 0) {
			adminResponse.setCode(0);
		}else if(code == 1){
			adminResponse.setCode(2);
			adminResponse.setDescription("Service Error!");
		}else if(code == 2) {
			adminResponse.setCode(3);
			adminResponse.setDescription("This ID is Not An Administrator!");
		}
		return adminResponse;
	}
	
	/**
	 * 管理员删除用户接口
	 * @param adminId
	 * @param userId 
	 * @return AdminResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError 3-Not Administrator.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value="/deleteuser",  method = RequestMethod.GET)
	public AdminResponse deleteUser(@RequestParam long adminId,
									@RequestParam long userId) {
		AdminResponse adminResponse = new AdminResponse();
		
		// Judge Empty Values
		if(userId == 0 || adminId == 0) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		
		// Save To Service
		int code = this.adminService.deleteUser(adminId, userId);
		if(code == 0) {
			adminResponse.setCode(0);
		}else if(code == 2){
			adminResponse.setCode(3);
			adminResponse.setDescription("Not Administrator!");
		}
				
		return adminResponse;
	}
	
	/**
	 * 管理员关闭账户
	 * @param adminId
	 * @param userId
	 * @return AdminResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError 3-Not Administrator.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value="/closeaccount",  method = RequestMethod.GET)
	public AdminResponse closeAccount(@RequestParam long adminId,
									@RequestParam long userId) {
		AdminResponse adminResponse = new AdminResponse();
		
		// Judge Empty Values
		if(userId == 0 || adminId ==0) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		
		// Save To Service
		int code = this.adminService.closeUserAccount(adminId, userId);
		if(code == 0) {
			adminResponse.setCode(0);
		}else if(code == 1){
			adminResponse.setCode(2);
			adminResponse.setDescription("No User Found!");
		}else if(code == 2) {
			adminResponse.setCode(3);
			adminResponse.setDescription("Not Administrator!");
		}
				
		return adminResponse;
	}
	
	/**
	 * 管理员修改密码
	 * @param adminId
	 * @param userId
	 * @param password
	 * @return AdminResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError 3-Not Administrator.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */ 
	@RequestMapping(value="/updatepassword", method=RequestMethod.POST)
	public AdminResponse updatePassword(@RequestParam long adminId,
										@RequestParam long userId,
										@RequestParam String password) {
		AdminResponse adminResponse = new AdminResponse();
		
		if(password != null) {
			password = password.trim();
		}else {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		// Judge Empty Values
		if(userId == 0 || password == "" || adminId == 0) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		
		// Save To Service
		int code = this.adminService.updatePassword(adminId, userId, password);
		if(code == 0) {
			adminResponse.setCode(0);
		}else if(code == 1){
			adminResponse.setCode(2);
			adminResponse.setDescription("No User!");
		}else if(code  == 2) {
			adminResponse.setCode(3);
			adminResponse.setDescription("Not Administrator!");
		}
				
		return adminResponse;
	}
	
	/**
	 * 
	 * 未完成
	 * 
	 * 管理员删除博客
	 * @param userId
	 * @param blogId
	 * @return AdminResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError 3-Not Administrator.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value="/deleteBlog",  method = RequestMethod.GET)
	public AdminResponse deleteBlog(@RequestParam long adminId,
									@RequestParam long blogId) {
		AdminResponse adminResponse = new AdminResponse();
		
		// Judge Empty Values
		if(blogId == 0 || adminId == 0) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		
		// Save To Service
		int code = this.adminService.deleteBlog(adminId, blogId);
		if(code == 0) {
			adminResponse.setCode(0);
		}else if(code == 1){
			adminResponse.setCode(2);
			adminResponse.setDescription("No Blog Found!");
		}else if(code  == 2) {
			adminResponse.setCode(3);
			adminResponse.setDescription("Not Administrator!");
		}
				
		return adminResponse;
	}
	
	/**
	 * 
	 * 未完成
	 * 
	 * 管理员删除博客评论
	 * @param adminId
	 * @return
	 */
	@RequestMapping(value="/deletecomment",  method = RequestMethod.GET)
	public AdminResponse deleteComment(@RequestParam long adminId, @RequestParam long commentId) {
		AdminResponse adminResponse = new AdminResponse();
		
		// Judge Empty Values
		if(adminId == 0 || commentId == 0) {
			adminResponse.setCode(1);
			adminResponse.setDescription("Empty Value!");
			return adminResponse;
		}
		
		// Save To Service
		int code = this.adminService.deleteComment(adminId, commentId);
		if(code == 0) {
			adminResponse.setCode(0);
		}else if(code == 1){
			adminResponse.setCode(2);
			adminResponse.setDescription("Service Error!");
		}else if(code  == 2) {
			adminResponse.setCode(3);
			adminResponse.setDescription("Not Administrator!");
		}
		
		return adminResponse;
}
	
}
