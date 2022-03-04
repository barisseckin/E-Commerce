package com.eCommerceProject;

import com.eCommerceProject.business.abstracts.CategoryService;
import com.eCommerceProject.business.abstracts.ProductService;
import com.eCommerceProject.dto.createDto.ProductCreateDto;
import com.eCommerceProject.model.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
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
			product.setProductImageUrl("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSq90gpNuKH6RpNE_i" +
					"G5wyzwagNFpH-3SAOIiu4W-DPY4KUvlaVbk_z_ReQlMZ5_aq4F0u2vRKqZtj6QJMGvTbdbVR07yM0oSutCVEIDKWp&usqp=CAE");
			productService.add(product);

			ProductCreateDto product1 = new ProductCreateDto();
			product1.setProductName("Keyboard");
			product1.setProductBrand("Logitech");
			product1.setProductDetails("Red Switch");
			product1.setProductPrice(790.00);
			product1.setStock(50);
			product1.setProductImageUrl("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcT-FAuhaD44fhEKfXVv" +
					"uGXnfJFlzM7DsHQZtqu2WkJO_mnLvdKdld5grlLwcMOd9ct6t23xrK9cG13vepmSGxpvGuxqiOuNPGU8bXimuqFsjL-j6FxpS-k4Mg&usqp=CAE");
			productService.add(product1);

			ProductCreateDto product2 = new ProductCreateDto();
			product2.setProductName("Iphone XR");
			product2.setProductBrand("Apple");
			product2.setProductDetails("64GB Black Color");
			product2.setProductPrice(8999.90);
			product2.setStock(35);
			product2.setProductImageUrl("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcSi6P35bRCBPuHXM2_vC3N_Xu" +
					"6UHhmp20jVNRrtJWD-CFNyhTouC-RBYJ_Lj-o2zAHB-RAGqxFb35zgR0w_7eAMawvBan4E46RB9LObq-Q8_FM_YXxACZS9&usqp=CAE");
			productService.add(product2);

			ProductCreateDto product3 = new ProductCreateDto();
			product3.setProductName("İphone 13");
			product3.setProductBrand("Apple");
			product3.setProductDetails("128GB Siyah renk Apple Türkiye 24 ay garantili");
			product3.setProductPrice(19999.99);
			product3.setProductImageUrl("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcTWERVFBkkwF2t" +
					"MrvO6oGFRyygN69QcFqQybZc8UA9fMURlCkPlI8UkviU94txAvaJURYWlUoTpC8onFqeirYFxMOKlMG9XUXaIRUrXTUsxrWGukRUXptif&usqp=CAE");
			product3.setStock(7);
			productService.add(product3);

			ProductCreateDto product4 = new ProductCreateDto();
			product4.setProductName("Kodlab Eğitim Seti");
			product4.setProductBrand("Kodlab");
			product4.setProductDetails("Kodlab yayınları yazılım gelliştirici eğitim seti");
			product4.setProductPrice(89);
			product4.setProductImageUrl("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcS-I3QWHAaFYRh7Ril70zJO9riE" +
					"dkrFgsY6pVp6JJgiLR5XzGdNiaMCh8T9C_SLPDM91eh_ljg5OYO6M1Zk5aPiUfWywjWuRCxqueMmSEPX3d4tPJ10vAU0&usqp=CAE");
			product4.setStock(68);
			productService.add(product4);

			ProductCreateDto product5 = new ProductCreateDto();
			product5.setProductName("Gaming Koltuk");
			product5.setProductBrand("xDrive");
			product5.setProductDetails("Fonksiyonel oyuncu koltuğu");
			product5.setProductPrice(2490.99);
			product5.setProductImageUrl("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQBM9gJKF5pWnWXQAUDjulevMk59-7Z0vLE-xri4__" +
					"XtHnm-GF1miW-XTie2EqvN5YMnXJvfogLnPWYhR65UkavAO8qCh1NwZ4_UWaAUwyqTtSmU-Dsr9C5pQ&usqp=CAE");
			product5.setStock(10);
			productService.add(product5);

			ProductCreateDto product6 = new ProductCreateDto();
			product6.setProductName("Apple Macbook Pro");
			product6.setProductBrand("Apple");
			product6.setProductDetails("16 GB Ram 512 GB dahili hafıza silver");
			product6.setProductPrice(26999.99);
			product6.setProductImageUrl("https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcTnsmpIVcVd8ZHGL2QA2xC9wjn0EEMBtSi" +
					"I1dUNeoekiD_icGR6ZVpVrUcRfVBi4eVKFQgiiq2aiE0eoyeTFqz_SbGO2-vhjGQwVf9AOs0qJRFAbuWetGzXkg&usqp=CAE");
			product6.setStock(9);
			productService.add(product6);

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

