package com.zhukaige.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhukaige.common.CmsAssert;
import com.zhukaige.entity.Article;
import com.zhukaige.service.ArticleService;

@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		
		Article article = articleService.getById(id); 
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		request.setAttribute("article",article);
		return "article/detail";
		
	}
	
}
