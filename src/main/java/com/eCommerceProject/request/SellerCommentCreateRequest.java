package com.eCommerceProject.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SellerCommentCreateRequest {

    private String title;

    private String body;

    @NotNull
    @Min(value = 1)
    private int rating;

    private Date createDate;

    public SellerCommentCreateRequest(String title, String body, int rating, Date createDate) {
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.createDate = createDate;
    }
}
