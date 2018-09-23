package com.hardfreedom.rss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardfreedom.rss.model.FeedEntity;
import com.hardfreedom.rss.model.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

	public List<ItemEntity>findTop5ByFeedOrderByPublishedDesc(FeedEntity feed);
	public List<ItemEntity>findAllByFeed(FeedEntity feed);
	
}
