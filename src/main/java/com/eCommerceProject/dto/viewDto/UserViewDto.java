package com.eCommerceProject.dto.viewDto;

import com.eCommerceProject.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDto implements Serializable {

    private static final Long serialVersionID = 1L;

    private final String userName;
    private final String eMail;


    private UserViewDto(String userName, String eMail) {
        this.userName = userName;
        this.eMail = eMail;
    }

    public static UserViewDto of(User user) {
        return new UserViewDto(user.getUserName(), user.getEMail());
    }

}
