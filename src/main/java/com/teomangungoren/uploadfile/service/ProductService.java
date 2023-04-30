package com.teomangungoren.uploadfile.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.teomangungoren.uploadfile.entity.Product;

public interface ProductService {

	Product saveAttachment(MultipartFile file) throws Exception;
	void saveFiles(MultipartFile[] files) throws Exception;
	List<Product> getAllFiles();
	
}
