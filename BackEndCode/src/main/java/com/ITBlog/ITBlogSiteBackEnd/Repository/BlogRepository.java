package com.ITBlog.ITBlogSiteBackEnd.Repository;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ITBlog.ITBlogSiteBackEnd.Entity.*;

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
	 * 通过作者id查找博客
	 */
	@Query("select blog from Blog blog where blog.authorId=:authorId")
	List<Blog> findBlogByUserId(@Param ("authorId")long authorId);
	
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
	@Query(value="UPDATE Blog blog SET blog.readNum=blog.readNum+1WHERE blog.blogId=:blogId")
	int updateReadNum(@Param ("blogId") long blogId);
	
	/**
	 * 更新评论数
	 */
	@Modifying
	@Query(value="UPDATE Blog blog SET blog.commentsNum=blog.commentsNum+1 WHERE blog.blogId=:blogId")
	int updateCommentsNum(@Param ("blogId") long blogId);
	
	/**
	 * 按最新时间返回博客
	 */
	@Query("select blog from Blog blog order by blog.time desc")
	List<Blog> findBlogByTime();
}