package com.ds.videoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.videoapp.model.Category;

@Repository
public interface CategoryDAOImpl extends JpaRepository<Category, Long>{
	
}
