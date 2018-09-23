package com.hardfreedom.rss.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardfreedom.rss.helper.FeedReader;
import com.hardfreedom.rss.model.FeedEntity;
import com.hardfreedom.rss.model.ItemEntity;
import com.hardfreedom.rss.repository.ItemRepository;

@Transactional
@Service
public class ItemService {
	
	@Autowired
	private ItemRepository ir;
	
	public void saveItem(ItemEntity item) {
		ir.save(item);
	}
	
	public int getItemCount(FeedEntity feed) {
		return ir.findAllByFeed(feed).size();
	}
	
	public List<ItemEntity> getNewestItems(FeedEntity feed) {
		return ir.findTop5ByFeedOrderByPublishedDesc(feed);
	}
	
	public void renewItems(FeedEntity feed) {
		ir.deleteAll(ir.findAllByFeed(feed));
		FeedReader reader = new FeedReader();
		ir.saveAll(reader.extractItems(feed));	
	}
}
