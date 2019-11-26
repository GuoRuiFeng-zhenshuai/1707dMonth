package com.guoruifeng.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.guoruifeng.entity.Link;

/**
 * 
 * @author guoruifeng
 *
 */
public interface LinkService {

	int add(Link link);
	PageInfo list(int page);
	int delete(int id);
	Link get(int id);
	int update( Link link);

}
