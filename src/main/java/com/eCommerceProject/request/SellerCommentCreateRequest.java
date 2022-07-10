package com.eCommerceProject.request;

import lombok.Data;

@Data
public class SellerCommentCreateRequest {

    private String title;

    private String body;

    private int rating;

}
