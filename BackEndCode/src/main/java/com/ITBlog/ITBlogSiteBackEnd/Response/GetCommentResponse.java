package com.ITBlog.ITBlogSiteBackEnd.Response;

import java.sql.Date;

public class GetCommentResponse {
	private long commentId;
	private long blogId;
	private Date time;
	private long authorId;
	private String content;
	private int code;
	private String needInformation;
	
	
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNeedInformation() {
		return needInformation;
	}
	public void setNeedInformation(String needInformation) {
		this.needInformation = needInformation;
	}
	
	
}

