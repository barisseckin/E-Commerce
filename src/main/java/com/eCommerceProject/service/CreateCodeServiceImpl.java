package com.eCommerceProject.service;

import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class CreateCodeServiceImpl implements CreateCodeService{

    @Override
    public String createCode() {

        byte[] array = new byte[7];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}
