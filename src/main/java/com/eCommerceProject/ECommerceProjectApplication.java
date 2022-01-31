package com.eCommerceProject;

import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
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
	CommandLineRunner createInitialProduct(ProductService productService) {
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

		};

	}

}
