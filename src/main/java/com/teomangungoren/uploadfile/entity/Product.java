package com.teomangungoren.uploadfile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(generator = "uuid")
	private Long id;
	private String fileName;
	private String fileType;
	@Lob
	private byte[] data;
	
	public Product(String fileName,String fileType,byte[] data) {
		this.fileName=fileName;
		this.fileType=fileType;
		this.data=data;
	}
	
	
}
