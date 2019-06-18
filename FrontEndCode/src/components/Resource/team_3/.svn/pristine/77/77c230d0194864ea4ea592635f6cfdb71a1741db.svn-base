package com.ITBlog.Blog.Controller;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ITBlog.Blog.Entity.Blog;
import com.ITBlog.Blog.Entity.Comment;
import com.ITBlog.Blog.Response.CommentResponse;
import com.ITBlog.Blog.Service.BlogService;
import com.ITBlog.Blog.Service.CommentService;
import com.ITBlog.Blog.Response.GetCommentResponse;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	private BlogService blogService;
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.setCommentService(commentService);
	}
	
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public CommentService getCommentService() {
		return commentService;
	}


	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

//添加评论
	@RequestMapping("/addcomment")
	public CommentResponse AddComment(
						@RequestParam long blogId,
						@RequestParam long authorId,
						@RequestParam String content,
						@RequestParam Date time) {
		
		//首先判断blog不为空
		Blog blog = this.blogService.findBlogById(blogId);
		CommentResponse commentResponse = new CommentResponse();
		if(blog == null) {
			commentResponse.setCode(1);
		}
		else {
		
		 if(authorId == 0) {
			commentResponse.setCode(1);
		} else if(content == null || content.equals("")) {
			commentResponse.setCode(2);
		} else {
			
			content = content.trim();
			//Date date = new Date();
		   // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			int result = this.commentService.saveComment(blogId,authorId, time, content);
			if(result == 0) {
				commentResponse.setCode(0);
			}else {
				commentResponse.setCode(3);
			}
		}
		
		}
		return commentResponse;
	}
	
	
	/**
	 * 
	 * 删除评论
	 */
	@RequestMapping("/deletecomment")
	public CommentResponse deleteComment(@RequestParam long commentId) {
		CommentResponse commentResponse = new CommentResponse();
		
		// Judge Empty Values
		if(commentId == 0) {
			commentResponse.setCode(1);
			commentResponse.setNeedInformation("Empty Value!");
			return commentResponse;
		}
		
		
		int code = this.commentService.deleteComment(commentId);
		if(code == 0) {
			commentResponse.setCode(0);
		}else {
			commentResponse.setCode(2);
			commentResponse.setNeedInformation("Service Error!");
		}
				
		return commentResponse;
	}
	
	//更新评论内容
	@RequestMapping("/updateComment")
	public CommentResponse updateComment(@RequestParam long commentId,
											@RequestParam long blogId,
											@RequestParam String content) {
		CommentResponse commentResponse = new CommentResponse();
		Blog blog = this.blogService.findBlogById(blogId);
		
		if(blog == null) {
			commentResponse.setCode(1);
			commentResponse.setNeedInformation("Empty Blog!");
		}
		if(content != null) {  //如果内容不为空
			content = content.trim();
		}
		else {
			commentResponse.setCode(1);
			commentResponse.setNeedInformation("Empty Value!");
			return commentResponse;
		}
		int code = this.commentService.updateContent(commentId, content);
		if(code == 0) {
			commentResponse.setCode(0);
		}
		else {
			commentResponse.setCode(2);
			commentResponse.setNeedInformation("Service Error!");
		}
		return commentResponse;
	}
	
	//根据评论ID返回评论数据
	@RequestMapping("/gecommentbycomid")
	public GetCommentResponse getCommentByBlogId(@RequestParam long blogId,@RequestParam long commentIdId) {
		GetCommentResponse getCommentResponse = new GetCommentResponse();
		Blog blog = this.blogService.findBlogById(blogId);
		
		if(blog == null) {
			getCommentResponse.setCode(1);
			getCommentResponse.setNeedInformation("Empty Blog!");
			return getCommentResponse;
		}
		if(commentIdId == 0) {
			getCommentResponse.setCode(1);
			getCommentResponse.setNeedInformation("Empty Value!");
			return getCommentResponse;
		}
		
		Comment comment = this.commentService.getCommentById(commentIdId);
		if(comment == null) {
			getCommentResponse.setCode(2);
			getCommentResponse.setNeedInformation("Service Error!");
			return getCommentResponse;
		}
		
		getCommentResponse.setCode(0);
		getCommentResponse.setCommentId(comment.getCommentId());
		getCommentResponse.setAuthorId(comment.getAuthorId());
		getCommentResponse.setContent(comment.getContent());
		getCommentResponse.setBlogId(comment.getBlogId());
		getCommentResponse.setTime(comment.getTime());
		return getCommentResponse;
	}	
	
	

	
	
	//根据博客id和作者id返回数据
	
	@RequestMapping("/findcommentbyblog")
	public List<Comment> FindComByBlogId(@RequestParam long blogId) {
		List<Comment> comment = this.commentService.getComByBlogId(blogId);
		return comment;
	}
	
	@RequestMapping("/findcommentbyauthor")
	public List<Comment> FindComBAuthorId(@RequestParam long authorId) {
		List<Comment> comment = this.commentService.getComByBlogId(authorId);
		return comment;
	}

}
