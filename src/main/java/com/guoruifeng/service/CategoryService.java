package com.guoruifeng.service;

import java.util.List;

import com.guoruifeng.entity.Category;

public interface CategoryService {

	/**
	 * 获取分类
	 * @param chnId  频道id
	 * @return
	 */
	List<Category> listByChannelId(int chnId);

}
