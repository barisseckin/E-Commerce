package com.eCommerceProject.dto.createDto;

import lombok.Data;

@Data
public class ProductCreateDto {

    private String productName;
    private String productBrand;
    private String productDetails;
    private double productPrice;
    private int stock;
    private String productImageUrl;
}
