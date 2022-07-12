package com.eCommerceProject.request;

import lombok.Data;

@Data
public class PromoCodeCreateRequest {

    private int userId;

    private double amount;

    private int year;

    private int month;

    private int date;

}
