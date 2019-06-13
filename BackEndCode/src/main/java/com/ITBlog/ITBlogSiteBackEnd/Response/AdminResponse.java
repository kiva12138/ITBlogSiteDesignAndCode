package com.ITBlog.ITBlogSiteBackEnd.Response;

/**
 * 管理员的返回类
 * 用于返回用户增加、删除、关闭、更新信息的数据
 * @author 夜流歌
 *
 */
public class AdminResponse {
	private int code;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}	
}
