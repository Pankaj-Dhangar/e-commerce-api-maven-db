package org.dnyanyog.controller;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping (path ="/add",produces = {"application/json","application/xml"} , consumes={"application/json","application/xml"})
	public ProductResponse Addproduct(@RequestBody ProductRequest product) {
		return productService.addProduct(product);
	}
	@GetMapping (path ="/display",produces = {"application/json","application/xml"} ,consumes ={"application/json","application/xml"})
	public ProductResponse getProduct() {
		return productService.getAllProduct();
	}

}
