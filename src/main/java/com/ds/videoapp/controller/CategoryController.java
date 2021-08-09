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

import com.ds.videoapp.model.Category;
import com.ds.videoapp.model.Language;
import com.ds.videoapp.repository.CategoryDAOImpl;

@RestController
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	@PostMapping(value="/newCategory",consumes= MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void save(@RequestBody Category category) {
		System.out.println("getting the category"+category);
		categoryDAOImpl.save(category);
	}
	
	@GetMapping("/allCategories")
	public List<Category> get(){
		return categoryDAOImpl.findAll();
	}
	
	@PutMapping("/updateCategory")
	public Category updateCategory(@RequestBody Category category) {
		return categoryDAOImpl.save(category);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLanguage(@PathVariable long id) {
//		categoryDAOImpl.deleteById(id);
		categoryDAOImpl.delete(id);
	}

}
