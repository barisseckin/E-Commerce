package com.eCommerceProject.service;

import com.eCommerceProject.model.PromoCode;
import com.eCommerceProject.request.PromoCodeCreateRequest;

import java.util.List;

public interface PromoCodeService {
    String createPromoCode(PromoCodeCreateRequest promoCodeRequest);
    List<PromoCode> getAll();
    PromoCode getById(Long id);
    void deleteById(Long id);
}
