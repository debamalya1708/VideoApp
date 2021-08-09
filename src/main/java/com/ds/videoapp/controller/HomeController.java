package com.ds.videoapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ds.videoapp.model.Video;
import com.ds.videoapp.repository.VideoDAOImpl;


@RestController
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired
	VideoDAOImpl videoDAOImpl;
	
	@PostMapping(value="/newVideo",consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody Video video) {
		System.out.println("getting the file"+video);
//		long id = System.currentTimeMillis();
//		Random randomGenerator = new Random();
//		System.out.println("Time = "+System.currentTimeMillis());
//		int randomInt = randomGenerator.nextInt(Integer.MAX_VALUE);
//		String id = Integer.toString(randomInt)+Long.toString(System.currentTimeMillis());
//		System.out.println("id= "+id);
//		
//		video.setId(randomInt);
		videoDAOImpl.save(video);
	}
	
	@GetMapping("/allVideos")
	public List<Video> get(){
		return videoDAOImpl.findAll();
	}
	
	@GetMapping("/video/{id}")
	public Video get(@PathVariable long id) {
		Video video = videoDAOImpl.getOne(id);
		return video;
//		Optional<Video> video =videoDAOImpl.findOne(id);
//		if(video.isPresent()) {
//			return video.get();
//		}else {
//			throw new RuntimeException("video not found for the id "+id);
//		}
	}
	
	@GetMapping("/{name}")
	public List<Video> getVideo(@PathVariable String name){
		return videoDAOImpl.findByName(name);
	}
	
	@GetMapping("/category/{category}")
	public List<Video> getCategoryVideo(@PathVariable String category){
		return videoDAOImpl.findByCategory(category);

	}
	
	@GetMapping("/language/{language}")
	public List<Video> getLanguageVideo(@PathVariable String language){
		return videoDAOImpl.findByLanguage(language);
	}
	
	@PutMapping("/updateVideo")
	public Video update(@RequestBody Video video) {
		return videoDAOImpl.save(video);
	}
	
	@DeleteMapping("/video/delete/{id}")
	public void deleteLanguage(@PathVariable long id) {
//		videoDAOImpl.deleteById(id);
		videoDAOImpl.delete(id);
	}
	
	
	
	
}
