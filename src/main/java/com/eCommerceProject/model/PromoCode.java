package com.eCommerceProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PROMO_CODE")
public class PromoCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "amount")
    private int amount;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "expirationDate")
    private Date expirationDate;

    @ManyToOne
    private User user;
}
