package com.eCommerceProject.service;

import com.eCommerceProject.model.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAll();
    CreditCard add(CreditCard creditCard);
    List<CreditCard> getCreditCardByUserId(int id);
    CreditCard getBydId(int id);
}
