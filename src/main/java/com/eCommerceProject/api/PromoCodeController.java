package com.eCommerceProject.api;

import com.eCommerceProject.request.PromoCodeCreateRequest;
import com.eCommerceProject.service.PromoCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promo-code/")
@CrossOrigin
@RequiredArgsConstructor
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    @PostMapping("create-code")
    public ResponseEntity<?> createCode(@RequestBody PromoCodeCreateRequest promoCodeRequest) {
        promoCodeService.createPromoCode(promoCodeRequest);
        return ResponseEntity.ok("success");
    }
}
