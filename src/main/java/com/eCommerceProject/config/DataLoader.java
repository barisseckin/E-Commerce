package com.eCommerceProject.config;

import com.eCommerceProject.model.Category;
import com.eCommerceProject.model.Product;
import com.eCommerceProject.repository.ProductRepository;
import com.eCommerceProject.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


/**
 * !!!! IMPORTANT INFORMATION !!!!
 * THIS CLASS CAN BE ELIGIBLE JUST FOR H2 in-memory DB
 * If you already change your configuration to switch DB system with
 * persistence DB (such as PostgreSQL or MySQL) you must either
 * comment out this `run` method or remove the whole class.
 */

@Component
@ConditionalOnProperty(name = "command.line.runner.enable", havingValue = "true")
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        Product product = new Product();
        product.setProductName("Gaming Monitor");
        product.setProductBrand("Hp");
        product.setProductDetails("144 HZ Gaming Monitor");
        product.setProductPrice(2999.90);
        product.setStock(1);
        product.setProductImageUrl("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSq90gpNuKH6RpNE_i" +
                "G5wyzwagNFpH-3SAOIiu4W-DPY4KUvlaVbk_z_ReQlMZ5_aq4F0u2vRKqZtj6QJMGvTbdbVR07yM0oSutCVEIDKWp&usqp=CAE");

        productRepository.save(product);

        Category category = new Category("Computer");
        categoryService.add(category);

    }
}
