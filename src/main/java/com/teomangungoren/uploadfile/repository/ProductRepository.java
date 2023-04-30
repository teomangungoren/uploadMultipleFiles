package com.teomangungoren.uploadfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teomangungoren.uploadfile.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
