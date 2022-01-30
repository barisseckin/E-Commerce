package com.eCommerceProject.dto;

import com.eCommerceProject.model.Product;
import lombok.Getter;


@Getter
public class ProductViewDto {

    private String productName;
    private String productBrand;
    private String productDetails;
    private double productPrice;

    private ProductViewDto(String productName, String productBrand, String productDetails, double productPrice) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
    }

    public static ProductViewDto of(Product product) {
        return new ProductViewDto(product.getProductName(), product.getProductBrand(),
                product.getProductDetails(), product.getProductPrice());
    }


}
