package com.ds.videoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.videoapp.model.Video;

@Repository
public interface VideoDAOImpl extends JpaRepository<Video, Long> {

	public List<Video> findByName(String name);
	public List<Video> findByCategory(String category);
	public List<Video> findByLanguage(String language);
}
