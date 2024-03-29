package com.ITBlog.Blog.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ITBlog.Blog.Entity.Blog;
import com.ITBlog.Blog.Entity.Comment;
import com.ITBlog.Blog.Repository.CommentRepository;
import com.ITBlog.Blog.Service.BlogService;


@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private BlogService blogService;
	
	
	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.setCommentRepository(commentRepository);
	}
	
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public CommentRepository getCommentRepository() {
		return commentRepository;
		//this.commentRepository.deleteById(id);
	}

	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	
	/**
	 * 保存评论信息
	
	 * @return code //0-正确 1-存储错误
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveComment(long blogId,long authorId, Date time, String content) {
		
		//首先要判断博客id值不为空
		Blog blog = this.blogService.findBlogById(blogId);
		if(blog == null) {
			return 1;
		}
		else {
		// Type是1表示普通用户
		Comment comment = new Comment(blogId,authorId, time, content);
		
		Comment commentTemp = this.commentRepository.saveAndFlush(comment);
		if(commentTemp == null) {
			return 1;
		}else if(commentTemp.getBlogId() == 0){
			return 1;
		}else {
			return 0;
		}
		}
	}
	
	//更新评论内容
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateContent(long commentId, String content) {
		
		int effectNum = this.commentRepository.updateContent(content, commentId);
		if(effectNum == 0) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	
	//根据评论id找评论信息
	@Transactional(propagation = Propagation.REQUIRED)
	public Comment getCommentById(long commentId) {
		
		Comment comment = (Comment) this.commentRepository.findByCommentId(commentId);
		return comment;
	}
	
	
	
	
	//分别根据博客id和评论id完成评论查询
	@Transactional(propagation = Propagation.REQUIRED)
	
	public List<Comment> getComByBlogId(long blogId) {
		List<Comment> comment = this.commentRepository.getComByBlogId(blogId);
		return comment;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	
	public List<Comment> getComByAuthorId(long authorId) {
		List<Comment> comment = this.commentRepository.getComByAuthorId(authorId);
		return comment;
	}
	
	/*
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int AddComments(long blogId, long authorId, Date time, String content) {
		
		Comment comment = new Comment(blogId, authorId, time, content);
		Comment commentTemp = this.commentRepository.saveAndFlush(comment);
		if(commentTemp == null) {
			return 1;
		}else {
			return 0;
		}
	}*/
	
	
	/**
	 * 根据博客ID和作者id删除评论
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteComment(long commentId) {
		
		this.commentRepository.deleteById(commentId);
		return 0;
	}

}
