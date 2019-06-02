package com.ITBlog.ITBlogSiteBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ITBlog.ITBlogSiteBackEnd.Entity.User;

/**
 * User的数据库访问接口
 * 
 * @author 夜流歌
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * 通过用户Id查找用户
	 * @param userId
	 * @return User
	 */
	User findByUserId(long userId);
	
	/**
	 * 通过用户名和密码查找用户
	 * @param name
	 * @param password
	 * @return User
	 */
	User findByNameAndPassword(String name, String password);
	
	/**
	 * 更新用户密码
	 * @param password
	 * @param uid
	 * @return 受影响的用户数
	 */
	@Modifying
	@Query(value="UPDATE User user SET user.password=:password WHERE user.userId=:userId")
	int updatePassword(@Param ("password")String password, @Param ("userId") long userId);
	
	/**
	 * 更新用户年龄
	 * @param age
	 * @param userId
	 * @return 受影响的用户数
	 */
	@Modifying
	@Query(value="UPDATE User user SET user.age=:age WHERE user.userId=:userId")
	int updateAge(@Param ("age")int age, @Param ("userId")long userId);
	
	/**
	 * 更新用户手机
	 * @param phone
	 * @param userId
	 * @return 受影响用户数
	 */
	@Modifying
	@Query(value="UPDATE User user SET user.phone=:phone WHERE user.userId=:userId")
	int updatePhone(@Param ("phone")long phone, @Param ("userId")long userId);
	
	/**
	 * 更新用户博客数量
	 * @param userId
	 * @return 受影响用户数量
	 */
	@Modifying
	@Query(value="UPDATE User user SET user.blogNum=(user.blogNum+1) WHERE user.userId=:userId")
	int addBlogNum(@Param ("userId")long userId);
	
	@Modifying
	@Query(value="UPDATE User user SET user.type=0 WHERE user.userId=:userId")
	int closeAccount(@Param ("userId")long userId);
}
