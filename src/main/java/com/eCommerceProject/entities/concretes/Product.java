package com.eCommerceProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_details")
    private String productDetails;

    @Min(value = 1, message = "{com.eCommerceProject.Min.price.message}")
    @Column(name = "product_price")
    private double productPrice;

    @Min(value = 1, message = "{com.eCommerceProject.Min.stock.message}")
    @Column(name = "stock")
    private int stock;

    /*
    @ManyToOne                   //i need to edit the test section
    private Category category;
    */

}
