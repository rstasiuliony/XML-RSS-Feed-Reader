package com.hardfreedom.rss.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hardfreedom.rss.model.FeedEntity;
import com.hardfreedom.rss.model.ItemEntity;
import com.hardfreedom.rss.service.FeedService;
import com.hardfreedom.rss.service.ItemService;

@Controller
@RequestMapping(value = "/")
public class FeedController {
		
	@Autowired
	private FeedService feedService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "feeds/add", method = RequestMethod.GET)
	    public ModelAndView showForm() {
	        return new ModelAndView("/feeds/addFeed", "feed", new FeedEntity());
	    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/feeds/";
	}
	
	@RequestMapping(value = "feeds/add", method = RequestMethod.POST)
	public String saveFeed(@Valid @ModelAttribute("feed") FeedEntity feed, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "/error";
        }
		feed.setLastUpdate(LocalDateTime.now());
		feedService.createFeed(feed);
		return "redirect:/";
	}
	
	@RequestMapping(value = "feeds/reload/{feedId}", method = RequestMethod.GET)
	public String reloadFeed(@PathVariable int feedId, Model model) {
		FeedEntity feed = feedService.getOneFeed(feedId);
		itemService.renewItems(feed);
		return "redirect:/feeds/" + feedId;
	}
	
	@RequestMapping(value = "feeds/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listFeeds(Model model) {
		model.addAttribute("feedList", feedService.getFeeds());
		return "/feeds/feedList";
	}
	
	@RequestMapping(value = "feeds/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getOneFeed(@PathVariable int id, Model model) {
		FeedEntity feed = feedService.getOneFeed(id);
		model.addAttribute("feedInformation", feed);
		
		List<ItemEntity> items = itemService.getNewestItems(feed);
		int itemCount = itemService.getItemCount(feed);
		model.addAttribute("feedItems", items);	
		model.addAttribute("itemCount", itemCount);
		return "/feeds/feedInformation";
	}
}
