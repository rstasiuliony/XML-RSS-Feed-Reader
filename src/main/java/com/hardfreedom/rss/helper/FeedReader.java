package com.hardfreedom.rss.helper;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.hardfreedom.rss.model.FeedEntity;
import com.hardfreedom.rss.model.ItemEntity;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class FeedReader {
	
	private List<ItemEntity> feedItems;
	private SyndFeedInput input;
	private SyndFeed feed;
	
	public FeedReader() {
		feedItems = new LinkedList<>();
		input = new SyndFeedInput();
	}
	
	public List<ItemEntity> extractItems(FeedEntity fe) {
		try {
			URL url = new URL(fe.getUrl());
			feed = input.build(new XmlReader(url));
			for (SyndEntry i : feed.getEntries()) {
				ItemEntity ie = new ItemEntity();
				ie.setFeed(fe);
				ie.setTitle(i.getTitle());
				ie.setDescription(i.getDescription().getValue());
				ie.setLink(i.getLink());
				//TODO: FIX. SyndEntry doesn't understand date in LT or other languages 
				// that can be found in XML. Temporary solution provided below.
				if(i.getPublishedDate() == null) {
					ie.setPublished(LocalDateTime.now());
				} else {
					ie.setPublished(convertToLocalDateTime(i.getPublishedDate()));
				}
				feedItems.add(ie);
			}
			return feedItems;
		}
		
		catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("RSS ERROR: " + ex.getMessage());
        }
		return null;
	}
	
	private LocalDateTime convertToLocalDateTime(Date publishedDate) {
		return publishedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}	
}
