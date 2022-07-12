package com.eCommerceProject.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class PushEmailRequest {

    @Email
    private String eMail;

    @NotNull
    private String body;

    @NotNull
    private String title;

}
