package com.ITBlog.ITBlogSiteBackEnd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ITBlog.ITBlogSiteBackEnd.Entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
	/**
	 * 通过博客Id查找评论
	 */
	Comment findByCommentId(long commentId);
	
	//通过用户Id查找评论
	
	//Comment findByAuthorid(long authorId);
	
	
	@Query(value="SELECT comment from Comment comment WHERE comment.blogId=:blogId")
	List<Comment> getComByBlogId(@Param ("blogId") long blogId);


	@Query(value="SELECT comment from Comment comment WHERE comment.authorId=:authorId")
	List<Comment>  getComByAuthorId(@Param ("authorId") long authorId);
	
	
	/**
	 * 更新评论内容
	 */
	@Modifying
	@Query(value="UPDATE Comment comment SET comment.content=:content WHERE comment.commentId=:commentId")
	int updateContent(@Param ("content")String content, @Param ("commentId") long commentId);
	
	/**
	 * 删除评论内容，需要同时输入评论
	 */
	
	
}
