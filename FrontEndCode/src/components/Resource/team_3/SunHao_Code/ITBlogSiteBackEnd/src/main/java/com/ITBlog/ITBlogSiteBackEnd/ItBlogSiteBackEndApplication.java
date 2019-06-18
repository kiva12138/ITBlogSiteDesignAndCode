package com.ITBlog.ITBlogSiteBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ItBlogSiteBackEndApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(ItBlogSiteBackEndApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(ItBlogSiteBackEndApplication.class, args);
	}

}
