package com.eCommerceProject.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PushAllUserEmailRequest {

    @NotNull
    private String body;

    @NotNull
    private String title;
}
