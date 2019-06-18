package com.ITBlog.Blog.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITBlog.Blog.Service.BlogService;
import com.ITBlog.Blog.Entity.Blog;
import com.ITBlog.Blog.Response.BlogResponse;
import com.ITBlog.Blog.Repository.BlogRepository;

@RestController
@RequestMapping("/blog")
public class BlogController {

	private BlogService blogService;
	
	@Autowired
	public BlogController(BlogService blogService) {
		this.setUserService(blogService);
	}

	public BlogService getUserService() {
		return blogService;
	}

	public void setUserService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	/**
	 * 
	 * 添加博客
	 */
	@PostMapping("/addblog")
	public BlogResponse addBlog(@RequestParam String title,
								@RequestParam String context, 
								@RequestParam long authorId, 
								@RequestParam Date time) {
		BlogResponse blogResponse = new BlogResponse();
		
		if(title == null || context == null) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Empty Value!");
			return blogResponse;
		}
	
		
		int code = this.blogService.addBlog(title,context,authorId,time);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
		return blogResponse;
	}
	
	/**
	 * 
	 * 删除博客
	 */
	@GetMapping("/deleteblog")
	public BlogResponse deleteBlog(@RequestParam long blogId) {
		BlogResponse blogResponse = new BlogResponse();
		
		// Judge Empty Values
		if(blogId == 0) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Empty Value!");
			return blogResponse;
		}
		
		
		int code = this.blogService.deleteBlog(blogId);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
				
		return blogResponse;
	}
	
	/**
	 * 更新博客标题
	 */
	@PostMapping("/updatetitle")
	public BlogResponse updateTitle(@RequestParam long blogId, @RequestParam String title) {
		BlogResponse blogResponse = new BlogResponse();
		
		// Judge Empty Values
		if(title == null) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Empty Value!");
			return blogResponse;
		}
		
		// Save To Service
		int code = this.blogService.updateTitle(blogId, title);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
				
		return blogResponse;
	}
	
	/**
	 * 更新博客内容
	 */
	@PostMapping("/updatecontext")
	public BlogResponse updateContext(@RequestParam long blogId, @RequestParam String context) {
		BlogResponse blogResponse = new BlogResponse();
		
		// Judge Empty Values
		if(context == null) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Empty Value!");
			return blogResponse;
		}
		
		// Save To Service
		int code = this.blogService.updateContext(blogId, context);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
				
		return blogResponse;
	}
	
	/**
	 * 更新发布时间
	 */
	@PostMapping("/updatetime")
	public BlogResponse updateTime(@RequestParam long blogId, @RequestParam Date time) {
		BlogResponse blogResponse = new BlogResponse();
		
		// Judge Empty Values
		if(time == null) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Empty Value!");
			return blogResponse;
		}
		
		// Save To Service
		int code = this.blogService.updateTime(blogId, time);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
				
		return blogResponse;
	}
	
	/**
	 * 更新阅读数
	 */
	@PostMapping("/updatereadnum")
	public BlogResponse updateReadNum(@RequestParam long blogId, @RequestParam int readNum) {
		BlogResponse blogResponse = new BlogResponse();
		
		// Judge Empty Values
		if(readNum < 0) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Error Value!");
			return blogResponse;
		}
		
		// Save To Service
		int code = this.blogService.updateReadNum(blogId, readNum);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
				
		return blogResponse;
	}
	
	/**
	 * 更新评论数
	 */
	@PostMapping("/updatecommentsnum")
	public BlogResponse updateCommentsNum(@RequestParam long blogId, @RequestParam int commentNum) {
		BlogResponse blogResponse = new BlogResponse();
		
		// Judge Empty Values
		if(commentNum < 0) {
			blogResponse.setCode(1);
			blogResponse.setOtherInformation("Error Value!");
			return blogResponse;
		}
		
		// Save To Service
		int code = this.blogService.updateCommentsNum(blogId, commentNum);
		if(code == 0) {
			blogResponse.setCode(0);
		}else {
			blogResponse.setCode(2);
			blogResponse.setOtherInformation("Service Error!");
		}
				
		return blogResponse;
	}
	
	/**
	 * 根据id查找博客
	 */
	@GetMapping("/find")
	public Blog Find(@RequestParam long blogId) {
		Blog blog = this.blogService.findBlogById(blogId);
		return blog;
	}
	
	/**
	 * 根据标题查找博客
	 */
	@GetMapping("/findlikebytitle")
	public List<Blog> FindLikeByTitle(@RequestParam String title) {
		List<Blog> blog = this.blogService.findBlogLikeTitle(title);
		return blog;
	}
}
