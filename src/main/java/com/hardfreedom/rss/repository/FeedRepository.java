package com.hardfreedom.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardfreedom.rss.model.FeedEntity;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity,Integer> {

}
