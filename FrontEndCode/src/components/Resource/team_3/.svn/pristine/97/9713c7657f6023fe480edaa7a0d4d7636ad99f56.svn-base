package com.ITBlog.ITBlogSiteBackEnd.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITBlog.ITBlogSiteBackEnd.Entity.Blog;
import com.ITBlog.ITBlogSiteBackEnd.Entity.Comment;
import com.ITBlog.ITBlogSiteBackEnd.Response.CommentResponse;
import com.ITBlog.ITBlogSiteBackEnd.Response.FindCommentResponse;
import com.ITBlog.ITBlogSiteBackEnd.Service.BlogService;
import com.ITBlog.ITBlogSiteBackEnd.Service.CommentService;
import com.ITBlog.ITBlogSiteBackEnd.Response.GetCommentResponse;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	private BlogService blogService;
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService, BlogService blogService) {
		this.setCommentService(commentService);
		this.setBlogService(blogService);
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
	@PostMapping("/addcomment")
	public CommentResponse addComment(
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
	@GetMapping("/deletecomment")
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
	@PostMapping("/updatecomment")
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
	@GetMapping("/getcommentbycommentid")
	public GetCommentResponse getCommentByCommentId(@RequestParam long blogId, @RequestParam long commentIdId) {
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
	
	@GetMapping("/getcommentbyblog")
	public FindCommentResponse getCommentByBlogId(@RequestParam long blogId) {
		
		FindCommentResponse comments = new FindCommentResponse();
		List<Comment> comment = this.commentService.getComByBlogId(blogId);
		
		comments.setCode(0);
		comments.setComments(comment);

		return comments;
	}
	
	@GetMapping("/getcommentbyauthor")
	public FindCommentResponse getCommentByAuthorId(@RequestParam long authorId) {
		FindCommentResponse comments = new FindCommentResponse();
		List<Comment> comment = this.commentService.getComByAuthorId(authorId);
		
		comments.setCode(0);
		comments.setComments(comment);
		
		return comments;
	}

}
