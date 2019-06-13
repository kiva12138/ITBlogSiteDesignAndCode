package com.ITBlog.ITBlogSiteBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITBlog.ITBlogSiteBackEnd.Entity.User;
import com.ITBlog.ITBlogSiteBackEnd.Response.GetUserResponse;
import com.ITBlog.ITBlogSiteBackEnd.Response.UserResponse;
import com.ITBlog.ITBlogSiteBackEnd.Service.UserService;

/**
 * 用户的控制类
 * @author 夜流歌
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.setUserService(userService);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 
	 * @param name
	 * @param gender
	 * @param age
	 * @param password
	 * @param phone
	 * @return UserResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public UserResponse addUser(@RequestParam String name,
								@RequestParam int gender, 
								@RequestParam int age, 
								@RequestParam String password, 
								@RequestParam long phone) {
		UserResponse userResponse = new UserResponse();
		
		if(name == null || password == null) {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value1!");
			return userResponse;
		}else {
			name = name.trim();
			password = password.trim();
		}
		
		// Judge Empty Values
		if(name == "" || (gender != 1 && gender != 2) || age == 0 || password == "" || phone == 0) {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value2!");
			return userResponse;
		}
		
		// Save To Service
		int code = this.userService.saveUser(name, gender, age, password, phone);
		if(code == 0) {
			userResponse.setCode(0);
		}else {
			userResponse.setCode(2);
			userResponse.setDescription("Service Error!");
		}
		return userResponse;
	}
	
	
	/**
	 * 
	 * @param userId
	 * @return UserResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public UserResponse deleteUser(@RequestParam long userId) {
		UserResponse userResponse = new UserResponse();
		
		// Judge Empty Values
		if(userId == 0) {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value!");
			return userResponse;
		}
		
		// Save To Service
		int code = this.userService.deleteUser(userId);
		if(code == 0) {
			userResponse.setCode(0);
		}else {
			userResponse.setCode(2);
			userResponse.setDescription("Service Error!");
		}
				
		return userResponse;
	}
	
	/**
	 * 关闭用户账户
	 * @param userId
	 * @return UserResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value = "/closeaccount", method = RequestMethod.GET)
	public UserResponse closeAccount(@RequestParam long userId) {
		UserResponse userResponse = new UserResponse();
		
		// Judge Empty Values
		if(userId == 0) {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value!");
			return userResponse;
		}
		
		// Save To Service
		int code = this.userService.closeUserAccount(userId);
		if(code == 0) {
			userResponse.setCode(0);
		}else {
			userResponse.setCode(2);
			userResponse.setDescription("Service Error!");
		}
				
		return userResponse;
	}
	
	/**
	 * 更新用户密码
	 * @param userId
	 * @param password
	 * @return UserResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public UserResponse updatePassword(@RequestParam long userId,
										@RequestParam String password) {
		UserResponse userResponse = new UserResponse();
		
		if(password != null) {
			password = password.trim();
		}else {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value!");
			return userResponse;
		}
		// Judge Empty Values
		if(userId == 0 || password == "") {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value!");
			return userResponse;
		}
		
		// Save To Service
		int code = this.userService.updatePassword(userId, password);
		if(code == 0) {
			userResponse.setCode(0);
		}else {
			userResponse.setCode(2);
			userResponse.setDescription("Service Error!");
		}
				
		return userResponse;
	}
	
	/**
	 * 更新用户年龄
	 * @param userId
	 * @param age
	 * @return UserResponse 
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 */
	@RequestMapping(value = "/updateage", method = RequestMethod.POST)
	public UserResponse updateAge(@RequestParam long userId,
										@RequestParam int age) {
		UserResponse userResponse = new UserResponse();
		
		// Judge Empty Values
		if(userId == 0 || age == 0) {
			userResponse.setCode(1);
			userResponse.setDescription("Empty Value!");
			return userResponse;
		}
		
		// Save To Service
		int code = this.userService.updateAge(userId, age);
		if(code == 0) {
			userResponse.setCode(0);
		}else {
			userResponse.setCode(2);
			userResponse.setDescription("Service Error!");
		}
				
		return userResponse;
	}
	
	/**
	 * 根据用户Id返回用户个人数据
	 * @param userId
	 * @return GetUserResponse
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 * 			userInfo: userId, age, gender, blogNum, phone
	 */
	@RequestMapping(value = "/getuserbyuserid", method = RequestMethod.GET)
	public GetUserResponse getUserByUserId(@RequestParam long userId) {
		GetUserResponse getUserResponse = new GetUserResponse();
		
		if(userId == 0) {
			getUserResponse.setCode(1);
			getUserResponse.setDescription("Empty Value!");
			return getUserResponse;
		}
		
		User user = this.userService.getUserByUserId(userId);
		if(user == null) {
			getUserResponse.setCode(2);
			getUserResponse.setDescription("Service Error!");
			return getUserResponse;
		}
		
		getUserResponse.setCode(0);
		getUserResponse.setGender(user.getGender());
		getUserResponse.setName(user.getName());
		getUserResponse.setPhone(user.getPhone());
		getUserResponse.setAge(user.getAge());
		getUserResponse.setUserId(userId);
		getUserResponse.setBlogNum(user.getBlogNum());
		return getUserResponse;
	}
	
	/**
	 * 根据用户名字和密码返回用户
	 * @param name
	 * @param password
	 * @return GetUserResponse
	 * 			code: 0-Correct 1-EmptyValue 2-ServiceError.
	 * 			description: Description Of Error; if code==0 this should be NULL.
	 * 			userInfo: userId, age, gender, blogNum, phone
	 */
	@RequestMapping(value = "/getuserbynameandpassword", method = RequestMethod.GET)
	public GetUserResponse getUserByNameAndPassword(@RequestParam String name,
													@RequestParam String password) {
		GetUserResponse getUserResponse = new GetUserResponse();
		
		// Judge Empty
		if(name == null || password == null) {
			getUserResponse.setCode(1);
			getUserResponse.setDescription("Empty Value!");
			return getUserResponse;
		}else {
			name = name.trim();
			password = password.trim();			
		}

		if(name == "" || password == "") {
			getUserResponse.setCode(1);
			getUserResponse.setDescription("Empty Value!");
			return getUserResponse;
		}
		
		User user = this.userService.getUserByNameAndPassword(name, password);
		if(user == null) {
			getUserResponse.setCode(2);
			getUserResponse.setDescription("Service Error!");
			return getUserResponse;
		}
		
		getUserResponse.setCode(0);
		getUserResponse.setGender(user.getGender());
		getUserResponse.setName(user.getName());
		getUserResponse.setPhone(user.getPhone());
		getUserResponse.setAge(user.getAge());
		getUserResponse.setUserId(user.getUserId());
		getUserResponse.setBlogNum(user.getBlogNum());
		return getUserResponse;
	}
}
