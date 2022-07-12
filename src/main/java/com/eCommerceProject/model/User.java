package com.eCommerceProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "{com.eCommerceProject.notnull.username.message}")
    @Column(name = "username")
    private String userName;

    @NotNull(message = "{com.eCommerceProject.notnull.password.message}")
    @Column(name = "password")
    private String password;

    @Email(message = "{com.eCommerceProject.email.message}")
    @Column(name = "email")
    private String eMail;

    @Column(name = "createDate")
    private Date userCreateDate;

    @Column(name = "notificationPermission")
    private boolean notificationPermission = true;

    @OneToMany
    private List<SellerComment> sellerComment;

    @OneToMany
    private List<ProductComment> productComment;

    @ManyToOne
    private CreditCard creditCard;

    @OneToMany
    private List<Address> address;

    @OneToMany
    private List<PromoCode> promoCode;

    public User(String userName, String password, String eMail, Date userCreateDate, boolean notificationPermission) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.userCreateDate = userCreateDate;
        this.notificationPermission = notificationPermission;
    }

}
