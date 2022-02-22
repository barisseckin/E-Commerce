package com.eCommerceProject;

import com.eCommerceProject.api.controller.CategoryController;
import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.model.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialProduct(ProductService productService, CategoryService categoryService) {
		return (args) -> {
			ProductCreateDto product = new ProductCreateDto();
			product.setProductName("Gaming Monitor");
			product.setProductBrand("Hp");
			product.setProductDetails("144 HZ Gaming Monitor");
			product.setProductPrice(2999.90);
			product.setStock(10);
			productService.add(product);

			ProductCreateDto product1 = new ProductCreateDto();
			product1.setProductName("Keyboard");
			product1.setProductBrand("Logitech");
			product1.setProductDetails("Red Switch");
			product1.setProductPrice(790.00);
			product1.setStock(50);
			productService.add(product1);

			ProductCreateDto product2 = new ProductCreateDto();
			product2.setProductName("Iphone XR");
			product2.setProductBrand("Apple");
			product2.setProductDetails("64GB Black Color");
			product2.setProductPrice(8999.90);
			product2.setStock(35);
			productService.add(product);

			Category category = new Category("Ev");
			categoryService.add(category);
			Category category1 = new Category("Bilgisayar");
			categoryService.add(category1);
			Category category2 = new Category("Telefon");
			categoryService.add(category2);
			Category category3 = new Category("Oyun");
			categoryService.add(category3);
			Category category4 = new Category("Giyim");
			categoryService.add(category4);
			Category category5 = new Category("Spor");
			categoryService.add(category5);
			Category category6 = new Category("Hobi");
			categoryService.add(category6);

		};

	}

}
