package com.eCommerceProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CREDİT_CARD")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "expirationDate")
    private String expirationDate;

    @Column(name = "nameAndSurname")
    private String nameAndSurname;

    @ManyToOne
    private User user;

    public CreditCard(String cardNumber, int cvv, String expirationDate, String nameAndSurname) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameAndSurname = nameAndSurname;
    }
}
