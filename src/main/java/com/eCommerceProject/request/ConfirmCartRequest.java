package com.eCommerceProject.request;

import lombok.Data;

@Data
public class ConfirmCartRequest {

    private int id;

    private String cardNumber;

    private int cvv;

    private String expirationDate;

    private String nameAndSurname;

    private String promoCode;
}
