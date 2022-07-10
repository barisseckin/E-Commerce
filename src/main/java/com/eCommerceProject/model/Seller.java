package com.eCommerceProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SELLER")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany
    private List<SellerComment> sellerComment;

    public Seller(String name, String profilePictureUrl, String eMail, Date createDate) {
        this.name = name;
        this.profilePictureUrl = profilePictureUrl;
        this.eMail = eMail;
        this.createDate = createDate;
    }

}
