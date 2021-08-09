package com.ds.videoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.videoapp.model.Language;

@Repository
public interface LanguageDAOImpl extends JpaRepository<Language, Long>{

}
