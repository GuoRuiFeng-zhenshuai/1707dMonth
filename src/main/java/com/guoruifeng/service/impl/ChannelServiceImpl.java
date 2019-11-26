package com.guoruifeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guoruifeng.dao.ChannelMapper;
import com.guoruifeng.entity.Channel;
import com.guoruifeng.service.ChannelService;

/**
 * 
 * @author guoruifeng
 *
 */

@Service
public class ChannelServiceImpl  implements ChannelService{
	
	@Autowired
	ChannelMapper channelMapper;

	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return channelMapper.list();
	}

}
