package com.eCommerceProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SELLER_COMMENT")
public class SellerComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    private User user;

    @ManyToOne
    private Seller seller;
}
