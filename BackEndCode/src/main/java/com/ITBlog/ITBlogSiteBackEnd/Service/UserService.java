package com.ITBlog.ITBlogSiteBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ITBlog.ITBlogSiteBackEnd.Entity.User;
import com.ITBlog.ITBlogSiteBackEnd.Repository.UserRepository;

/**
 * 用户服务类
 * 提供用户操作的主要业务逻辑
 * 
 * @author 夜流歌
 *
 */
@Service
public class UserService {
	private UserRepository userRepository;
	
	/**
	 * 自动注入Repository的构造函数
	 * @param userRepository
	 */
	@Autowired
	public UserService(UserRepository userRepository) {
		this.setUserRepository(userRepository);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * 保存用户
	 * @param name
	 * @param gender
	 * @param age
	 * @param password
	 * @param phone
	 * @return code //0-正确 1-存储错误
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveUser(String name, int gender, int age, String password, long phone) {
		// Type是1表示普通用户
		User user = new User(name, gender, age, password, 0, 1, phone);
		// saveAndFlush 可以返回实体
		User userTemp = this.userRepository.saveAndFlush(user);
		if(userTemp == null) {
			return 1;
		}else if(userTemp.getUserId() == 0){
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 根据用户ID删除用户
	 * @param userId
	 * @return 0
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteUser(long userId) {
		this.userRepository.deleteById(userId);
		return 0;
	}
	
	/**
	 * 关闭用户账户
	 * @param userId
	 * @return code // 0-正确 1-找不到用户
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int closeUserAccount(long userId) {
		int effectedNum = this.userRepository.closeAccount(userId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 更新用户密码
	 * @param userId
	 * @param password
	 * @return code // 0-正确 1-找不到用户
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updatePassword(long userId, String password) {
		int effectedNum = this.userRepository.updatePassword(password, userId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 更新用户年龄
	 * @param userId
	 * @param age
	 * @return code // 0-正确 1-找不到用户
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateAge(long userId, int age) {
		int effectedNum = this.userRepository.updateAge(age, userId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 增加用户博客数量
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int addBlogNum(long userId) {
		int effectedNum = this.userRepository.addBlogNum(userId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 根据用户ID返回用户 不保证返回非空
	 * @param userId
	 * @return 非空-User NULL-找不到用户
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserByUserId(long userId) {
		User user = this.userRepository.findByUserId(userId);
		return user;
	}
	
	/**
	 * 根据用户Name和Password返回用户 不保证返回非空
	 * @param name
	 * @param password
	 * @return 非空-User NULL-找不到用户
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserByNameAndPassword(String name, String password) {
		User user = this.userRepository.findByNameAndPassword(name, password);
		return user;
	}
}
