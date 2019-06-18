package com.ITBlog.Blog.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ITBlog.Blog.Repository.BlogRepository;
import com.ITBlog.Blog.Repository.CommentRepository;
import com.ITBlog.Blog.Entity.*;

@Service
public class BlogService{
	
	private CommentRepository commentRepository;
	private BlogRepository blogRepository;
	
	@Autowired
	public BlogService(BlogRepository blogRepository) {
		this.setBlogRepository(blogRepository);
	}

	public BlogRepository getBlogRepository() {
		return blogRepository;
	}

	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	/**
	 * 更新博客标题
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateTitle(long blogId, String title) {
		int effectedNum = this.blogRepository.updateTitle(title, blogId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 更新博客内容
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateContext(long blogId, String context) {
		int effectedNum = this.blogRepository.updateContext(context, blogId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 更新发布时间
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateTime(long blogId, Date time) {
		int effectedNum = this.blogRepository.updateTime(time, blogId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 更新阅读数
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateReadNum(long blogId, int readNum) {
		int effectedNum = this.blogRepository.updateReadNum(readNum, blogId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 更新评论数
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateCommentsNum(long blogId, int commentsNum) {
		int effectedNum = this.blogRepository.updateCommentsNum(commentsNum, blogId);
		if(effectedNum == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 根据博客ID返回博客 不保证返回非空
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Blog findBlogById(long blogId) {
		Blog blog = this.blogRepository.findBlogById(blogId);
		return blog;
	}
	
	/**
	 * 根据博客标题返回博客 不保证返回非空
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Blog> findBlogLikeTitle(String title) {
		List<Blog> blog = this.blogRepository.findBlogLikeTitle(title);
		return blog;
	}
	
	/**
	 * 新增博客
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int addBlog(String title,String context, long authorId,
			Date time) {
		Blog blog = new Blog(title, context, authorId, time);
		Blog blogTemp = this.blogRepository.saveAndFlush(blog);
		
		if(blogTemp == null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/**
	 * 根据博客ID删除博客
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteBlog(long blogId) {
		this.blogRepository.deleteById(blogId);
		return 0;
	}
}