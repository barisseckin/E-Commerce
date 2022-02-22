package com.eCommerceProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


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


    public User(String userName, String password, String eMail) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
    }

}
