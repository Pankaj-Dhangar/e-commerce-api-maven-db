package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.Product;
import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
	@Autowired
	ProductResponse response;
	@Autowired
	Product products;
	public ProductResponse addProduct(ProductRequest request) {
		String query = "Insert into products (id, price, product_name, quantity) " + "Values ('"
				+ request.getId() + "', '" + request.getPrice() + "', '" + request.getProduct_Name()
				+ "', '" + request.getQuantity() + "');";

		try {
			DBUtils.executeQuery(query);
			
			products.setId(request.getId());
			products.setProduct_Name(request.getProduct_Name());
			products.setPrice(request.getPrice());
			products.setQuantity(request.getQuantity());

			response.setResponseCode("0000");
			response.setResponseMessage("Product added");

		} catch (SQLException e) {
			e.printStackTrace();
			response.setResponseCode("911");
			response.setResponseMessage("add product fail");
		}
		return response;
	}
	
	public ProductResponse getAllProduct() {

		List<Product> productList = new ArrayList<>();
		String query = "select * from products";

		try {
			ResultSet result = DBUtils.executeSelectQuery(query);
			while (result.next()) {
				Product product =new Product();
				product.setId(result.getString(1));
				product.setPrice(result.getString(2));
				product.setProduct_Name(result.getString(3));
				product.setQuantity(result.getString(4));
				productList.add(product);
			}
				response.setResponseCode("0000");
				response.setResponseMessage("Product added");
				response.setProducts(productList);
			
		} catch (SQLException e) {
			response.setResponseCode("911");
			response.setResponseMessage("Displaying Product fail");
			e.printStackTrace();
		}
		return response;
}
}