package com.eCommerceProject.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithProductDto {

    private int id;
    private String categoryName;
    private String productName;

}
