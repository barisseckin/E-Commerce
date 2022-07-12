package com.eCommerceProject.request;

import lombok.Data;

@Data
public class ProductDetailsUpdateRequest {

    private int productId;

    private String productDetails;
}
