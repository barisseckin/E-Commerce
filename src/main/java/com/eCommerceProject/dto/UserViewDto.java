package com.eCommerceProject.dto;

import com.eCommerceProject.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDto implements Serializable {

    private static final Long serialVersionID = 1L;

    private String userName;
    private String eMail;


    private UserViewDto(String userName, String eMail) {
        this.userName = userName;
        this.eMail = eMail;
    }

    public static UserViewDto of(User user) {
        return new UserViewDto(user.getUserName(), user.getEMail());
    }

}
