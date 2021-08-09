package com.ds.videoapp.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//		public final String UPLOAD_DIR = "C:\\Users\\debam\\Documents\\SpringRestDataMySQL\\SpringRestDataMySQL\\src\\main\\resources\\template\\static\\";
		public final String UPLOAD_DIR_IMG = new ClassPathResource("static\\image").getFile().getAbsolutePath();
		public final String UPLOAD_DIR_VDO = new ClassPathResource("static\\video").getFile().getAbsolutePath();

		public FileUploadHelper() throws IOException{
			
		}

		public boolean uploadFile(MultipartFile multipartFile) {
			boolean f = false;
			
			try {
				Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR_IMG+"\\"+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				f=true;
				System.out.println(UPLOAD_DIR_IMG+"\\"+multipartFile.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return f;
		}
		
		public boolean uploadMovie(MultipartFile multipartFile) {
			boolean f = false;
			
			try {
				Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR_VDO+"\\"+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				f=true;
				System.out.println(UPLOAD_DIR_VDO+"\\"+multipartFile.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
		}
}
