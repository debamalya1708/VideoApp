package com.ds.videoapp.controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ds.videoapp.helper.FileUploadHelper;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Servlet;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController

@RequestMapping
public class fileController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping(value="/categoryImage/upload")
	public ResponseEntity<String> uploadCategoryFile(@RequestParam("image") MultipartFile file){
		
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Server error");
			}
			
			boolean f=fileUploadHelper.uploadFile(file);
			if(f) {
//				return ResponseEntity.ok("File is succesfully updated");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try again");
	}
	
		@PostMapping(value="/thumbnailImage/upload")
		public ResponseEntity<String> uploadThumbnailFile(@RequestParam("thumbnail_img") MultipartFile file){
			
			try {
				if(file.isEmpty()) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Server error");
				}
				
				boolean f=fileUploadHelper.uploadFile(file);
				if(f) {
//					return ResponseEntity.ok("File is succesfully updated");
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try again");
		}
		
		@PostMapping(value="/video/upload")
		public ResponseEntity<String> uploadMovie(@RequestParam("video_file") MultipartFile file){
			
			try {
				if(file.isEmpty()) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Server error");
				}
				
				boolean f=fileUploadHelper.uploadMovie(file);
				if(f) {
//					return ResponseEntity.ok("File is succesfully updated");
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/video/").path(file.getOriginalFilename()).toUriString());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try again");
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
//	private final Logger logger = LoggerFactory.getLogger(fileController.class);
//	private static String UPLOADED_FOLDER = "C:\\Users\\debam\\Documents\\SpringRestDataMySQL\\SpringRestDataMySQL\\src\\main\\resources\\template\\static\\";
//	
//	
//		@PostMapping(value = "/upload")
//	   public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
//			System.out.println("getting file");
//
//	        logger.debug("Single file upload!");
//
//	        if (uploadfile.isEmpty()) {
//	            return new ResponseEntity("please select a file!", HttpStatus.OK);
//	        }
//
//	        try {
//
//	            saveUploadedFiles(Arrays.asList(uploadfile));
//
//	        } catch (IOException e) {
//	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	        }
//
//	        return new ResponseEntity("Successfully uploaded - "+uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
//
//	    }
//	  
//	    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
//
//	        for (MultipartFile file : files) {
//
//	            if (file.isEmpty()) {
//	                continue; //next pls
//	            }
//
//	            byte[] bytes = file.getBytes();
//	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//	            Files.write(path, bytes);
//	            System.out.println(path);
//	        }
//
//	    } 	
}
