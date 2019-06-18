package com.ITBlog.ITBlogSiteBackEnd.Response;

import java.util.List;

import com.ITBlog.ITBlogSiteBackEnd.Entity.Blog;

public class FindBlogResponse {
	private int code;
	private String otherInformation;
	private List<Blog> findBlog;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getOtherInformation() {
		return otherInformation;
	}
	
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	
	public void setFindBlog(List<Blog> findBlog) {
		this.findBlog = findBlog;
	}
	
	public List<Blog> getFindBlog(){
		return findBlog;
	}
}
