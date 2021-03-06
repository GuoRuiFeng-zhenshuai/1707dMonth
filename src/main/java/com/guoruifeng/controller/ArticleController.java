package com.guoruifeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.guoruifeng.common.CmsAssert;
import com.guoruifeng.common.MsgResult;
import com.guoruifeng.entity.Article;
import com.guoruifeng.entity.Category;
import com.guoruifeng.entity.Comment;
import com.guoruifeng.entity.Image;
import com.guoruifeng.entity.TypeEnum;
import com.guoruifeng.service.ArticleService;
import com.guoruifeng.service.CategoryService;

@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CategoryService catService; 
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		
		Article article = articleService.getById(id); 
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		
		
		request.setAttribute("article",article);
		if(article.getArticleType()==TypeEnum.HTML)
			return "article/detail";
		else {
			Gson gson = new Gson();
			// 文章内容转换成集合对象
			List<Image> imgs = gson.fromJson(article.getContent(), List.class);
			article.setImgList(imgs);
			System.out.println(" article is "  + article);
			return "article/detailimg";
		}
		
		
	}
	
	//getCategoryByChannel",{chnId:channelId},"
	//		+ "
	@RequestMapping("getCategoryByChannel")
	@ResponseBody
	public MsgResult getCategoryByChannel(int chnId) {
		//List<Category> categories =  
		List<Category> categories = catService.listByChannelId(chnId);
		return new MsgResult(1, "",  categories);
		
	}
	
	@RequestMapping("commentlist")
	//@ResponseBody
	public String commentlist(HttpServletRequest request, int id,
			@RequestParam(defaultValue="1") int page) {
		
		PageInfo<Comment> pageComment =  articleService.commentlist(id,page);
		request.setAttribute("pageComment", pageComment);
		return "article/comments";
		//return new MsgResult(1,"获取成功",pageComment);
		
	}
	
}
