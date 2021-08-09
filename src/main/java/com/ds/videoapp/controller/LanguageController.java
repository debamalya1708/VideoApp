package com.ds.videoapp.controller;

import java.util.List;

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

import com.ds.videoapp.model.Language;
import com.ds.videoapp.repository.LanguageDAOImpl;

@RestController
@RequestMapping(value="/language")
public class LanguageController {

	@Autowired
	LanguageDAOImpl languageDAOImpl;
	
	@PostMapping(value="/newLanguage",consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody Language language) {
		System.out.println("getting the language"+language);
		languageDAOImpl.save(language);
	}
	
	@GetMapping("/allLanguages")
	public List<Language> get(){
		return languageDAOImpl.findAll();
	}
	
	@PutMapping("/updateLanguage")
	public Language updateLanguage(@RequestBody Language language) {
		return languageDAOImpl.save(language);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLanguage(@PathVariable long id) {
//		languageDAOImpl.deleteById(id);
		languageDAOImpl.delete(id);
	}
	
	
	
}
