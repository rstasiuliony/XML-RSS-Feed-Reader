package com.hardfreedom.rss.service;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardfreedom.rss.helper.FeedReader;
import com.hardfreedom.rss.model.FeedEntity;
import com.hardfreedom.rss.model.ItemEntity;
import com.hardfreedom.rss.repository.FeedRepository;
import com.hardfreedom.rss.repository.ItemRepository;

@Transactional
@Service
public class FeedService {
	
	@Autowired
	private FeedRepository fr;
	
	@Autowired
	private ItemRepository ir;
	
	public void createFeed(FeedEntity feed) {
		List<ItemEntity> itemInfo = new LinkedList<>();
		FeedReader reader = new FeedReader();
		itemInfo = reader.extractItems(feed);
		
		fr.save(feed);
		ir.saveAll(itemInfo);
	}
	
	public List<FeedEntity> getFeeds() {
		return fr.findAll();
	}
	
	public FeedEntity getOneFeed(int id) {
		return fr.getOne(id);
	}
}
