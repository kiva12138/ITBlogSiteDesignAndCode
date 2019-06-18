package com.ITBlog.Blog.Repository;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ITBlog.Blog.Entity.*;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	
	/**
	 * 通过博客Id查找博客
	 */
	@Query(value="select blog from Blog blog where blog.blogId=:blogId")
	Blog findBlogById(@Param ("blogId") long blogId);
	
	
	/**
	 * 通过博客标题查找博客
	 */
	@Query("select blog from Blog blog where blog.title like %:title%")
	List<Blog> findBlogLikeTitle(@Param ("title")String title);
	
	/**
	 * 更新博客标题
	 */
	@Modifying
	@Query(value="UPDATE Blog blog SET blog.title=:title WHERE blog.blogId=:blogId")
	int updateTitle(@Param ("title")String title, @Param ("blogId") long blogId);
	
	/**
	 * 更新博客内容
	 */
	@Modifying
	@Query(value="UPDATE Blog blog SET blog.context=:context WHERE blog.blogId=:blogId")
	int updateContext(@Param ("context")String context, @Param ("blogId") long blogId);
	
	/**
	 * 更新发布时间
	 */
	@Modifying
	@Query(value="UPDATE Blog blog SET blog.time=:time WHERE blog.blogId=:blogId")
	int updateTime(@Param ("time")Date time, @Param ("blogId") long blogId);
	
	/**
	 * 更新阅读数
	 */
	@Modifying
	@Query(value="UPDATE Blog blog SET blog.readNum=:readNum WHERE blog.blogId=:blogId")
	int updateReadNum(@Param ("readNum")int readNum, @Param ("blogId") long blogId);
	
	/**
	 * 更新评论数
	 */
	@Modifying
	@Query(value="UPDATE Blog blog SET blog.commentsNum=:commentsNum WHERE blog.blogId=:blogId")
	int updateCommentsNum(@Param ("commentsNum")int commentsNum, @Param ("blogId") long blogId);
	

}