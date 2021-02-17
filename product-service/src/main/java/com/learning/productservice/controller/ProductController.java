package com.learning.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learning.productservice.model.Product;
import com.learning.productservice.repository.ProductRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

	private final ProductRepository productRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		this.productRepository.save(product);

	};

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> listAllProduct() {
		return productRepository.findAll();

	};

}
