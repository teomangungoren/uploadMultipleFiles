package com.teomangungoren.uploadfile.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.teomangungoren.uploadfile.entity.Product;
import com.teomangungoren.uploadfile.repository.ProductRepository;
import com.teomangungoren.uploadfile.service.ProductService;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{

	
	private ProductRepository productRepository;
	
	
	public Product saveAttachment(MultipartFile file) throws Exception {
		
		String fileName=org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence " + fileName);
            }
			if(file.getBytes().length>(1024*1024)) {
				throw new Exception("File size exceeds maximum limits");
			}
			Product attachment = new Product(fileName, file.getContentType(), file.getBytes());
			return productRepository.save(attachment);
		}catch(MaxUploadSizeExceededException ex) {
			throw new MaxUploadSizeExceededException(file.getSize());
		}catch(Exception ex) {
			throw new Exception("Couldnt save file "+fileName);
		}
			}

	public void saveFiles(MultipartFile[] files) throws Exception {
		
		Arrays.asList(files).forEach(file->{
			try {
				saveAttachment(file);
				}catch (Exception e) {
				   throw new RuntimeErrorException(null);
				}
		});
		
}

	@Override
	public List<Product> getAllFiles() {
	     
		return productRepository.findAll();
	}

}
