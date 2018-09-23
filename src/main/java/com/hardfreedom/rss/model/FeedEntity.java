package com.hardfreedom.rss.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "feeds")
public class FeedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@URL
	@Column(length = 255)
	private String url;
	
	@Column(length = 45)
	private String title;
	
	@Column(name = "last_update", columnDefinition="datetime")
	private LocalDateTime lastUpdate;
	
	@Column(name = "feed_name", length = 255)
	private String feedName;
	
	@OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
	private List<ItemEntity> items = new ArrayList<>();
	
	public FeedEntity(){
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}
	
}
