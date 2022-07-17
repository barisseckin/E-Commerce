package com.eCommerceProject.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreateCodeServiceImpl implements CreateCodeService{

    @Override
    public String createCode() {
        int length = 5;

        return RandomString.make(length);
    }
}
