package com.hardfreedom.rss.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "feed_id")
	private FeedEntity feed;
	
	@Column(length = 255)
	private String title;

	@Column(length = 255)
	private String link;
	
	@Lob
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(columnDefinition="datetime")
	private LocalDateTime published;

	public FeedEntity getFeed() {
		return feed;
	}

	public void setFeed(FeedEntity feed) {
		this.feed = feed;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPublished() {
		return published;
	}

	public void setPublished(LocalDateTime published) {
		this.published = published;
	}

	public int getId() {
		return id;
	}
}
